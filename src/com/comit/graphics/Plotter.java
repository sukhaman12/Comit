package com.comit.graphics;
import com.comit.Geometry.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Plotter extends JPanel{
    private static com.comit.Geometry.Point[] points;
    private static java.awt.Polygon theirPolygon;
    private static java.awt.Point mousePt;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        theirPolygon = new java.awt.Polygon();
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

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if (theirPolygon.contains(me.getPoint())) {
                    System.out.println("HEY THATS ME");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int dx = e.getX() - mousePt.x;
                int dy = e.getY() - mousePt.y;
                for (com.comit.Geometry.Point p : Plotter.points)
                    p.moveXY(dx,dy);
                thisPlotter.repaint();

            }
        };

        thisPlotter.addMouseListener(ma);
        contentPane.add(thisPlotter);
        frame.setVisible(true);


    }

    public static void main(String[] args) {

    }

}
