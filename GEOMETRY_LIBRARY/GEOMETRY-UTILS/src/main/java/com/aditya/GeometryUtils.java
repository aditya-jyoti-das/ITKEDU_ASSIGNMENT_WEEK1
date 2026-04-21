package com.aditya;

import org.aditya.contract.ShapeContract;

public class GeometryUtils {


    public static double cmToMeter(double cm) {
        return cm / 100.0;
    }
    public static double meterToCm(double m) {
        return m* 100.0;
    }

    public static int compareArea(ShapeContract s1, ShapeContract s2){
        return Double.compare(s1.area(),s2.area());
    }

    public static int comparePerimeter(ShapeContract s1, ShapeContract s2){
        return Double.compare(s1.perimeter(),s2.perimeter());
    }



}
