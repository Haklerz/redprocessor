package com.haklerz.redprocessor;

import java.util.Map;
import java.util.HashMap;

public enum Instruction {
    NOP(0x0), PUSHI(0x1), PUSH(0x2), POP(0x3), IN(0x4), OUT(0x5), ADD(0x6), SUB(0x7), BRN(0x8), BRZ(0x9), BRC(0xA),
    HLT(0xB);

    private static final Map<Byte, Instruction> BY_CODE = new HashMap<>();
    static {
        for (Instruction instruction : values()) {
            BY_CODE.put(instruction.code, instruction);
        }
    }

    public final byte code;

    private Instruction(int code) {
        this.code = (byte) code;
    }

    public static Instruction valueOfCode(byte code) {
        return BY_CODE.get(code);
    }
}
