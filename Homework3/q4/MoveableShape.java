/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4;

import java.awt.*;

/**
A shape that can be moved around.
*/
public interface MoveableShape
{
    
    /**
    Draws the shape.
    @param g2 the graphics context
    */
    void draw(Graphics2D g2);
    
    /**
    Moves the shape.
    It is up to the shape to move itself, for example by tracking the time 16 its last movement, its position, and velocity.
    */
    void move();
}
