package org.aditya.shapes;

import org.aditya.contract.ShapeContract;

public final class Rectangle implements ShapeContract {

    private final double length;
    private final double width;

    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
        System.out.printf("rectangle of height and width %f and %f respectively created%n", length,width);
    }


    @Override
    public double area() {
        return length*width;
    }

    @Override
    public double perimeter() {
        return 2*(length+width);
    }
}
