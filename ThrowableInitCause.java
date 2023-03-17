import java.io.IOException;

public class ThrowableInitCause {

  @SafeVarargs
  public static <T> T getMiddle(T... a) {
    for (T item : a) {
      System.out.println(item);
    }

    return a[a.length / 2];
  }

  public static void main(String[] args) throws Exception {
    try {
      ThrowableInitCause.<String>getMiddle("john", "Q.", "Public");
      ThrowableInitCause.getMiddle(3.14, 1729, 0);
      ThrowableInitCause.getMiddle("hello", 0, null);
      throwableTest();  
    } catch(Exception e) {
      // 重新获取原始异常
      System.out.println("Cause: " + e.getCause());
    }
  }

  public static void throwableTest() throws Exception {
    try {
      int i = 4/0;
      System.out.println(i);
    } catch(ArithmeticException ae) {
      IOException ioe = new IOException();
      ioe.initCause(ae);
      throw ioe;
    }
  }
}
