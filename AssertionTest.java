import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class AssertionTest {
  private String name = "byodian";
  public static void main(String[] args) {
    // Logger.getGlobal().setLevel(Level.OFF);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ur age ");

    int value = scanner.nextInt();
    assert value >= 18: "Not valid";

    System.out.println("value is " + value);

    AssertionTest assertTest = new AssertionTest();
    System.out.println(assertTest);
    Logger.getGlobal().info("File -> Open menu item selected");
  }
}
