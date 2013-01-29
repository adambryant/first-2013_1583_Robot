/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs;

import com.rop.outputs.motor.RopJaguar;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author Adam
 */
public class Chassis
{

    private static Chassis INSTANCE = null;
    private RobotDrive drive;
    private RopJaguar leftMotor1 = null;
    private RopJaguar leftMotor2 = null;
    private RopJaguar rightMotor1 = null;
    private RopJaguar rightMotor2 = null;

    private Chassis()
    {
        leftMotor1 = new RopJaguar( 9, true );
        leftMotor2 = new RopJaguar( 10, false );
        rightMotor1 = new RopJaguar( 1, true );
        rightMotor2 = new RopJaguar( 2, true );

        drive = new RobotDrive( leftMotor1, leftMotor2, rightMotor1, rightMotor2 );
    }

    public static Chassis getInstance()
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new Chassis();
        }

        return INSTANCE;
    }

//    public void drive( double xVal, double yVal )
//    {
//        double tmpLeft = yVal;
//
//        tmpLeft += xVal;
//        tmpLeft = normalize( tmpLeft );
//
//        leftMotor1.set( tmpLeft );
//        leftMotor2.set( tmpLeft );
//
//        double tmpRight = yVal;
//
//        tmpRight += xVal * -1.0;
//        tmpRight = normalize( tmpRight );
//
//        rightMotor1.set( tmpRight );
//        rightMotor2.set( tmpRight );
//    }
    public void drive( double x, double y, double rotation, double gyro )
    {
        // Y axis is inverted like the joystick, which we fixed previously,
        // so unfix it here.
        drive.mecanumDrive_Cartesian( x, y * -1.0, rotation, gyro );
    }

    private double normalize( double val )
    {
        if ( val < -1.0 )
        {
            return -1.0;
        }
        else if ( val > 1.0 )
        {
            return 1.0;
        }
        else
        {
            return val;
        }
    }

    public void stop()
    {
        leftMotor1.set( 0.0 );
        leftMotor2.set( 0.0 );
        rightMotor1.set( 0.0 );
        rightMotor2.set( 0.0 );
    }

    /*
     * Will send maximum and minimum values to Jaguars continuosly
     */
//    public void calibrate()
//    {
//        Watchdog.getInstance().setEnabled( false );
//
//        drive( -1.0, -1.0 );
//        Timer.delay( 5.0 );
//        drive( 1.0, 1.0 );
//        Timer.delay( 5.0 );
//    }
}
