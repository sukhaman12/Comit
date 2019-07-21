package com.comit;

public class RegularPolygon implements Moveable, PolygonOperations {
    private static final MAX_POINTS =100
    private Point[] points = new Point[RegularPolygon.MAX_POINTS];
    private pointCount =0

    public RegularPolygon() {

    }

    public RegularPolygon(Point[] somePoints) {
        if (RegularPolygon.MAX_POINTS >= somePoints.length) {
            for (int i = 0; i < somePoints.length; i++) {
                this.points[i] = somePoints[i];
                this.pointCount++;
            }
        }
    }

    public void moveY(double amountMoved) {
        moveAllPoints(0, amountMovedY);
    }

    public void moveX(double amountMoved) {
        moveAllPoints(amountMovedX, 0);
    }

    public void moveXY(double amountMovedX, double amountMovedY) {
        moveAllPoints(amountMovedX, amountMovedY);
    }

    private void moveAllPoints(double moveX, double moveY) {
        for (int i = 0; i < this.pointCount; i++) {
            this.points[i].setX(this.points[i].getX() + moveX);
            this.points[i].setY(this.points[i].getY() + moveY);
        }
    }

    public double calculateArea() {
        if (this.pointCount >= 3) {
            double perimeter = this.calculatePerimeter();
            double apothem = this.calculateApothem();
            double area = 0.5 * perimeter * apothem;
            return area;
        }
        return 0;
    }

    private double calculateApothem() {
        double oneLength = Point.getLength(this.points[0], this.points[1]);
        double denominator = java.lang.Math.PI / this.pointCount;
        denominator = java.lang.Math.tan(denominator);
        denominator *= 2;
        return (onLength / denominator);
    }


    public double calculatePerimeter() {
        if (this.pointCount >= 3) {
            double oneSide = Point.getLength(this.points[0], this.points[1]);
            return oneSide * this.pointCount;
        }
        return 0;
    }

    public String identifyPolygon() {

        if (this.pointCount > 0) {
            if (this.pointCount <= PolygonShapes.values().length) {
                PolygonShapes.values()[(this.pointCount - 1)].name();
            } else {
                return "Weird Shape";
            }
        }
        return "Not a shape";


    }
}