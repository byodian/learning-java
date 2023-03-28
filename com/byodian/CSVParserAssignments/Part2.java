package com.byodian.CSVParserAssignments;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Part2 {
    public static void main(String[] args) {
        // testColdestHourInFile();
        testFileWithColdestTemperature();
    }

    public static CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestHourSoFar = null;

        for (CSVRecord currentRow : parser) {
            if (coldestHourSoFar == null) {
                coldestHourSoFar = currentRow;
            } else {
                double coldestTemp = Double.parseDouble(coldestHourSoFar.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                if (coldestTemp > currentTemp) {
                    coldestHourSoFar = currentRow;
                }
            }
        }

        return coldestHourSoFar;
    }

    public static void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestHourRecord = coldestHourInFile(parser);
        System.out.println(coldestHourRecord.get("DateUTC") + " " + coldestHourRecord.get("TemperatureF"));
    }

    public static String fileWithColdestTemperature() {
        String fileName = null;
        CSVRecord coldestHourSoFar  = null;
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());

            if (coldestHourSoFar == null) {
                coldestHourSoFar = currentRow;
                fileName = f.getName();
            } else {
                double coldestTemp = Double.parseDouble(coldestHourSoFar.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));

                if (coldestTemp > currentTemp) {
                    coldestHourSoFar = currentRow;
                    fileName = f.getName();
                }
            }
        }

        return fileName;
    }

    public static void testFileWithColdestTemperature() {
        String name = fileWithColdestTemperature();
        FileResource fr = new FileResource(name);
        String coldestTemperature = coldestHourInFile(fr.getCSVParser()).get("TemperatureF");
        System.out.println("Coldest day was in file " + name);
        System.out.println("Coldest temperature on the day was " + coldestTemperature);
    }
}
