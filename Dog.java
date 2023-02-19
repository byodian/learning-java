import com.byodian.Utils;

public class Dog extends Animal{
  @Override
  public void makeSound() {
    Utils.println("Wang wang wang!");
  }

  public static void main(String[] args) {
    Dog pluto = new Dog();
    pluto.makeSound();
    pluto.eat();
    pluto.setAge(10);
    pluto.printAge();
  }
}
