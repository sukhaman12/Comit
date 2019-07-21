package com.comit;

public class Main {

    public static void main(String[] args) {
        //Make Square points -- trust me
        double sizeOfSquare = 1;
        Point[] myPoints = new Point[4];

        for (int i = 0; i < 4; i++) {
            double x = (i < 2 ? 0 : sizeOfSquare);
            double y = (i != 0 && i != 4 ? sizeOfSquare : 0);
            myPoints[i] = new Point(x, y);
        }

        ///Print Square points
        for (Point p : myPoints) {
            System.out.println(p.getX() + " " + p.getY());
        }

        //Move square points
        for (Point p : myPoints) {
            p.moveXY(5, 5);
        }

        //Print again
        for (Point p : myPoints) {
            System.out.println(p.getX() + " " + p.getY());
        }

        //Make square from points and identify it
        RegularPolygon myPoly = new RegularPolygon(myPoints);
        System.out.println(myPoly.identifyPolygon());

        //Move square
        myPoly.moveXY(-5, 0);

        //Calculate area and perimeter and print
        System.out.println(myPoly.calculateArea());
        System.out.println((myPoly.calculatePerimeter()));


    }
}
