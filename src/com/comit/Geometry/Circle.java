package com.comit.Geometry;

public class Circle extends RegularPolygon {

    public Circle(int xCenter, int yCenter, double radius)
    {
        super(xCenter, yCenter, radius, Circle.MAX_POINTS);
    }

    public Point[] getPoints()
    {
        return points;
    }

    public String identifyPolygon()
    {
        return "Circle";
    }
}
