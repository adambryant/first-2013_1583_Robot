/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import com.rop.inputs.TwoAccel;
import com.rop.outputs.motor.RopCRServo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author robotics
 */
public class RobotBody
{
//    public static final double CG_FULL_BACK     = 75.0;
//    public static final double CG_HALF_BACK     = 37;
//    public static final double CG_CENTER        = 0;
//    public static final double CG_HALF_FORWARD  = -37;
//    public static final double CG_FULL_FORWARD  = -75;
    public static final double CG_FULL_BACK     = 0.340;
    public static final double CG_HALF_BACK     = 0.170;
    public static final double CG_CENTER        = 0.0;
    public static final double CG_HALF_FORWARD  = -0.15;
    public static final double CG_FULL_FORWARD  = -0.30;

//    private static double K_P = 0.2;   // 0.07;
//    private static double K_I = 0.02;    // 0.01;
//    private static double K_D = 0.0;    // 0.1;

//    private Gyro gyro;
//    private Gyro armGyro;
    private RopCRServo motor;
//    private PIDController pid;
    private TwoAccel two;
    private double setPoint = 0.0;

    private RobotBody()
    {
//        gyro = new Gyro(2);
//        armGyro = new Gyro(1);
        motor = new RopCRServo(2);
        two = new TwoAccel(1,2);
//        pid = new PIDController( K_P, K_I, K_D, two, motor);
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
//        if (pid.isEnable())
//            pid.disable();
    }

    public void shiftCg( double value )
    {
        System.out.println("In shiftCg()");

        setPoint = value;
//        pid.setSetpoint( value );
//
//        if (!pid.isEnable())
//            pid.enable();
    }

    public boolean shiftDone()
    {
        double diff = two.pidGet();

        SmartDashboard.putNumber( "diff", diff);
        SmartDashboard.putNumber( "Setpoint", setPoint);
        System.out.println("In shiftDone(), diff: " + diff + "  Setpoint: " + setPoint);

        if ( diff < setPoint)
            setSpeed(0.1);
        else
            setSpeed(-0.1);

        if (Math.abs( diff - setPoint) < 0.03)
            return true;

        return false;
    }

    public void setSpeed( double speed )
    {
        motor.set( speed );
    }

    public double getDiff()
    {
        return two.getDiff();
    }

//    public double getAngle()
//    {
//        return this.gyro.getAngle();
//    }
//
//    public double getArmAngle()
//    {
//        return this.armGyro.getAngle();
//    }

//    public PIDController getPidController()
//    {
//        return pid;
//    }
}
