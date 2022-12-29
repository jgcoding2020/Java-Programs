/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BarGraph;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author jgard
 */
public class BarGraphModel implements Icon
{   
    private final Color color;
    private int width = 100;
    private final int height = 20;
    
    /**
     * BarGraphModel class method getIconWidth() returns object width
     * @param colors
     * @precondition none
     * @postcondition this.color = colors;
     */
    public BarGraphModel(Color colors){
        color = colors;
    }
    /**
     * BarGraphModel class method getIconWidth() returns object width
     * @return
     * @precondition none
     * @postcondition none
     */
    public int getIconWidth()
    {
        return width;
    }

    /**
     * BarGraphModel class method getIconHeight() returns object height
     * @return
     * @precondition none
     * @postcondition none
     */
    public int getIconHeight()
    {
        return height;
    }

    /**
     * Class BarGraphModel method paintIcon modifies Icon
     * @param c
     * @param g
     * @param x
     * @param y
     * @precondition none
     * @postcondition Icon.color = color; Icon.width = width;
     */
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        Shape rectangle = new Rectangle2D.Double(x, y, width, height);
        g2.draw(rectangle);
        
        g2.setColor(color);
        g2.fill(rectangle);
    }
    
    /**
     * BarGraphModel class method view() adds listener to text field and repaints object Icon
     * @param text
     * @param graph
     * @precondition none
     * @postcondition none
     */
    public void view(JTextField text, JLabel graph){
        text.addActionListener(event -> {int num = Integer.parseInt(text.getText()); this.width = num; graph.repaint();});
    }
  
    // main method  
    public static void main(String args[]){    
        JFrame frame = new JFrame("Horizontal Bar Graph");
        frame.setLayout(new FlowLayout());
        
        GridLayout layout = new GridLayout(3, 1);
        layout.setVgap(20);
        
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        
        BarGraphModel bar = new BarGraphModel(Color.RED);
        JLabel graph = new JLabel(bar, SwingConstants.LEFT);
        panel.add(graph);
        BarGraphModel bar2 = new BarGraphModel(Color.YELLOW);
        JLabel graph2 = new JLabel(bar2, SwingConstants.LEFT);
        panel.add(graph2);
        BarGraphModel bar3 = new BarGraphModel(Color.BLUE);
        JLabel graph3 = new JLabel(bar3, SwingConstants.LEFT);
        panel.add(graph3);
        frame.add(panel);
        
        JPanel panel_2 = new JPanel(layout);
        
        JTextField text = new JTextField(3);
        bar.view(text, graph);
        panel_2.add(text);
        JTextField text2 = new JTextField(3);
        bar2.view(text2, graph2);
        panel_2.add(text2);
        JTextField text3 = new JTextField(3);
        bar3.view(text3, graph3);
        panel_2.add(text3);
        frame.add(panel_2);
        
        frame.setVisible(true);
        frame.pack();     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}    
