package com.byodian.StringsFirstAssignments;

public class Part3 {
   public static boolean twoOccurrences(String stringa, String stringb) {
       int firstIndex = stringb.indexOf(stringa);
       if (firstIndex == -1) { return false; }

       int secondIndex = stringb.indexOf(stringa, firstIndex + 1);
       return secondIndex != -1;
   }

   public static String lastPart(String stringa, String stringb) {
       int startIndex = stringb.indexOf(stringa);
       if (startIndex == -1) {
           return stringb;
       }

       return stringb.substring(startIndex + stringa.length());
   }

   public static void testTwoOccurrences() {
       System.out.println(twoOccurrences("atg", "gatgtaaatg")); // true
       System.out.println(twoOccurrences("by", "by the way.")); // false
       System.out.println(twoOccurrences("two", "There are two classes which are different. two, two")); // true
       System.out.println((twoOccurrences("go", "Hello world"))); // false

       System.out.println((lastPart("an", "banana"))); // "ana"
       System.out.println((lastPart("zoo", "forest"))); // "forest"
   }

   public static void main(String[] args) {
       testTwoOccurrences();
   }
}
