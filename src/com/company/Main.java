package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение [2+2] или два римских числа от I до X");
        String userInput = scanner.nextLine();
        char[] ch = new char[10];
        char operation = 0;
        for (int i = 0; i < userInput.length(); i++) {
            ch[i] = userInput.charAt(i);
            if (ch[i] == '+') {
                operation = '+';
            }
            if (ch[i] == '-') {
                operation = '-';
            }
            if (ch[i] == '*') {
                operation = '*';
            }
            if (ch[i] == '/') {
                operation = '/';
            }
        }
        String charString = String.valueOf(ch);
        String[] blacks = charString.split("[+-/*]");
        String stable1 = blacks[0];
        String stable2 = blacks[1];
        String stable3 = stable2.trim();
        int number1 = romanToNumber(stable1);
        int number2 = romanToNumber(stable3);
        int result;
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            System.out.println("----Результат для римских цифр----");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable1 + " " + operation + " " + stable3 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stable1);
        number2 = Integer.parseInt(stable3);
        result = calculated(number1, number2, operation);
        System.out.println("----Результат для арабских цифр----");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Допускаются только целочисленные ненулевые параметры");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
