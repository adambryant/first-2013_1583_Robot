/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author robotics
 */
public class RobotBody
{
    Servo motor;

    private RobotBody()
    {
    }

    public static RobotBody getInstance()
    {
        return RobotBodyHolder.INSTANCE;
    }

    private static class RobotBodyHolder
    {
        private static final RobotBody INSTANCE = new RobotBody();
    }

    public void shiftCgFwd( double delaySeconds )
    {
        motor.set( 0.25 );
    }

    public void shiftCgBack( double delaySeconds )
    {
        motor.set( 0.75 );
    }

    public void shiftCgCenter( double delaySeconds )
    {
        motor.set( 0.50 );
    }
}
