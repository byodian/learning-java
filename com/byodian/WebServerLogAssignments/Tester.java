package com.byodian.WebServerLogAssignments;

public class Tester {
    public static void main(String[] args) {
        testLogAnalyzer();
    }

    public static void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
}
