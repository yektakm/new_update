//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.wrappers.*;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Sample {
    public static void main(String[] args) {

        //sample circuit
        Clock clock = new Clock("CLOCK", 1000);
        DFlipFlop shoift0 = new DFlipFlop("SHIFT0", "2X2", clock.getOutput(0), Simulator.falseLogic);
        DFlipFlop shoift1 = new DFlipFlop("SHIFT1", "2X2", clock.getOutput(0), shoift0.getOutput(0));

        DFlipFlop[] pc = new DFlipFlop[32];
        for (int i =0; i < 32; ++i) {
            pc[i] = new DFlipFlop("D" + i, "2X2", clock.getOutput(0));
        }
        Link[] pcInit = new Link[32];
        for (int i = 0; i < 32; ++i) {
            pcInit[i] = Simulator.falseLogic;
        }

        Adder adder = new Adder("ADDER", "64X33");
        for (int i =0; i < 32; ++i) {
            adder.addInput(pc[i].getOutput(0));
        }
        Link[] four = new Link[32];
        for (int i =0; i < 29; ++i) {
            four[i] = Simulator.falseLogic;
        }
        four[29] = Simulator.trueLogic;
        four[30] = Simulator.falseLogic;
        four[31] = Simulator.falseLogic;

        adder.addInput(four);


        // must be changed

        ByteMemory mem = new ByteMemory("Instruction MEMORY");
        ByteMemory dataMem = new ByteMemory("Data MEMORY");
        RegisterFile registerFile = new RegisterFile("RegFile" , "49X64");
        ControlUnit controlUnit = new ControlUnit("ControlUnit" , "6X9");
        AluControlUnit aluControlUnit = new AluControlUnit("AluControlUnit" , "8X4");
        ALU alu = new ALU("ALU" , "68X32");

        Boolean[][] temp = new Boolean[65536][8];
        for (int i = 0; i < 65536; ++i) {
            for (int j = 0; j < 8; ++j) {
                temp[i][j] = false;
            }
        }

        Boolean[][] temp2 = new Boolean[65536][8];
        for (int i = 0; i < 65536; ++i) {
            for (int j = 0; j < 8; ++j) {
                temp[i][j] = false;
            }
        }

        temp[3][2] = true;
        temp[1][2] = true;

        mem.setMemory(temp);
        dataMem.setMemory(temp2);

        //write -----> dont really think so :/
        mem.addInput(Simulator.falseLogic);

        //address
        for (int i = 0; i < 16; ++i) {
            mem.addInput(pc[i + 16].getOutput(0));
        }

        //input
        for (int i = 0; i < 16; ++i) {
            mem.addInput(Simulator.falseLogic);
        }
        for (int i = 16; i < 32; ++i) {
            mem.addInput(Simulator.trueLogic);
        }

        for ( int i=0 ; i<6 ; i++){ // 6 bit of instruction goes to control unit (OPCode)
            controlUnit.addInput(mem.getOutput(i));
        }

        // alu control unit gets input
        aluControlUnit.addInput(controlUnit.getOutput(7) , controlUnit.getOutput(8));
        for (int i=26 ; i<32 ; i++ ){
            aluControlUnit.addInput(mem.getOutput(i));
        }

        registerFile.addInput(clock.getOutput(0) , controlUnit.getOutput(3));

        for ( int i=6 ; i<11 ; i++){ //
            registerFile.addInput(mem.getOutput(i));
        }
        for ( int i=11 ; i<16 ; i++){ //
            registerFile.addInput(mem.getOutput(i));
        }

        // 5 bit Reg Destination
        MultiPlexer multiPlexer0 = new MultiPlexer("mux" , "3X1" , mem.getOutput(11) , mem.getOutput(16) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer1 = new MultiPlexer("mux" , "3X1" , mem.getOutput(12) , mem.getOutput(17) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer2 = new MultiPlexer("mux" , "3X1" , mem.getOutput(13) , mem.getOutput(18) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer3 = new MultiPlexer("mux" , "3X1" , mem.getOutput(14) , mem.getOutput(19) , controlUnit.getOutput(0));
        MultiPlexer multiPlexer4 = new MultiPlexer("mux" , "3X1" , mem.getOutput(15) , mem.getOutput(20) , controlUnit.getOutput(0));

        registerFile.addInput(multiPlexer0.getOutput(0) , multiPlexer1.getOutput(0) , multiPlexer2.getOutput(0) , multiPlexer3.getOutput(0) , multiPlexer4.getOutput(0));

        //32 bit Write Data to RegFile later



        SignExtend16X32 signExtend16X32 = new SignExtend16X32("SignEx" , "16X32");
        for (int i=16 ; i<32 ; i++){
            signExtend16X32.addInput(mem.getOutput(i));
        }

        Shift2Times shift2Times = new Shift2Times("Shift left 2" , "32X32");
        for (int i=0 ; i<32 ; i++){
            shift2Times.addInput(signExtend16X32.getOutput(i));
        }

        Multiplexer[] AluSRCSelect = new Multiplexer[32];
        for (int i =0; i < 32; ++i) {
            AluSRCSelect[i] = new Multiplexer("M" + i, "3X1",
                    controlUnit.getOutput(1), registerFile.getOutput(i), signExtend16X32.getOutput(i));
        }

        for (int i=0 ; i<32 ; i++){
            alu.addInput(registerFile.getOutput(i));
        }
        for (int i=0 ; i<32 ; i++){
            alu.addInput(AluSRCSelect[i].getOutput(0));
        }
        for (int i=0 ; i<4 ; i++){
            alu.addInput(aluControlUnit.getOutput(i));
        }


        Adder adder1 = new Adder("adder1" , "64X33");
        for (int i=0 ; i<32 ; i++){
            adder1.addInput(adder.getOutput(i+1));
        }
        for (int i=0 ; i<32 ; i++){
            adder1.addInput(shift2Times.getOutput(i));
        }

        Link DataMemoryReadOrWrite = new Link(false);
        //address
        for (int i = 0; i < 16; ++i) {
            dataMem.addInput(alu.getOutput(i + 16));
        }

        //input
        for (int i = 0; i < 32; ++i) {
            dataMem.addInput(registerFile.getOutput(i + 32));
        }

        Multiplexer[] MemToRegister = new Multiplexer[32];
        for (int i =0; i < 32; ++i) {
            MemToRegister[i] = new Multiplexer("M" + i, "3X1",
                    controlUnit.getOutput(2), alu.getOutput(i), dataMem.getOutput(i));
        }

        for (int i=0 ; i<32 ; i++){
            registerFile.addInput(MemToRegister[i].getOutput(0));
        }

        And zero = new And("Zero");
        for (int i=0 ; i<32 ; i++){
            zero.addInput(alu.getOutput(i));
        }
        And ifbranch = new And("branch" , zero.getOutput(0) , controlUnit.getOutput(6));
        Multiplexer[] branch = new Multiplexer[32];
        for (int i =0; i < 32; ++i) {
            branch[i] = new Multiplexer("M" + i, "3X1",
                    ifbranch.getOutput(0), adder.getOutput(i), adder1.getOutput(i));
        }

//        for (int i =0; i < 32; ++i) {
//            pc[i].addInput(branch[i].getOutput(0));
//        }

        Multiplexer[] counterSelect = new Multiplexer[32];
        for (int i =0; i < 32; ++i) {
            counterSelect[i] = new Multiplexer("M" + i, "3X1",
                    shoift1.getOutput(0), branch[i].getOutput(0), pcInit[i]);
        }
        for (int i =0; i < 32; ++i) {
            pc[i].addInput(counterSelect[i].getOutput(0));
        }

        Simulator.debugger.addTrackItem(clock, mem , registerFile , controlUnit , signExtend16X32 , alu , aluControlUnit , shift2Times , dataMem );
        Simulator.debugger.setDelay(1000);
        Simulator.circuit.startCircuit();
    }
}