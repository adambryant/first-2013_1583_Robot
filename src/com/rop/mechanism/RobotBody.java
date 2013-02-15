/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import com.rop.outputs.motor.RopCRServo;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;

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

    private static double K_P = 0.002;
    private static double K_I = 0.0;
    private static double K_D = 0.001;

    private Gyro gyro;
    private RopCRServo motor;
    private PIDController pid;

    private RobotBody()
    {
        gyro = new Gyro(2);
        motor = new RopCRServo(2);
        pid = new PIDController( K_P, K_I, K_D, gyro, motor);
    }

    public static RobotBody getInstance()
    {
        return RobotBodyHolder.INSTANCE;
    }

    private static class RobotBodyHolder
    {
        private static final RobotBody INSTANCE = new RobotBody();
    }

    public void disable()
    {
        if (pid.isEnable())
            pid.disable();
    }

    public void shiftCg( double value )
    {
        System.out.println("In shiftCg()");
        
        pid.setSetpoint( value );

        if (!pid.isEnable())
            pid.enable();
    }

    public boolean shiftDone()
    {
        return true;
    }

    public void setSpeed( double speed )
    {
        motor.set( speed );
    }
}
