package com.aditya.shapecorelibrary;

import com.aditya.implementation.RectangularPrism;


public class Shape3DImplementation {

    public static void main(String[] args) {
        RectangularPrism rectangularPrism = new RectangularPrism(3.0, 4.0, 5.0);
        System.out.printf("AREA OF RECTANGULAR PRISM: %f m*m*m\n", rectangularPrism.surfaceArea());
        System.out.printf("VOLUME OF RECTANGULAR PRISM: %f m*m", rectangularPrism.volume());

    }


}
