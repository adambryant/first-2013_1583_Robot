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
    public RopCRServo( int channel )
    {
        super(channel);
    }

    public void pidWrite( double d )
    {
//        System.out.println("pidWrite: " + d);

        this.setValue( d );
    }

    public void set( double value )
    {
        this.setValue( value );
    }

    private void setValue( double speed )
    {
        speed *= -1.0;
        
        // Incoming value is -1.0 to 1.0.  Need to translate it for a servo
        double incoming = speed + 1.0;
        double motorSpeed = incoming / 2.0;

        if (motorSpeed < 0.0)
            motorSpeed = 0.0;
        else if (motorSpeed > 1.0)
            motorSpeed = 1.0;

//        System.out.println("speed: " + speed + "  incoming: " + incoming + "  motorSpeed: " + motorSpeed);

        super.set( motorSpeed  );
    }
}
