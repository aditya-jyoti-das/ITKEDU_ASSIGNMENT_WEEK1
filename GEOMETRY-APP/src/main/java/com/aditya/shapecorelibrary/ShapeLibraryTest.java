package com.aditya.shapecorelibrary;

import org.aditya.shapes.Circle;
import org.aditya.shapes.Rectangle;
import org.aditya.shapes.Triangle;

public class ShapeLibraryTest {

    public static void main(String[] args) {

        Circle circle = new Circle(4.0);
        Rectangle rectangle = new Rectangle(4.0, 3.0);
        Triangle triangle = new Triangle(3.0, 4.2, 2.0);

        System.out.println("TRIANGLE PERIMETER: \t"+triangle.perimeter());
        System.out.println("CIRCLE PERIMETER: \t"+circle.perimeter());
        System.out.println("RECTANGLE PERIMETER: \t"+rectangle.perimeter());

        System.out.println("TRIANGLE AREA: \t"+triangle.area());
        System.out.println("CIRCLE AREA: \t"+circle.area());
        System.out.println("RECTANGLE AREA: \t"+rectangle.area());




    }
}
