import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

import static javax.swing.UIManager.getColor;

public class Bounce {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    static class BounceFrame extends JFrame {
        public BounceFrame() {
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            setTitle("Bounce");

            comp = new BallComponent();
            add(comp, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            JLabel labelA = new JLabel();
            labelA.setText("Ángulo:");
            JTextField textfieldA= new JTextField();
            textfieldA.setColumns(3);
            JLabel labelV = new JLabel();
            labelV.setText("Velocidad:");
            JTextField textfieldV= new JTextField();
            textfieldV.setColumns(2);
            JLabel labelN = new JLabel();
            labelN.setText("Cant:");
            JTextField textfieldN= new JTextField();
            textfieldN.setColumns(4);
            JLabel labelC = new JLabel();
            labelC.setText("Color:");
            JTextField textfieldC= new JTextField();
            textfieldC.setColumns(9);
            //add to frame
            buttonPanel.add(labelA);
            buttonPanel.add(textfieldA);
            buttonPanel.add(labelV);
            buttonPanel.add(textfieldV);
            buttonPanel.add(labelN);
            buttonPanel.add(textfieldN);
            buttonPanel.add(labelC);
            buttonPanel.add(textfieldC);



            addButton(buttonPanel, "Factory", new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Board board = new Board();

                    number = Integer.valueOf(textfieldN.getText());
                    velocidad=Integer.valueOf(textfieldV.getText());
                    angle = Integer.valueOf(textfieldA.getText());
                    if(textfieldC.getText().equals("RED")){
                        color =  Color.RED;
                    }
                    if(textfieldC.getText().equals("BLUE")){
                        color =  Color.BLUE;
                    }
                    if(textfieldC.getText().equals("YELLOW")){
                        color =  Color.YELLOW;
                    }
                    if(textfieldC.getText().equals("GREEN")){
                        color =  Color.GREEN;
                    }

                    DELAY=11-(velocidad);
                    long startTime = System.currentTimeMillis();
                    board.generateBalls(number, color, angle,velocidad, 2);
                    long endTime = System.currentTimeMillis();

                    System.out.println("FACTORY tomó " + (endTime - startTime) + " milliseconds");
                    balls=board.getBalls();

                    Thread object = new Thread(new ThreadGeneral());
                    object.start();

                }
            });
            addButton(buttonPanel, "Builder", new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Board board = new Board();

                    number = Integer.valueOf(textfieldN.getText());
                    velocidad=Integer.valueOf(textfieldV.getText());
                    angle = Integer.valueOf(textfieldA.getText());

                    if(textfieldC.getText().equals("RED")){
                        color =  Color.RED;
                    }
                    if(textfieldC.getText().equals("BLUE")){
                        color =  Color.BLUE;
                    }
                    if(textfieldC.getText().equals("YELLOW")){
                        color =  Color.YELLOW;
                    }
                    if(textfieldC.getText().equals("GREEN")){
                        color =  Color.GREEN;
                    }



                    DELAY=11-(velocidad);
                    long startTime = System.currentTimeMillis();
                    board.generateBalls(number, color, angle,velocidad, 3);
                    long endTime = System.currentTimeMillis();

                    System.out.println("BUILDER tomó " + (endTime - startTime) + " milliseconds");
                    balls=board.getBalls();

                    Thread object = new Thread(new ThreadGeneral());
                    object.start();

                }
            });
            addButton(buttonPanel, "Prototype", new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Board board = new Board();

                    number = Integer.valueOf(textfieldN.getText());
                    velocidad=Integer.valueOf(textfieldV.getText());
                    angle = Integer.valueOf(textfieldA.getText());
                    if(textfieldC.getText().equals("RED")){
                        color =  Color.RED;
                    }
                    if(textfieldC.getText().equals("BLUE")){
                        color =  Color.BLUE;
                    }
                    if(textfieldC.getText().equals("YELLOW")){
                        color =  Color.YELLOW;
                    }
                    if(textfieldC.getText().equals("GREEN")){
                        color =  Color.GREEN;
                    }



                    DELAY=11-(velocidad);
                    long startTime = System.currentTimeMillis();
                    board.generateBalls(number, color, angle,velocidad, 1);
                    long endTime = System.currentTimeMillis();

                    System.out.println("PROTOTYPE tomó " + (endTime - startTime) + " milliseconds");
                    balls=board.getBalls();

                    Thread object = new Thread(new ThreadGeneral());
                    object.start();

                }
            });
            addButton(buttonPanel, "Pool", new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    Board board = new Board();

                    number = Integer.valueOf(textfieldN.getText());
                    velocidad=Integer.valueOf(textfieldV.getText());
                    angle = Integer.valueOf(textfieldA.getText());
                    if(textfieldC.getText().equals("RED")){
                        color =  Color.RED;
                    }
                    if(textfieldC.getText().equals("BLUE")){
                        color =  Color.BLUE;
                    }
                    if(textfieldC.getText().equals("YELLOW")){
                        color =  Color.YELLOW;
                    }
                    if(textfieldC.getText().equals("GREEN")){
                        color =  Color.GREEN;
                    }



                    DELAY=11-(velocidad);
                    long startTime = System.currentTimeMillis();
                    board.generateBalls(number, color, angle,velocidad, 1);
                    long endTime = System.currentTimeMillis();

                    System.out.println("Pool tomó " + (endTime - startTime) + " milliseconds");
                    balls=board.getBalls();

                    Thread object = new Thread(new ThreadGeneral());
                    object.start();

                }
            });

            addButton(buttonPanel, "Close", new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    System.exit(0);
                }
            });
            add(buttonPanel, BorderLayout.SOUTH);
        }
        public void getInfo(){

        }

        public void addButton(Container c, String title, ActionListener listener) {
            JButton button = new JButton(title);
            c.add(button);
            button.addActionListener(listener);
        }

        class MultithreadingDemo extends Thread implements Runnable
        {
            public void run()
            {
                try
                {
                  addBall();
                }
                catch (Exception e)
                {

                }
            }
        }
        class MultithreadingDemo2 extends Thread implements Runnable
        {
            public void run()
            {
                for (int i = 1; i <= STEPS; i++) {
                    try {
                        comp.paint(comp.getGraphics());
                        Thread.sleep(50);
                    } catch (Exception e) {

                    }
                }
            }
        }
        class ThreadGeneral extends Thread implements Runnable
        {
            public void run()
            {

                    try {
                        Thread object = new Thread(new MultithreadingDemo2());
                        object.start();

                        for(int i =0; i<number;i++){
                            Thread object2 = new Thread(new MultithreadingDemo());
                            object2.start();
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }


                    } catch (Exception e) {
                        System.out.println("Exception is caught ");
                    }
            }
        }

        public void addBall() {
            try {
                Ball ball = balls.remove(0);
                comp.add(ball);

                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds(),ball.getAngulo());
                    Thread.sleep(11-(ball.getVelocidad()));
                }
            } catch (InterruptedException e) {
            }
        }

        private BallComponent comp;
        private List<Ball> balls;

        private int number;
        private Color color;
        private int velocidad;
        private int angle;

        public static final int DEFAULT_WIDTH = 1000;

        public static final int DEFAULT_HEIGHT = 500;

        public static final int STEPS = 100000000;

        public  int DELAY;
    }
}
