import com.byodian.*;

public class LearningString {
  public static void runStringMethod() {
    String sentence = "IZB";
    String otherString = "IZB";
    String anotherString = "izb";
    // returns the code unit
    Utils.println(sentence.charAt(0)); 
    // returns the code point
    Utils.println(sentence.codePointAt(0)); 
    // returns the index of the code point
    Utils.println(sentence.length());
    Utils.println(sentence.offsetByCodePoints(0, sentence.length()));
    Utils.println(sentence.compareTo(anotherString));

    String myStr1 = " ";
    Utils.println(myStr1.isEmpty());
    Utils.println(myStr1.isBlank());
    Utils.println(sentence.equals(otherString));
    Utils.println(sentence.equalsIgnoreCase(anotherString));
    Utils.println(sentence.startsWith("I"));
    Utils.println(sentence.endsWith("Z"));
    Utils.println(sentence.indexOf("I"));
    Utils.println(sentence.indexOf("I", 1));
    Utils.println(sentence.indexOf(sentence.codePointAt(0)));
    Utils.println(sentence.lastIndexOf(sentence.codePointAt(0)));
    Utils.println(sentence.toUpperCase());
    Utils.println(sentence.toLowerCase());
    Utils.println(" Hello wolrd ".trim());
    Utils.println(" Hello wolrd ".trim().substring(1, 4));
    Utils.println("A".repeat(10));
    Utils.println(sentence.replace("I", "A"));

    // This way doesn't create any intermediate strings. It just stores the string pieces, an ties them together.
    StringBuilder builderConcatenated = new StringBuilder();
    builderConcatenated.append("You ");
    builderConcatenated.append("can use ");
    builderConcatenated.append("the StringBuilder class.");
    Utils.println(builderConcatenated.toString());
  } 

  public static void main(String[] args) {
    LearningString.runStringMethod();
  }
}
