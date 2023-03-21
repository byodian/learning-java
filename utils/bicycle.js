class Bicycle {
  constructor(startCadence, startGear, startSpeed, name) {
    this.cadence = startCadence;
    this.startGear = startGear;
    this.startSpeed = startSpeed;
    this.name = name;
  }

  setGear(gear) {
    this.gear = gear;
  }
}