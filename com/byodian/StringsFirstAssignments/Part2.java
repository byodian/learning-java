package com.byodian.StringsFirstAssignments;

public class Part2 {
   public static String findSimpleGene(String dna, String startCodon, String stopCodon) {
    String formatedStartCodon = (startCodon == null ? "ATG" : startCodon).toLowerCase();
    int startIndex = dna.toLowerCase().indexOf(formatedStartCodon);
    if (startIndex == -1) { return ""; }

    String formatedStopCodon = (stopCodon == null ? "TAA" : stopCodon).toLowerCase();
    int stopIndex = dna.toLowerCase().indexOf(formatedStopCodon, startIndex + 3);
    if (stopIndex == -1)  { return ""; }

    if ((stopIndex - startIndex) % 3 != 0) { return ""; }

    String result = dna.substring(startIndex, stopIndex + 3);
    return result;
  }

  public static void testSimpleGene () {
    String geneWithoutStartCodon = "ATTTGATAA";
    String geneWithoutStopCodon = "ATGATTTGATAT";
    String dnaSequenceWithNonMultipleSubstr  = "TATGTATTATATTAA";
    String dnaSequenceWithMultipleSubstr1  = "aatgtattatatttaa";
    String dnaSequenceWithMultipleSubstr2  = "AATGTATTATATTTAA";

    System.out.println(findSimpleGene(geneWithoutStartCodon,null, null));
    System.out.println(findSimpleGene(geneWithoutStopCodon, null, null));
    System.out.println(findSimpleGene(dnaSequenceWithNonMultipleSubstr, null, null));
    System.out.println(findSimpleGene(dnaSequenceWithMultipleSubstr1, null, null));
    System.out.println(findSimpleGene(dnaSequenceWithMultipleSubstr2, null, null));
  }

  public static void main(String[] args) {
    testSimpleGene();
  } 
}