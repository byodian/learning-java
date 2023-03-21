public class Fruit implements Edible, Digestible {
  public void digest() {
    System.out.println("Digest");
  }

  public void eat() {
    System.out.println("Eat");
  }
}