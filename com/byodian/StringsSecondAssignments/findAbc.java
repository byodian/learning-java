package com.byodian.StringsSecondAssignments;

public class findAbc {
    public static void main(String[] args) {
       test();
    }

    public static void find(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            System.out.println("index " + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+4);
            System.out.println("index after updating " + index);
        }
    }

    public static void test() {
//        find("abcd");
//        find("abcdabc");
        find("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }
}
