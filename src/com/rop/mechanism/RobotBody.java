/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import com.rop.outputs.motor.RopCRServo;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author robotics
 */
public class RobotBody
{
    public static final double CG_FULL_BACK     = 75.0;
    public static final double CG_HALF_BACK     = 37;
    public static final double CG_CENTER        = 0;
    public static final double CG_HALF_FORWARD  = -37;
    public static final double CG_FULL_FORWARD  = -75;

    private double setPoint = 0.0;
    private Gyro gyro;
//    private RopCRServo motor;
    private Servo motor;

    private RobotBody()
    {
//        motor = new RopCRServo(2, false);
        motor = new Servo(2);
        gyro = new Gyro(2);
    }

    public static RobotBody getInstance()
    {
        return RobotBodyHolder.INSTANCE;
    }

    private static class RobotBodyHolder
    {
        private static final RobotBody INSTANCE = new RobotBody();
    }

    public void shiftCg( double value )
    {
        System.out.println("In shiftCg()");
        setPoint = value;
    }

    public boolean shiftDone()
    {
        double angle = gyro.getAngle();

        System.out.println("angle: " + angle + "  setPoint: " + setPoint);

        if ( Math.abs( angle - setPoint) < 5 )
        {
            motor.set( 0.50 );
            return true;
        }

        if (angle < setPoint)
            motor.set( 0.15 );
        else if ( angle > setPoint )
            motor.set( 0.65 );

        return false;
    }

    public double getGyroAngle()
    {
        return gyro.getAngle();
    }
    
    public void setSpeed( double speed )
    {
        // Incoming value is -1.0 to 1.0.  Need to translate it for a servo
        double incoming = speed + 1.0;
        double motorSpeed = incoming / 2.0;
//        double motorSpeed = percent * 1.0;

        System.out.println("speed: " + speed + "  incoming: " + incoming + "  motorSpeed: " + motorSpeed);


        // Check gyro to prevent overdriving!!!!
        motor.set( motorSpeed );
    }
}
