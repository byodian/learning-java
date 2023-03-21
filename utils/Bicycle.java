class Bicycle {
  public int cadence; // Can be accessed from anywhere
  protected int gear; // Accessible from the class and subclass
  private int speed;  // Only accessible from within the class
  String name;        // default: Only accessible form within this package
  static String className; // Static class variable

  // Static block
  // Java has no implementaton of static constrctors, but 
  // has a static block that can be used to initialize class variables (static variables)
  // This block will be called when the class is loaded.
  static {
    className = "Bicycle";
  }

  public Bicycle() {
    gear = 1;
    cadence = 50;
    speed = 5;
    name = "Bontrager";
  }

  public Bicycle(int startCadence, int startSpeed, int startGear, String name) {
    this.gear = startGear;
    this.cadence = startCadence;
    this.speed = startSpeed;
    this.name = name;
  }

  public int getCadence() {
    return cadence;
  }

  public void setGear(int gear) {
    gear = 0;
  }

  public int getSpeed() {
    return speed;
  }

  public void speedUp(int increment) {
    speed += increment;
  }
}

class PennyFarthing extends Bicycle {
  public PennyFarthing(int startCadence, int startSpeed) {
    super(startCadence, startSpeed, 0 , "PennyFarthing");
  }

  @Override
  public void setGear(int gear) {
    this.gear = 0;
  }
}