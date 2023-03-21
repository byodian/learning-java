import java.text.NumberFormat;

import com.byodian.Utils;

public class Dog extends Animal{
  public String name;

  public void setName(String dogName) {
    name =  dogName;
  }

  @Override
  public void makeSound() {
    Utils.println("Wang wang wang!");
  }

  public static void main(String[] args) {
    Dog pluto = new Dog();
    Utils.println("Dog" + ' ' +  pluto.getClass().getName());
    pluto.makeSound();
    pluto.eat();
    pluto.setAge(10);
    pluto.printAge();
    pluto.setName("pluto");
    pluto.name = "byodian";
    Utils.println(pluto.name);

    Bicycle black = new Bicycle();
    Utils.println(black.cadence);
    Utils.println(Bicycle.className);

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    double x = 0.1;
    int idex = (int) x;
    Utils.println(idex);
    Utils.println(currencyFormatter.format(x));
    Utils.println(percentFormatter.format(x));
  }
}
