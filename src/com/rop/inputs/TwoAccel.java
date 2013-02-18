/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.inputs;

import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author robotics
 */
public class TwoAccel implements PIDSource
{

    private Accelerometer arm;
    private Accelerometer body;
    private double diff;

    public TwoAccel( int armPort, int bodyPort )
    {
        arm = new Accelerometer( armPort );
        body = new Accelerometer( bodyPort );
    }

    public double pidGet()
    {
        diff = body.getAcceleration() - arm.getAcceleration();
        return diff;
    }

    public double getDiff()
    {
        return diff;
    }
}
