package com.byodian.modifiers;

public class Circle extends Shape {
    private static final double PI = 3.141519;
    private double radius;
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
       return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}
