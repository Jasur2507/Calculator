package com.java_mentor;

import com.java_mentor.service.CalculatorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorService calculatorService = new CalculatorService();
        System.out.println("Calculator");
        String a = "";
        String b = "";
        int x, y;
        char operator = 0;

        System.out.println("Input: ");
        String input = scanner.nextLine();
        input = input.replaceAll(" ", "");

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                a = input.substring(0, i);
                b = input.substring(i + 1);
                operator = input.charAt(i);
            }
        }

        int aType = calculatorService.typeOfString(a);
        int bType = calculatorService.typeOfString(b);

        if (aType != -1 && aType == bType) {
            x = calculatorService.stringToInt(a);
            y = calculatorService.stringToInt(b);
        } else {
            System.err.println("Wrong operands!");
            return;
        }

        System.out.println("Output: ");
        switch (operator) {
            case '+':
                System.out.println(calculatorService.plus(x, y, aType));
                break;
            case '-':
                System.out.println(calculatorService.minus(x, y, aType));
                break;
            case '*':
                System.out.println(calculatorService.multiply(x, y, aType));
                break;
            case '/':
                System.out.println(calculatorService.division(x, y, aType));
                break;
            default:
                System.out.println("Wrong operand!");
        }
    }
}
