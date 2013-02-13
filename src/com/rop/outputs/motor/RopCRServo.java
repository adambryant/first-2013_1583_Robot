/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs.motor;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author robotics
 */
public class RopCRServo implements PIDOutput
{
    Servo servo;

    public RopCRServo( int channel, boolean reversed )
    {
        servo = new Servo(channel);
    }

    public void pidWrite( double d )
    {
        System.out.println("pidWrite: " + d);
        
        if ( d > 0.1)
            servo.set( 1.0 );
        else if ( d < -0.1 )
            servo.set( 0.0 );
        else
            servo.set( 0.50 );
    }
}
