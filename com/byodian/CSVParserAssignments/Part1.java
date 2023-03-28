package com.byodian.CSVParserAssignments;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Part1 {
    public static void main(String[] args) {
        tester();
    }

    public static void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        // System.out.println(countryInfo(parser, "Germany"));
        // listExportersTwoProducts(parser, "gold", "diamonds");

        // System.out.println(numberOfExports(parser, "gold"));
        bigExporters(parser, "$999,999,999");
    }

    public static String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String countryName = record.get("Country");

           if (countryName.contains(country)) {
               return  countryName + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
           }
        }

        return "NOT FOUND";
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public static int numberOfExports(CSVParser parser, String exportItem) {
        int total = 0;

        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem)) {
                total = total + 1;
            }
        }

        return total;
    }

    public static void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");

            if (value.length() > amount.length()) {
                System.out.println(record.get("Country") + " " + value);
            }
        }
    }
}
