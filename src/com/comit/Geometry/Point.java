package com.comit.Geometry;

public class Point implements Moveable {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void moveY(double amountMoved) {
        this.y += amountMoved;
    }

    public void moveX(double amountMoved) {
        this.x += amountMoved;
    }

    public void moveXY(double amountMovedX, double amountMovedY) {
        this.x += amountMovedX;
        this.y += amountMovedY;
    }

    public static double getLength(Point point1, Point point2) {
        double xDiff = point1.x - point2.x;
        double xSquared = xDiff * xDiff;
        double yDiff = point1.y - point2.y;
        double ySquared = yDiff * yDiff;
        return Math.sqrt(xSquared + ySquared);
    }

    public String print()
    {
        return("(" + this.getX() + "," + this.getY() + ")");
    }
}