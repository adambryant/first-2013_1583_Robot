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
        motor = new Servo(2);
    }

    public static RobotBody getInstance()
    {
        return RobotBodyHolder.INSTANCE;
    }

    private static class RobotBodyHolder
    {
        private static final RobotBody INSTANCE = new RobotBody();
    }

    public void shiftCgFront()
    {
        motor.set( 0.25 );
    }

    public void shiftCgBack()
    {
        motor.set( 0.75 );
    }

    public void shiftCgCenter()
    {
        motor.set( 0.50 );
    }

    public boolean shiftDone()
    {
        return true;
    }
}
