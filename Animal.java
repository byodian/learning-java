import com.byodian.*;

public abstract class Animal {
  private int age;

  public abstract void makeSound();
  // Method can have a body
  public void eat () {
    Utils.println("I am an animal and I am Eating.");
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void printAge() {
    Utils.println(age);
  }

  public static void main(String[] args) {
    Utils.println("I am abstract");
  }
}