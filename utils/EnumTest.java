import com.byodian.Day;

public class EnumTest {
  Day day;

  public EnumTest(Day day) {
    this.day = day;
  }

  public void tellItLikeItIs() {
    switch(day) {
      case MONDAY:
        System.out.println("Monday are bad.");
        break;
      case FRIDAY:
        System.out.println("Friday are better.");
        break;
      case SATURDAY: 
      case SUNDAY:
        System.out.println("Weekends are best.");
        break;
      default:
        System.out.println("Midweek days are so-so.");
    } 
  }

  public static void main(String[] args) {
    EnumTest fristDay = new EnumTest(Day.MONDAY);
    fristDay.tellItLikeItIs();

    EnumTest thirdDay = new EnumTest(Day.WENDESDAY);
    thirdDay.tellItLikeItIs();
  }
}
