package com.byodian.StringsFirstAssignments;

public class Part1 {
  public static String findSimpleGene(String dna) {
    int startIndex = dna.indexOf("ATG");
    if (startIndex == -1) {
      return "";
    }

    int stopIndex = dna.indexOf("TAA", startIndex + 3);
    if (stopIndex == -1)  {
      return "";
    }

    if ((stopIndex - startIndex) % 3 != 0) {
      return "";
    }

    String result = dna.substring(startIndex, stopIndex + 3);
    return result;
  }

  public static void testSimpleGene () {
    String geneWithoutATG = "ATTTGATAA";
    String geneWithoutTAA = "ATGATTTGATAT";
    String dnaSequenceWithNonMultipleSubstr  = "TATGTATTATATTAA";
    String dnaSequenceWithMultipleSubstr  = "AATGTATTATATTTAA";
    System.out.println(findSimpleGene((geneWithoutATG)));
    System.out.println(findSimpleGene((geneWithoutTAA)));
    System.out.println(findSimpleGene((dnaSequenceWithNonMultipleSubstr)));
    System.out.println(findSimpleGene((dnaSequenceWithMultipleSubstr)));
  }

  public static void main(String[] args) {
    testSimpleGene();
  }
}