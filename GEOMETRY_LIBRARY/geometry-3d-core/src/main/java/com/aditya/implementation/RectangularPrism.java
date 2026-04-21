package com.aditya.implementation;

import com.aditya.contract.Shape3DContract;

public class RectangularPrism implements Shape3DContract {

    private final double length, breadth, height;


    public RectangularPrism(double breadth, double length, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    @Override
    public double volume() {
        return length*breadth*height;
    }

    @Override
    public double surfaceArea() {
        return 2*(length*breadth+breadth*height+length*height);
    }
}
