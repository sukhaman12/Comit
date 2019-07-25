package com.comit.Geometry;

public class RegularPolygon extends Polygon {

    public RegularPolygon(int xCenter, int yCenter, double radius, int numberOfPoints)
    {
        this.pointCount = numberOfPoints;
        this.points = new Point[RegularPolygon.MAX_POINTS];
        for (int i = 0; i < numberOfPoints; i++)
        {
            int x =  (int) (xCenter + radius * Math.cos(i * 2 * Math.PI / numberOfPoints));
            int y =  (int) (yCenter + radius * Math.sin(i * 2 * Math.PI / numberOfPoints));
            points[i] = new Point(x,y);
        }
    }

    public double calculateArea()
    {
        if (this.pointCount >=3)
        {
            double perimeter = super.calculatePerimeter();
            double apothem = this.calculateApothem();
            return 0.5 * perimeter * apothem;
        }
        return 0;
    }

    protected double calculateApothem() {
        double oneLength = Point.getLength(this.points[0], this.points[1]);
        double denominator = java.lang.Math.PI / this.pointCount;
        denominator = java.lang.Math.tan(denominator);
        denominator *= 2;
        return (oneLength / denominator);
    }

    public String identifyPolygon()
    {

        if (this.pointCount > 0) {
            if (this.pointCount <= PolygonShapes.values().length) {
                return PolygonShapes.values()[(this.pointCount - 1)].name();
            } else {

        return "Weird Shape";

            }
        }
        return "Not a shape";
    }
}
