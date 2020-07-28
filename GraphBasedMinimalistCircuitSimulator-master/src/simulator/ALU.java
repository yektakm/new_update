package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.Adder;

public class ALU extends Wrapper {
    public ALU(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Subtractor subtractor = new Subtractor("Sub" , "64X33");
        Adder adder = new Adder("Add" , "64X33");
        OR32Bit or32Bit = new OR32Bit("OR" , "64X32");
        AND32Bit and32Bit = new AND32Bit("AND" , "64X32");

        subtractor.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        adder.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        or32Bit.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        and32Bit.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3) , getInput(4) , getInput(5) , getInput(6) , getInput(7) , getInput(8) , getInput(9) , getInput(10) , getInput(11) , getInput(12) , getInput(13)  , getInput(14) , getInput(15) , getInput(16) , getInput(17) , getInput(18) , getInput(19) , getInput(20) , getInput(21) , getInput(22) , getInput(23) , getInput(24) , getInput(25) , getInput(26) , getInput(27) , getInput(28) , getInput(29) , getInput(30) , getInput(31) , getInput(32) , getInput(33) , getInput(34) , getInput(35) , getInput(36) , getInput(37) , getInput(38) , getInput(39) , getInput(40) , getInput(41) , getInput(42) , getInput(43) , getInput(44) , getInput(45) , getInput(46) , getInput(47) , getInput(48) , getInput(49) , getInput(50) , getInput(51) , getInput(52) , getInput(53) , getInput(54) , getInput(55) , getInput(56) , getInput(57) , getInput(58) , getInput(59) , getInput(60) , getInput(61) , getInput(62) , getInput(63));

        Not n64 = new Not("not" , getInput(64));
        Not n65 = new Not("not" , getInput(65));
        Not n66 = new Not("not" , getInput(66));
        Not n67 = new Not("not" , getInput(67));

        And a1 = new And("and" , n64.getOutput(0) , n65.getOutput(0) , getInput(66) , n67.getOutput(0));
        And a2 = new And("and" , n64.getOutput(0) , getInput(65) , getInput(66) , n67.getOutput(0));
        And a3 = new And("and" , n64.getOutput(0) , n65.getOutput(0) ,n66.getOutput(0) , n67.getOutput(0));
        And a4 = new And("and" , n64.getOutput(0) , n65.getOutput(0) , n66.getOutput(0) , getInput(67));

        AND32Bit and32Bit1 = new AND32Bit("and" , "64X32");
        and32Bit1.addInput(  adder.getOutput(1) , adder.getOutput(2) , adder.getOutput(3) , adder.getOutput(4) , adder.getOutput(5) , adder.getOutput(6) , adder.getOutput(7) , adder.getOutput(8) , adder.getOutput(9) , adder.getOutput(10) , adder.getOutput(11) , adder.getOutput(12), adder.getOutput(13) , adder.getOutput(14) , adder.getOutput(15) , adder.getOutput(16) , adder.getOutput(17) , adder.getOutput(18) , adder.getOutput(19) , adder.getOutput(20) , adder.getOutput(21) , adder.getOutput(22) , adder.getOutput(23) , adder.getOutput(24) , adder.getOutput(25) , adder.getOutput(26) , adder.getOutput(27) , adder.getOutput(28) , adder.getOutput(29) , adder.getOutput(30) , adder.getOutput(31) , adder.getOutput(32) );

        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));
        and32Bit1.addInput(a1.getOutput(0));


        AND32Bit and32Bit2 = new AND32Bit("and" , "64X32");
        and32Bit2.addInput( subtractor.getOutput(0) , subtractor.getOutput(1) , subtractor.getOutput(2) , subtractor.getOutput(3) , subtractor.getOutput(4) , subtractor.getOutput(5) , subtractor.getOutput(6) , subtractor.getOutput(7) , subtractor.getOutput(8) , subtractor.getOutput(9) , subtractor.getOutput(10) , subtractor.getOutput(11) , subtractor.getOutput(12), subtractor.getOutput(13) , subtractor.getOutput(14) , subtractor.getOutput(15) , subtractor.getOutput(16) , subtractor.getOutput(17) , subtractor.getOutput(18) , subtractor.getOutput(19) , subtractor.getOutput(20) , subtractor.getOutput(21) , subtractor.getOutput(22) , subtractor.getOutput(23) , subtractor.getOutput(24) , subtractor.getOutput(25) , subtractor.getOutput(26) , subtractor.getOutput(27) , subtractor.getOutput(28) , subtractor.getOutput(29) , subtractor.getOutput(30) , subtractor.getOutput(31) );
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));
        and32Bit2.addInput(a2.getOutput(0));

        AND32Bit and32Bit3 = new AND32Bit("and" , "64X32");
        and32Bit3.addInput(and32Bit.getOutput(0) , and32Bit.getOutput(1) , and32Bit.getOutput(2) , and32Bit.getOutput(3) , and32Bit.getOutput(4) , and32Bit.getOutput(5) , and32Bit.getOutput(6) , and32Bit.getOutput(7) , and32Bit.getOutput(8) , and32Bit.getOutput(9) , and32Bit.getOutput(10) , and32Bit.getOutput(11) , and32Bit.getOutput(12), and32Bit.getOutput(13) , and32Bit.getOutput(14) , and32Bit.getOutput(15) , and32Bit.getOutput(16) , and32Bit.getOutput(17) , and32Bit.getOutput(18) , and32Bit.getOutput(19) , and32Bit.getOutput(20) , and32Bit.getOutput(21) , and32Bit.getOutput(22) , and32Bit.getOutput(23) , and32Bit.getOutput(24) , and32Bit.getOutput(25) , and32Bit.getOutput(26) , and32Bit.getOutput(27) , and32Bit.getOutput(28) , and32Bit.getOutput(29) , and32Bit.getOutput(30) , and32Bit.getOutput(31));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));
        and32Bit3.addInput(a3.getOutput(0));

        AND32Bit and32Bit4 = new AND32Bit("and" , "64X32");
        and32Bit4.addInput(or32Bit.getOutput(0) , or32Bit.getOutput(1) , or32Bit.getOutput(2) , or32Bit.getOutput(3) , or32Bit.getOutput(4) , or32Bit.getOutput(5) , or32Bit.getOutput(6) , or32Bit.getOutput(7) , or32Bit.getOutput(8) , or32Bit.getOutput(9) , or32Bit.getOutput(10) , or32Bit.getOutput(11) , or32Bit.getOutput(12), or32Bit.getOutput(13) , or32Bit.getOutput(14) , or32Bit.getOutput(15) , or32Bit.getOutput(16) , or32Bit.getOutput(17) , or32Bit.getOutput(18) , or32Bit.getOutput(19) , or32Bit.getOutput(20) , or32Bit.getOutput(21) , or32Bit.getOutput(22) , or32Bit.getOutput(23) , or32Bit.getOutput(24) , or32Bit.getOutput(25) , or32Bit.getOutput(26) , or32Bit.getOutput(27) , or32Bit.getOutput(28) , or32Bit.getOutput(29) , or32Bit.getOutput(30) , or32Bit.getOutput(31));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));
        and32Bit4.addInput(a4.getOutput(0));

        OR32Bit or32Bit1 = new OR32Bit("or" , "64X32");
        OR32Bit or32Bit2 = new OR32Bit("or" , "64X32");
        OR32Bit or32Bit3 = new OR32Bit("or" , "64X32");

        or32Bit1.addInput(and32Bit1.getOutput(0), and32Bit1.getOutput(1) , and32Bit1.getOutput(2) , and32Bit1.getOutput(3) , and32Bit1.getOutput(4) , and32Bit1.getOutput(5) , and32Bit1.getOutput(6) , and32Bit1.getOutput(7) , and32Bit1.getOutput(8) , and32Bit1.getOutput(9) , and32Bit1.getOutput(10) , and32Bit1.getOutput(11) , and32Bit1.getOutput(12) , and32Bit1.getOutput(13) , and32Bit1.getOutput(14) , and32Bit1.getOutput(15) , and32Bit1.getOutput(16) , and32Bit1.getOutput(17) , and32Bit1.getOutput(18) , and32Bit1.getOutput(19) , and32Bit1.getOutput(20) , and32Bit1.getOutput(21) , and32Bit1.getOutput(22) , and32Bit1.getOutput(23) , and32Bit1.getOutput(24) , and32Bit1.getOutput(25) , and32Bit1.getOutput(26) , and32Bit1.getOutput(27) , and32Bit1.getOutput(28) , and32Bit1.getOutput(29) , and32Bit1.getOutput(30) , and32Bit1.getOutput(31) );
        or32Bit1.addInput(and32Bit2.getOutput(0), and32Bit2.getOutput(1) , and32Bit2.getOutput(2) , and32Bit2.getOutput(3) , and32Bit2.getOutput(4) , and32Bit2.getOutput(5) , and32Bit2.getOutput(6) , and32Bit2.getOutput(7) , and32Bit2.getOutput(8) , and32Bit2.getOutput(9) , and32Bit2.getOutput(10) , and32Bit2.getOutput(11) , and32Bit2.getOutput(12) , and32Bit2.getOutput(13) , and32Bit2.getOutput(14) , and32Bit2.getOutput(15) , and32Bit2.getOutput(16) , and32Bit2.getOutput(17) , and32Bit2.getOutput(18) , and32Bit2.getOutput(19) , and32Bit2.getOutput(20) , and32Bit2.getOutput(21) , and32Bit2.getOutput(22) , and32Bit2.getOutput(23) , and32Bit2.getOutput(24) , and32Bit2.getOutput(25) , and32Bit2.getOutput(26) , and32Bit2.getOutput(27) , and32Bit2.getOutput(28) , and32Bit2.getOutput(29) , and32Bit2.getOutput(30) , and32Bit2.getOutput(31) );

        or32Bit2.addInput(and32Bit3.getOutput(0), and32Bit3.getOutput(1) , and32Bit3.getOutput(2) , and32Bit3.getOutput(3) , and32Bit3.getOutput(4) , and32Bit3.getOutput(5) , and32Bit3.getOutput(6) , and32Bit3.getOutput(7) , and32Bit3.getOutput(8) , and32Bit3.getOutput(9) , and32Bit3.getOutput(10) , and32Bit3.getOutput(11) , and32Bit3.getOutput(12) , and32Bit3.getOutput(13) , and32Bit3.getOutput(14) , and32Bit3.getOutput(15) , and32Bit3.getOutput(16) , and32Bit3.getOutput(17) , and32Bit3.getOutput(18) , and32Bit3.getOutput(19) , and32Bit3.getOutput(20) , and32Bit3.getOutput(21) , and32Bit3.getOutput(22) , and32Bit3.getOutput(23) , and32Bit3.getOutput(24) , and32Bit3.getOutput(25) , and32Bit3.getOutput(26) , and32Bit3.getOutput(27) , and32Bit3.getOutput(28) , and32Bit3.getOutput(29) , and32Bit3.getOutput(30) , and32Bit3.getOutput(31) );
        or32Bit2.addInput(and32Bit4.getOutput(0), and32Bit4.getOutput(1) , and32Bit4.getOutput(2) , and32Bit4.getOutput(3) , and32Bit4.getOutput(4) , and32Bit4.getOutput(5) , and32Bit4.getOutput(6) , and32Bit4.getOutput(7) , and32Bit4.getOutput(8) , and32Bit4.getOutput(9) , and32Bit4.getOutput(10) , and32Bit4.getOutput(11) , and32Bit4.getOutput(12) , and32Bit4.getOutput(13) , and32Bit4.getOutput(14) , and32Bit4.getOutput(15) , and32Bit4.getOutput(16) , and32Bit4.getOutput(17) , and32Bit4.getOutput(18) , and32Bit4.getOutput(19) , and32Bit4.getOutput(20) , and32Bit4.getOutput(21) , and32Bit4.getOutput(22) , and32Bit4.getOutput(23) , and32Bit4.getOutput(24) , and32Bit4.getOutput(25) , and32Bit4.getOutput(26) , and32Bit4.getOutput(27) , and32Bit4.getOutput(28) , and32Bit4.getOutput(29) , and32Bit4.getOutput(30) , and32Bit4.getOutput(31) );

        or32Bit3.addInput(or32Bit1.getOutput(0));
        or32Bit3.addInput(or32Bit1.getOutput(1));
        or32Bit3.addInput(or32Bit1.getOutput(2));
        or32Bit3.addInput(or32Bit1.getOutput(3));
        or32Bit3.addInput(or32Bit1.getOutput(4));
        or32Bit3.addInput(or32Bit1.getOutput(5));
        or32Bit3.addInput(or32Bit1.getOutput(6));
        or32Bit3.addInput(or32Bit1.getOutput(7));
        or32Bit3.addInput(or32Bit1.getOutput(8));
        or32Bit3.addInput(or32Bit1.getOutput(9));
        or32Bit3.addInput(or32Bit1.getOutput(10));
        or32Bit3.addInput(or32Bit1.getOutput(11));
        or32Bit3.addInput(or32Bit1.getOutput(12));
        or32Bit3.addInput(or32Bit1.getOutput(13));
        or32Bit3.addInput(or32Bit1.getOutput(14));
        or32Bit3.addInput(or32Bit1.getOutput(15));
        or32Bit3.addInput(or32Bit1.getOutput(16));
        or32Bit3.addInput(or32Bit1.getOutput(17));
        or32Bit3.addInput(or32Bit1.getOutput(18));
        or32Bit3.addInput(or32Bit1.getOutput(19));
        or32Bit3.addInput(or32Bit1.getOutput(20));
        or32Bit3.addInput(or32Bit1.getOutput(21));
        or32Bit3.addInput(or32Bit1.getOutput(22));
        or32Bit3.addInput(or32Bit1.getOutput(23));
        or32Bit3.addInput(or32Bit1.getOutput(24));
        or32Bit3.addInput(or32Bit1.getOutput(25));
        or32Bit3.addInput(or32Bit1.getOutput(26));
        or32Bit3.addInput(or32Bit1.getOutput(27));
        or32Bit3.addInput(or32Bit1.getOutput(28));
        or32Bit3.addInput(or32Bit1.getOutput(29));
        or32Bit3.addInput(or32Bit1.getOutput(30));
        or32Bit3.addInput(or32Bit1.getOutput(31));

        or32Bit3.addInput(or32Bit2.getOutput(0));
        or32Bit3.addInput(or32Bit2.getOutput(1));
        or32Bit3.addInput(or32Bit2.getOutput(2));
        or32Bit3.addInput(or32Bit2.getOutput(3));
        or32Bit3.addInput(or32Bit2.getOutput(4));
        or32Bit3.addInput(or32Bit2.getOutput(5));
        or32Bit3.addInput(or32Bit2.getOutput(6));
        or32Bit3.addInput(or32Bit2.getOutput(7));
        or32Bit3.addInput(or32Bit2.getOutput(8));
        or32Bit3.addInput(or32Bit2.getOutput(9));
        or32Bit3.addInput(or32Bit2.getOutput(10));
        or32Bit3.addInput(or32Bit2.getOutput(11));
        or32Bit3.addInput(or32Bit2.getOutput(12));
        or32Bit3.addInput(or32Bit2.getOutput(13));
        or32Bit3.addInput(or32Bit2.getOutput(14));
        or32Bit3.addInput(or32Bit2.getOutput(15));
        or32Bit3.addInput(or32Bit2.getOutput(16));
        or32Bit3.addInput(or32Bit2.getOutput(17));
        or32Bit3.addInput(or32Bit2.getOutput(18));
        or32Bit3.addInput(or32Bit2.getOutput(19));
        or32Bit3.addInput(or32Bit2.getOutput(20));
        or32Bit3.addInput(or32Bit2.getOutput(21));
        or32Bit3.addInput(or32Bit2.getOutput(22));
        or32Bit3.addInput(or32Bit2.getOutput(23));
        or32Bit3.addInput(or32Bit2.getOutput(24));
        or32Bit3.addInput(or32Bit2.getOutput(25));
        or32Bit3.addInput(or32Bit2.getOutput(26));
        or32Bit3.addInput(or32Bit2.getOutput(27));
        or32Bit3.addInput(or32Bit2.getOutput(28));
        or32Bit3.addInput(or32Bit2.getOutput(29));
        or32Bit3.addInput(or32Bit2.getOutput(30));
        or32Bit3.addInput(or32Bit2.getOutput(31));

        addOutput(or32Bit3.getOutput(0));
        addOutput(or32Bit3.getOutput(1));
        addOutput(or32Bit3.getOutput(2));
        addOutput(or32Bit3.getOutput(3));
        addOutput(or32Bit3.getOutput(4));
        addOutput(or32Bit3.getOutput(5));
        addOutput(or32Bit3.getOutput(6));
        addOutput(or32Bit3.getOutput(7));
        addOutput(or32Bit3.getOutput(8));
        addOutput(or32Bit3.getOutput(9));
        addOutput(or32Bit3.getOutput(10));
        addOutput(or32Bit3.getOutput(11));
        addOutput(or32Bit3.getOutput(12));
        addOutput(or32Bit3.getOutput(13));
        addOutput(or32Bit3.getOutput(14));
        addOutput(or32Bit3.getOutput(15));
        addOutput(or32Bit3.getOutput(16));
        addOutput(or32Bit3.getOutput(17));
        addOutput(or32Bit3.getOutput(18));
        addOutput(or32Bit3.getOutput(19));
        addOutput(or32Bit3.getOutput(20));
        addOutput(or32Bit3.getOutput(21));
        addOutput(or32Bit3.getOutput(22));
        addOutput(or32Bit3.getOutput(23));
        addOutput(or32Bit3.getOutput(24));
        addOutput(or32Bit3.getOutput(25));
        addOutput(or32Bit3.getOutput(26));
        addOutput(or32Bit3.getOutput(27));
        addOutput(or32Bit3.getOutput(28));
        addOutput(or32Bit3.getOutput(29));
        addOutput(or32Bit3.getOutput(30));
        addOutput(or32Bit3.getOutput(31));


    }
}