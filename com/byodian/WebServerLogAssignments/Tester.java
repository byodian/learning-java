package com.byodian.WebServerLogAssignments;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
    public static void main(String[] args) {
        // testLogAnalyzer();
        // testUniqueIP();
        // testPrintAllHigherThanNum();
        // testUniqueIPVisitsOnDay();
        // testCountUniqueIpsInRange();
        // testCountVisitsPerIp();
        testCountWebSiteVisits();
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

    public static void testCountVisitsPerIp() {
        LogAnalyzer le = new LogAnalyzer();
        // le.readFile("short-test_log");
        le.readFile("weblog3-short_log");
        HashMap<String, Integer> visitsPerIp = le.countVisitsPerIp();

        System.out.println(visitsPerIp);
        System.out.println(le.mostNumberVisitsPerIP(visitsPerIp));
        System.out.println(le.iPsMostVisits(visitsPerIp));
    }

    public static void testCountWebSiteVisits() {
        LogAnalyzer le = new LogAnalyzer();
        // le.readFile("short-test_log");
        le.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> counts = le.iPsForDays();

        System.out.println(counts);
        System.out.println(le.dayWithMostIPVisits(counts));
        System.out.println(le.iPsWithMostVisitsOnDay(counts, "Sep 30"));
    }
}
