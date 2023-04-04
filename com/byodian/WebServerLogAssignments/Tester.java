package com.byodian.WebServerLogAssignments;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        // testLogAnalyzer();
        // testUniqueIP();
        // testPrintAllHigherThanNum();
        // testUniqueIPVisitsOnDay();
        testCountUniqueIpsInRange();
    }

    public static void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }

    public static void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIps());
    }

    public static void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(300);
    }

    public static void testUniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        ArrayList<String> uniqueIPs = la.uniqueIPVisitsOnDay("Sep 14");
        System.out.println(uniqueIPs.size());
    }

    public static void testCountUniqueIpsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(200, 299));
        System.out.println(la.countUniqueIPsInRange(300, 399));
    }
}
