package com.byodian.WebServerLogAssignments;

import edu.duke.FileResource;

import java.util.ArrayList;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIps() {
        ArrayList<String> iPList = new ArrayList<>();
        for (LogEntry record : records) {
            String ip = record.getIpAddress();

            if (!iPList.contains(ip)) {
                iPList.add(ip);
            }
        }

        return iPList.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry record : records) {
            int statusCode = record.getStatusCode();
            if (statusCode > num) {
                System.out.println(record);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPList = new ArrayList<>();

        for (LogEntry record : records) {
           String currentDate = record.getAccessTime().toString();
           String ip = record.getIpAddress();

           if (currentDate.contains(someday) &&
                   !uniqueIPList.contains(ip)
           ) {
               uniqueIPList.add(ip);
           }
        }

        return uniqueIPList;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for(LogEntry record : records) {
            String ip = record.getIpAddress();
            int statusCode = record.getStatusCode();
            if (!uniqueIPs.contains(ip) && statusCode >= low && statusCode <= high) {
                uniqueIPs.add(ip);
            }
        }

        return uniqueIPs.size();
    }
}
