/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import com.rop.outputs.motor.RopCRServo;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author robotics
 */
public class RobotBody
{
    public static final double CG_FULL_BACK     = 455;
    public static final double CG_HALF_BACK     = 477;
    public static final double CG_CENTER        = 500;
    public static final double CG_HALF_FORWARD  = 522;
    public static final double CG_FULL_FORWARD  = 555;
//    public static final double CG_FULL_BACK     = 0.0;
//    public static final double CG_HALF_BACK     = 0.25;
//    public static final double CG_CENTER        = 0.50;
//    public static final double CG_HALF_FORWARD  = 0.75;
//    public static final double CG_FULL_FORWARD  = 1.0;

//    public static final int ACC_FULL_BACK     = 455;
//    public static final int ACC_HALF_BACK     = 477;
//    public static final int ACC_CENTER        = 500;
//    public static final int ACC_HALF_FORWARD  = 522;
//    public static final int ACC_FULL_FORWARD  = 555;

    public static final double K_P = 0.1;
    public static final double K_I = 0.0; //0.05;
    public static final double K_D = 0.0; //0.2;

    private AnalogChannel accIn = null;
    private RopCRServo motor;

    private PIDController cgController;

    private RobotBody()
    {
        motor = new RopCRServo(2, false);
        accIn = new AnalogChannel(7);
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
//        motor.set( value );
        cgController = new PIDController(K_P, K_I, K_D, accIn, motor);
        cgController.enable();
        cgController.setSetpoint( value );
        cgController.setPercentTolerance( 20.0 );
    }

    public boolean shiftDone()
    {
        System.out.println("In shiftDone()");
        if (cgController.onTarget())
        {
            cgController.disable();
            cgController.free();
            return true;
        }
        else
            return false;
    }
}
