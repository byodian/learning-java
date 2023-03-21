import edu.duke.*;
import java.util.*;
import java.io.*;

public class HelloWorld {
	public static void runHello () {
		FileResource res = new FileResource("hello_unicode.txt");
		for (String line : res.lines()) {
			System.out.println(line);
		}
	}

	public static void test() {
		HelloWorld.runHello();
		int i = 0;
		while(i < 6) {
			System.out.println(i);
			i++;
		}

		for (int j = 0; j < 5; j++) {
			System.out.println(j);
		}

		for (int j = 0; j < 10; j++) {
			System.out.println(j);
		}

		int j = 10;
		while(j > 0) {
			System.out.print(j);
			j--;
		}

		String[] cars = {"Volvo", "Ford", "Mazda"};
		for (String car : cars) {
			System.out.println(car);
		}
	}

	public static void runInteractive() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("What is your name?");
			String name = in.nextLine();

			System.out.println("What is your firstName?");
			String firstName = in.next();

			System.out.println("How old are you?");
			int age = in.nextInt();

			System.out.println("Hello, " + firstName + "(" + name + ")" + ". Next year, you'll be " + (age+1));
		}
	}

	public static void readPasswd() {
		Console cons = System.console();
		String username = cons.readLine("User name: ");
		char[] passwd = cons.readPassword("Password: ");
		System.out.println(username + passwd.toString());
	}

	public static void main(String[] args) {
		// readPasswd();
		runInteractive();
	}
}
