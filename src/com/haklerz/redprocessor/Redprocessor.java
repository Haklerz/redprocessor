package com.haklerz.redprocessor;

import java.util.Scanner;

/**
 * Redprocessor
 */
public class Redprocessor {
    private byte[] stack;
    private int stackSize;

    public Redprocessor(int stackSize) {
        this.stack = new byte[stackSize];
        this.stackSize = 0;
    }

    public void interpret(byte[] bytecode) {

        int instructionAddress = 0;
        boolean isHalted = false;

        Scanner scanner = new Scanner(System.in);

        while (!isHalted) {
            // Fetch
            byte code = bytecode[instructionAddress++];

            // Decode
            Instruction instruction = Instruction.valueOfCode(code);

            // Execute
            switch (instruction) {
                case ADD: {
                    byte b = pop();
                    byte a = pop();

                    push(a + b);
                }
                    break;

                case BRC:
                    break;

                case BRN: {
                    byte skip = bytecode[instructionAddress];
                    instructionAddress += skip;
                }
                    break;

                case BRZ:
                    break;

                case HLT: {
                    isHalted = true;
                }
                    break;

                case IN: {
                    byte value = Byte.parseByte(scanner.nextLine().trim());
                    push(value);
                }
                    break;

                case NOP:
                    break;

                case OUT: {
                    byte value = pop();
                    System.out.println(value);
                }
                    break;

                case POP:
                    break;

                case PUSH:
                    break;

                case PUSHI: {
                    push(bytecode[instructionAddress++]);
                }
                    break;

                case SUB: {
                    byte b = pop();
                    byte a = pop();

                    push(a - b);
                }
                    break;

                default:
                    break;
            }
        }
    }

    private void push(int value) {
        stack[stackSize++] = (byte) value;
    }

    private byte pop() {
        return stack[--stackSize];
    }
}