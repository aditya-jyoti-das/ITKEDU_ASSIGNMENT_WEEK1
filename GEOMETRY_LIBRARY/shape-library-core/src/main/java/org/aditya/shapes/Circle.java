package org.aditya.shapes;

import org.aditya.contract.ShapeContract;

public final class Circle implements ShapeContract {

    double radius;

    public Circle(double radius){
        this.radius=radius;
        System.out.printf("circle of radius %f created%n", radius);
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }
}
