package com.haklerz.redprocessor;

public class RedprocessorTest {
    public static void main(String[] args) {
        Redprocessor red = new Redprocessor(64);

        byte[] code = {
            Instruction.PUSHI.code,
            6,
            Instruction.PUSHI.code,
            4,
            Instruction.ADD.code,
            Instruction.OUT.code,
            Instruction.HLT.code
        };

        red.interpret(code);
    }
}
