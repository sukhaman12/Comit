package com.comit.Geometry;

public class Polygon implements Moveable, PolygonOperations {
    protected static final int MAX_POINTS =100;
    protected Point[] points;
    protected int pointCount =0;

    public Polygon() {

    }

    public Polygon(Point[] somePoints) {
        this.points = new Point[Polygon.MAX_POINTS];
        if (Polygon.MAX_POINTS >= somePoints.length) {
            if (somePoints.length > 2) {
                for (int i = 0; i < somePoints.length; i++) {
                        this.points[i] = somePoints[i];
                        this.pointCount++;
                    }
                }
            }
        }


    public void moveY(double amountMoved) {
        moveAllPoints(0, amountMoved);
    }

    public void moveX(double amountMoved) {
        moveAllPoints(amountMoved, 0);
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
            double area = 0;
            int someLength = this.points.length - 1;
            for (int i = 0; i < someLength; i++) {
                area += this.points[i].getX() * this.points[i + 1].getY();
                area -= this.points[i].getY() * this.points[i + 1].getX();
            }
            area += this.points[someLength].getX() * this.points[0].getY();
            area -= this.points[someLength].getY() * this.points[0].getX();

            area /= 2;
            return area;
        }
        return 0;
    }


    public double calculatePerimeter() {
        if (this.pointCount >= 3) {
            double oneSide = Point.getLength(this.points[0], this.points[1]);
            return oneSide * this.pointCount;
        }
        return 0;
    }

    public String identifyPolygon() {

                return "Weird Shape";

    }
}