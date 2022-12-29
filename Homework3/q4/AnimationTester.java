/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
This program implements an animation that moves
a car shape.
*/
public class AnimationTester
{
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
        MoveableShape shape2 = new CarShape(0, 10, CAR_WIDTH);
        MoveableShape shape3 = new CarShape(0, 20, CAR_WIDTH);
        MoveableShape shape4 = new CarShape(0, 30, CAR_WIDTH);
        
        ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
        ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);
        ShapeIcon icon3 = new ShapeIcon(shape3, ICON_WIDTH, ICON_HEIGHT);
        ShapeIcon icon4 = new ShapeIcon(shape4, ICON_WIDTH, ICON_HEIGHT);
        
        JLabel label = new JLabel(icon);
        JLabel label2 = new JLabel(icon2);
        JLabel label3 = new JLabel(icon3);
        JLabel label4 = new JLabel(icon4);
        frame.setLayout(new FlowLayout());
        
        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, event ->{shape.move(); label.repaint();});
        Timer t2 = new Timer(DELAY, event ->{shape2.move(); label2.repaint();});
        Timer t3 = new Timer(DELAY, event ->{shape3.move(); label3.repaint();});
        Timer t4 = new Timer(DELAY, event ->{shape4.move(); label4.repaint();});
        t.start();
        t2.start();
        t3.start();
        t4.start();
    }
}