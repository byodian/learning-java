public interface Digestible {
  public void digest();

  public default void defaultMethod() {
    System.out.println("Hi from default method...");
  }
}