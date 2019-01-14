package bal;

import javax.swing.*;
import java.awt.*;

public class Chart extends JPanel {
    public int[][] points;
    public int numSliders;
    public int radius;
    public int[] sliderScores;
    Dimension d;

    public Chart(int numSliders, int[] sliderScores, Dimension d){
        this.points = new int[2][numSliders];
        this.d = d;
        this.numSliders= numSliders;
        this.sliderScores=sliderScores;

        if(d.width<d.height)
            radius = d.width/2;
        else
            radius = d.height/2;
        resetPoints(sliderScores);
    }

    public void resetDimensions(int size){
        
        d = new Dimension(size,size);
        radius = size/2;
        resetPoints(sliderScores);
    }

    public Dimension getFrameDimension(){
        return d;
    }


    public int[][] averagePoints(double[] sliderAverages){
        int[][] average = new int[2][sliderAverages.length];
        for(int i = 0; i<sliderAverages.length;i++){

            //want the graphic be able to go all the way to the edge of available space
            double percentage = sliderAverages[i]/100; //percentage of max radius used
            double sliderFrame = percentage*radius;


            //multiplying angle between each slider by i
            double angle = Math.toRadians((360/numSliders)*i);

            double x = radius+((double) sliderFrame)* Math.cos(angle);
            double y = radius+((double) sliderFrame)* Math.sin(angle);
            int X = (int) x;
            int Y = (int) y;
            average[0][i]=X;
            average[1][i]=Y;

        }
        return average;
    }



    public void resetPoints(int[] sliderScores){

        for(int i = 0; i<sliderScores.length;i++){

            //want the graphic to go all the way to the edge of available space
            int sliderFrame = (sliderScores[i] * radius)/100;

            double angle = Math.toRadians((360/numSliders)*i);
            double x = radius+((double) sliderFrame)* Math.cos(angle);
            double y = radius+((double) sliderFrame)* Math.sin(angle);
            int X = (int) x;
            int Y = (int) y;
            points[0][i]=X;
            points[1][i]=Y;

        }

    }





}
