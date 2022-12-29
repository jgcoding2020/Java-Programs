/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * ShapeIcon class creates frame with 3 buttons red, blue, and yellow plus icon changing to button color when clicked
 * @author jgard
 */

public class ShapeIcon implements Icon
{
    private Color color;
    final private int width;
    final private int height;
      
    /**
     * Class ShapeIcon constructor creates ShapeIcon objects 
     * @param aWidth
     * @param aHeight
     * @param aColor
     * @precondition none
     * @postcondition color = aColor, width = int, height = int
     */
    public ShapeIcon(int aWidth, int aHeight, Color aColor)
    {
        color = aColor;
        width = aWidth;
        height = aHeight;
    }

    /**
     * ShapeIcon class method getIconWidth() returns object width
     * @return
     * @precondition none
     * @postcondition none
     */
    public int getIconWidth()
    {
        return width;
    }

    /**
     * ShapeIcon class method getIconHeight() returns object height
     * @return
     * @precondition none
     * @postcondition none
     */
    public int getIconHeight()
    {
        return height;
    }

    /**
     * Class ShapeIcon method paintIcon modifies Icon
     * @param c
     * @param g
     * @param x
     * @param y
     * @precondition none
     * @postcondition Icon.color = color;
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
     * Class ShapeIcon method setColor() changes object color state
     * @param c
     * @precondition none
     * @postcondition color = c;
     */
    public void setColor(Color c)
    {
        color = c;
    }
    
    /**
     * Static method createButton() creates buttons and their action events
     * @param color
     * @param icon
     * @param label
     * @return
     * @precondition none
     * @postcondition new buttons with action events
     */
    public static JButton createButton(Color color, ShapeIcon icon, JLabel label)
    {
        if (color == Color.RED)
        {
            final Color c = Color.RED; 
            JButton redButton = new JButton("Red");
            redButton.addActionListener(event -> {icon.setColor(c); label.repaint();});
            return redButton;
        }
        else if (color == Color.YELLOW)
        {
            final Color c = Color.YELLOW; 
            JButton yellowButton = new JButton("Yellow");
            yellowButton.addActionListener(event -> {icon.setColor(c); label.repaint();});
            return yellowButton;
        }
        else
        {
            final Color c = Color.BLUE; 
            JButton blueButton = new JButton("Blue");
            blueButton.addActionListener(event -> {icon.setColor(c); label.repaint();});
            return blueButton;
        }
    }
    
    /**
     * static main method() creates objects and utilizes their class methods
     * @param args
     * @precondition none
     * @postcondition none
     */
    public static void main(String[] args)
    {
        //creates JFrame, ShapeIcon, and JLabel objects, sets FlowLayout,  
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        ShapeIcon icon = new ShapeIcon(100, 50, Color.YELLOW);
        JLabel label = new JLabel(icon);
        
        //color array for buttons action events
        Color[] colors = new Color[]{Color.RED, Color.YELLOW, Color.BLUE};
        //array for buttons once they have action events
        JButton[] btn = new JButton[3];
        int i;
        //loop that stores action event buttons in each index (0 to 2) of btn[]   
        for (i = 0; i < 3; i++) 
        {
            btn[i] = createButton(colors[i], icon, label);
        }
        
        //adds contents to window frame
        frame.add(label);
        frame.add(btn[0]);
        frame.add(btn[1]);
        frame.add(btn[2]);
        
        //exits program when window frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fits window to content size
        frame.pack();
        //sets frame to visible
        frame.setVisible(true);
    }
}
