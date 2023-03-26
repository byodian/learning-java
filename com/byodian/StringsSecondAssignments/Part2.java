package com.byodian.StringsSecondAssignments;

public class Part2 {
    public static void main(String[] args) {
        testHowMany();
    }

    public static int howMany(String stringa, String stringb) {
        int currentIndex = stringb.indexOf(stringa);
        int sum = 0;

        while (currentIndex != -1)  {
            sum = sum + 1;
            currentIndex = stringb.indexOf(stringa, currentIndex + stringa.length());
        }

        return sum;
    }

    public static void testHowMany() {
        System.out.println(howMany("AA", "ATAAAA")); // 2
        System.out.println(howMany("GAA", "ATGATCGATTTGATC")); // 0
    }
}
