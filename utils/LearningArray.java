import com.byodian.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class LearningArray {
  public static void main(String[] args) {
    int[] intArray = new int[10];
    String[] stringArray = new String[1];
    boolean boolArray[] = new boolean[100];

    int[] y = { 900, 1000, 1337 };
    String names[] = {"Bob", "John", "Fred", "Juan Pedro"};
    boolean bools[] = {true, false, false};

    Utils.println("intArray @ 0 " + intArray[0]);
    Utils.println("stringArray @ 0 " + stringArray[0]);
    Utils.println("boolArray @ 0 " + boolArray[0]);
    Utils.println(Arrays.toString(y));

    for (String name : names) {
      Utils.println(name);
    }

    for (int i = 0; i < bools.length; i++) {
      Utils.println(bools[i]);
    }

    try (BufferedReader br = new BufferedReader(new FileReader("foo.txt"))) {
      Utils.println(br.readLine());
    } catch(Exception ex) {
      Utils.println("readLine() failed");
    }
  }
}
