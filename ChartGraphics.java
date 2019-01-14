package bal;

import javax.swing.*;
import java.awt.*;

public class ChartGraphics extends JPanel {
    private Chart chart;
    private double scale;

    public ChartGraphics(Chart chart) {


        setSize(200, 200);
        this.chart = chart;
        setVisible(true);
        scale = 1;


    }


    public void repaint() {
        //d = getSize();
        //this.chart = new Chart(chart.getNumSliders(),chart.sliderScores,d);
        setBackground(Color.white);
        super.repaint();
        setVisible(true);

    }

    //Size is the width and height of the square frame
    public void scale(int size) {
        chart.resetDimensions(size);
        repaint();
    }

    public void paintComponent(Graphics g) {


        int xpoints[] = chart.points[0];
        int ypoints[] = chart.points[1];
        int npoints = chart.numSliders;


        //drawing lines from center of circle to edge of chart
        //by creating a Chart maximum that has slider scores at max

        int[] maxSliders = new int[chart.numSliders];
        for (int i = 0; i < chart.numSliders; i++) {
            maxSliders[i] = 100;
        }
        Chart max = new Chart(chart.numSliders, maxSliders, chart.getFrameDimension());
        for (int i = 0; i < chart.numSliders; i++) {
            g.drawLine(chart.radius, chart.radius, max.points[0][i], max.points[1][i]);
        }


        //drawing rings on background of polygon to show increments
        double r = (double) chart.radius;
        for (double i = r / 5; i < r + 1; i += r / 5) {
            int topLeft = (int) (r - (i));
            int diameter = (int) i * 2;
            g.drawOval(topLeft, topLeft, diameter, diameter);
        }

        //drawing chart
        g.setColor(Color.gray);
        g.fillPolygon(xpoints, ypoints, npoints);

        //drawing bullet points to label each category

        Color[] colors = {Color.cyan, Color.green, Color.red, Color.magenta, Color.orange, Color.pink};

        String[] genericSliderAbbrev = {"Di", "Sl", "Wo", "Fa", "Fr", "Fi"};
        for (int i = 0; i < chart.numSliders; i++) {

            int circleIndexX = chart.points[0][i];
            int circleIndexY = chart.points[1][i];
            double bulletSize = chart.getFrameDimension().getHeight() * (5.0 / 100.0);
            int bRadius = (int) (bulletSize / 2.0);
            g.setColor(colors[i]);

            g.fillOval(circleIndexX - bRadius, circleIndexY - bRadius, bRadius * 2, bRadius * 2);

        }


    }
}
