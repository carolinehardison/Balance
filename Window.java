package bal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Window extends JFrame{

    private Window(){
        super("Balance");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SlidePanel pane = new SlidePanel();

        getContentPane().add(pane);
        setMinimumSize(new Dimension(570,343));


        pack();

        setVisible(true);


    }

    public static void main(String[] args){
        new Window();

    }
    public static class SlidePanel extends JPanel{

        GridBagConstraints c;
        JSlider Diet, Sleep, Work, Family, Friends, Fitness;
        JLabel DietL, SleepL, WorkL, FamilyL, FriendsL, FitnessL;
        Chart chart;
        ChartGraphics graph;
        JPanel hiddenPanel; //used to calculate graphic resizing


        private SlidePanel(){





            setBackground(Color.white);
            setLayout(new GridBagLayout());
            c = new GridBagConstraints();
            c.insets = new Insets(10, 10, 10, 10);



            Diet = new JSlider();
            Sleep = new JSlider();
            Work = new JSlider();
            Family = new JSlider();
            Friends = new JSlider();
            Fitness = new JSlider();
            DietL = new JLabel("Diet");
            SleepL = new JLabel("Sleep");
            WorkL = new JLabel("Work");
            FamilyL = new JLabel("Family");
            FriendsL = new JLabel("Friends");
            FitnessL = new JLabel("Fitness");


            DietL.setForeground(Color.blue);
            SleepL.setForeground(Color.green);
            WorkL.setForeground(Color.red);
            FamilyL.setForeground(Color.magenta);
            FriendsL.setForeground(Color.orange);
            FitnessL.setForeground(Color.pink);
            
            c.fill = GridBagConstraints.BOTH;
            c.weighty = 1.0;

            c.gridx=0;
            c.gridy=0;
            add(DietL,c);
            c.gridy=1;
            add(SleepL,c);
            c.gridy=2;
            add(WorkL,c);
            c.gridy=3;
            add(FamilyL,c);
            c.gridy=4;
            add(FriendsL,c);
            c.gridy=5;
            add(FitnessL,c);

            c.gridx=1;
            c.gridy=0;
            add(Diet,c);
            c.gridy=1;
            add(Sleep,c);
            c.gridy=2;
            add(Work,c);
            c.gridy=3;
            add(Family,c);
            c.gridy=4;
            add(Friends,c);
            c.gridy=5;
            add(Fitness,c);


            int[] sliderVals = {50,50,50,50,50,50};


            // frames min size makes smallest square available for graph to be
            // 274x274
            Dimension d = new Dimension(274,274);
            chart = new Chart(6, sliderVals, d);
            graph = new ChartGraphics(chart);
            graph.setPreferredSize(d);



            hiddenPanel = new JPanel(new GridBagLayout());
            hiddenPanel.setBackground(Color.white);
            GridBagConstraints hp = new GridBagConstraints();
            hp.gridx=0;
            hp.gridy=0;



            hiddenPanel.add(graph, hp);

            c.gridx = 2;
            c.gridy = 0;
            c.weightx=2.0;
            c.weighty=2.0;
            c.fill = GridBagConstraints.BOTH;
            c.gridheight=6;
            add(hiddenPanel,c);






            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    super.componentResized(e);
                    getSize();

                }
            });
            // Diet
            Diet.addChangeListener(e->{
                //System.out.println(Diet.getValue());
                sliderVals[0]=Diet.getValue();
                chart.resetPoints(sliderVals);
                graph.repaint();
            });
            // Sleep
            Sleep.addChangeListener(e->{
                //System.out.println(Diet.getValue());
                sliderVals[1]=Sleep.getValue();
                chart.resetPoints(sliderVals);
                graph.repaint();
            });
            // Work
            Work.addChangeListener(e->{
                //System.out.println(Diet.getValue());
                sliderVals[2]=Work.getValue();
                chart.resetPoints(sliderVals);
                graph.repaint();
            });
            // Family
            Family.addChangeListener(e->{
                //System.out.println(Diet.getValue());
                sliderVals[3]=Family.getValue();
                chart.resetPoints(sliderVals);
                graph.repaint();
            });
            // Friends
            Friends.addChangeListener(e->{
                //System.out.println(Diet.getValue());
                sliderVals[4]=Friends.getValue();
                chart.resetPoints(sliderVals);
                graph.repaint();
            });
            // Fitness
            Fitness.addChangeListener(e->{
                //System.out.println(Diet.getValue());
                sliderVals[5]=Fitness.getValue();
                chart.resetPoints(sliderVals);
                graph.repaint();
            });






            addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {

                int w = hiddenPanel.getWidth();
                int h = hiddenPanel.getHeight();
                int size = w<h? w:h;
                size = size - 20;
                graph.setPreferredSize(new Dimension(size,size));
                graph.scale(size);
                hiddenPanel.repaint();
                graph.setVisible(true);





            }
        });




        }

    }
}
