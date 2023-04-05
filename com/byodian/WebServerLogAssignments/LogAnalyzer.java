package com.byodian.WebServerLogAssignments;

import edu.duke.FileResource;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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

    public HashMap<String, Integer> countVisitsPerIp() {
        HashMap<String, Integer> visitsPerIpMap = new HashMap<String, Integer>();
        for (LogEntry record : records) {
            String iP = record.getIpAddress();
            if (!visitsPerIpMap.containsKey(iP)) {
                visitsPerIpMap.put(iP, 1);
            } else {
                visitsPerIpMap.put(iP, visitsPerIpMap.get(iP) + 1);
            }
        }

        return visitsPerIpMap;
    }

    public int mostNumberVisitsPerIP(HashMap<String, Integer> visitsPerIP) {
        int maxNumber = 0;
        for (String iP: visitsPerIP.keySet()) {
            int currentNumber = visitsPerIP.get(iP);
            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }
        }

        return maxNumber;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> visitsPerIp) {
        ArrayList<String> iPs = new ArrayList<>();
        int mostNumberVisits = mostNumberVisitsPerIP(visitsPerIp);

        for (String iP : visitsPerIp.keySet()) {
            if (visitsPerIp.get(iP) == mostNumberVisits) {
                iPs.add(iP);
            }
        }

        return iPs;
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> counts = new HashMap<>();
        for(LogEntry lg : records) {
            String date = lg.getAccessTime().toString().substring(4, 10);
            String ip = lg.getIpAddress();
            if (!counts.containsKey(date)) {
                ArrayList<String> ips = new ArrayList<>();
                ips.add(ip);
                counts.put(date, ips);
            } else {
                counts.get(date).add(ip);
            }

        }

        return counts;
    }

    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> counts) {
        int maxCount = 0;
        String dateString = null;

        for (String s : counts.keySet()) {
            int currentCount = counts.get(s).size();
            if (currentCount > maxCount) {
                maxCount = currentCount;
                dateString = s;
            }
        }

        return dateString;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> counts, String day) {
        HashMap<String, Integer> countPerIp = new HashMap<>();
        if (counts.get(day) == null) {
            throw new NoSuchElementException(day + " is not in " + counts.toString());
        }

        for (String s : counts.get(day)) {
            if (!countPerIp.containsKey(s)) {
                countPerIp.put(s, 1);
            } else {
                countPerIp.put(s, countPerIp.get(s) + 1);
            }
        }

        return iPsMostVisits(countPerIp);
    }
}
