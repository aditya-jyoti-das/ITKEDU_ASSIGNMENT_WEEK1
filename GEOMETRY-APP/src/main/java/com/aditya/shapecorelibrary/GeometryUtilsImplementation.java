package com.aditya.shapecorelibrary;

import com.aditya.GeometryUtils;
import org.aditya.shapes.Circle;
import org.aditya.shapes.Rectangle;
import org.aditya.shapes.Triangle;

public class GeometryUtilsImplementation {



    public static void main(String[] args) {

        Circle circle = new Circle(4.0);
        Rectangle rectangle = new Rectangle(4.0, 3.0);
        Triangle triangle = new Triangle(3.0, 4.2, 2.0);

        System.out.println("AREA OF CIRCLE IS MORE THAN RECTANGLE: "+GeometryUtils.compareArea(rectangle,circle));
        System.out.println("PERIMETER OF CIRCLE IS MORE THAN RECTANGLE: "+GeometryUtils.comparePerimeter(rectangle,circle));

    }
}
