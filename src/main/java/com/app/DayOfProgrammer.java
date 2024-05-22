package com.app;

public class DayOfProgrammer {
    public String solution(int year) {
        boolean isLeap = false;
        boolean isJulian = true;
        if (year > 1917) {
            isJulian = false;
            isLeap = (year % 4 == 0);
        } else {
            isLeap = (year % 400==0) || (year % 4 == 0 && year % 100 != 0);
        }
        System.out.println(String.format("Julian: %s, Leap: %s",isJulian, isLeap));
        if (isLeap && !isJulian) return "12.09." + String.valueOf(year);
        if (!isLeap && isJulian) return "13.09." + String.valueOf(year);

        return "13.09." + String.valueOf(year);
    }

    public static void main(String[] args) {
        DayOfProgrammer dayOfProgrammer = new DayOfProgrammer();
        System.out.println(dayOfProgrammer.solution(1800));

    }
}
