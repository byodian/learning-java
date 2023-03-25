package com.byodian.StringsFirstAssignments;

import edu.duke.URLResource;

public class Part4 {
    public static String findWebUrl (String s, int fromIndex) {
        int startIndex = s.lastIndexOf("\"", fromIndex);
        int endIndex = s.indexOf("\"", fromIndex);
        return s.substring(startIndex + 1, endIndex);
    }

    public static void main(String[] args) {
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.words()) {
            String lowerCaseStr = s.toLowerCase();
            int targetIndex = lowerCaseStr.indexOf("youtube.com");

            if (targetIndex != -1) {
                System.out.println(Part4.findWebUrl(s, targetIndex));
            }
        }
    }
}
