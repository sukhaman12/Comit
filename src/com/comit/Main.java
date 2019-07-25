package com.comit;

import com.comit.Geometry.*;
import com.comit.graphics.Plotter;

public class Main {

    public static void main(String[] args) {

    Circle myCircle = new Circle(100,100,100);
        Plotter.plotter(myCircle.getPoints());
        System.out.println(myCircle.calculatePerimeter());
        System.out.println(myCircle.calculateArea());
    }
}
