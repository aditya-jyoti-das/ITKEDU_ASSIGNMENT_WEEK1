package org.aditya.shapes;

import org.aditya.contract.ShapeContract;

public final class Triangle implements ShapeContract {

    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        System.out.printf("triangle of sides %f, %f, and %f created%n", side1,side2,side3);
    }

    @Override
    public double area() {
        double s= perimeter()/2;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }

    @Override
    public double perimeter() {
        return side1+side2+side3;
    }
}
