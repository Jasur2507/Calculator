package com.java_mentor.service;

import java.util.HashMap;
import java.util.Map;

public class CalculatorService implements Calculator{
    @Override
    public String plus(int a, int b, int type) {
        int result=a+b;
        if (type==1){
            return decimalToRoman(result);
        }
        return String.valueOf(result);
    }

    @Override
    public String minus(int a, int b, int type) {
        if (a<=b){
            return "The first operand must be more than second operand!";
        }
        int result=a-b;
        if (type==1){
            return decimalToRoman(result);
        }
        return String.valueOf(result);
    }

    @Override
    public String multiply(int a, int b, int type) {
        int result=a*b;
        if (type==1){
            return decimalToRoman(result);
        }
        return String.valueOf(result);
    }

    @Override
    public String division(int a, int b, int type) {
        if (a<b){
            return "The first operand must be more than second operand!";
        }
        int result=a/b;
        if (type==1){
            return decimalToRoman(result);
        }
        return String.valueOf(result);
    }

    public int stringToInt(String a) {
        if (typeOfString(a) == 1) {
            Map<String, Integer> map1 = new HashMap<>();
            map1.put("I", 1);
            map1.put("II", 2);
            map1.put("III", 3);
            map1.put("IV", 4);
            map1.put("V", 5);
            map1.put("VI", 6);
            map1.put("VII", 7);
            map1.put("VIII", 8);
            map1.put("IX", 9);
            map1.put("X", 10);
            if (map1.containsKey(a)) {
                return map1.get(a);
            }
        } else if (typeOfString(a) == 2) {
            return Integer.parseInt(a);
        }
        return -1;
    }

    public String decimalToRoman(int i) {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");
        map.put(100, "C");

        result += map.get((i / 10) * 10);
        result += map.get(i % 10);

        return result;
    }

    public int typeOfString(String x) {
        try {
        if (x.contains("I") || x.contains("V") || x.contains("X")) {
            return 1;
        } else if (Integer.parseInt(x) >= 1 && Integer.parseInt(x) <= 10) {
            return 2;
        }
        }catch (Exception e){
            return -1;
        }
        return -1;
    }

}
