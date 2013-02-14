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
public class RopCRServo extends Servo implements PIDOutput
{
//    Servo servo;

    public RopCRServo( int channel, boolean reversed )
    {
        super(channel);
//        servo = new Servo(channel);
    }

    public void pidWrite( double d )
    {
        System.out.println("pidWrite: " + d);
        
        if ( d < -0.1)
            super.set( 0.75 );
        else if ( d > 0.1 )
            super.set( 0.25 );
        else
            super.set( 0.50 );
    }
}
