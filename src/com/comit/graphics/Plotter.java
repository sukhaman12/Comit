package com.comit.graphics;
import com.comit.Geometry.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Plotter extends JPanel{
    private static com.comit.Geometry.Point[] points;
    private static Polygon theirPolygon;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        theirPolygon = new Polygon();
        for (int i = 0; i < Plotter.points.length; i++)
        {
            Plotter.theirPolygon.addPoint( (int)Plotter.points[i].getX(), (int) Plotter.points[i].getY());
        }
        g.drawPolygon(theirPolygon);
    }

    public static void plotter(com.comit.Geometry.Point [] somePoints)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Polygon Paint");
        frame.setSize(1200,1000);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Container contentPane = frame.getContentPane();

        Plotter.points = new com.comit.Geometry.Point[somePoints.length];
        for (int i = 0; i < somePoints.length; i++)
        {
            Plotter.points[i] = new com.comit.Geometry.Point((int) somePoints[i].getX(), (int)somePoints[i].getY());
        }

        Plotter thisPlotter = new Plotter();
        contentPane.add(thisPlotter);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        com.comit.Geometry.Point[] myPoints = new com.comit.Geometry.Point[3];
        myPoints[0] = new com.comit.Geometry.Point(100,1000);
        myPoints[1] = new com.comit.Geometry.Point(500,500);
        myPoints[2] = new com.comit.Geometry.Point(2,200);
        Plotter.plotter(myPoints);

    }

}
