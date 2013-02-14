/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import com.rop.inputs.LimitSwitch;
import com.rop.outputs.motor.RopVictor;

/**
 *
 * @author robotics
 */
public class Shuttle
{
    static final double UP_SPEED = -0.4;
    static final double DOWN_SPEED = 0.5;

    private RopVictor motor;
    private LimitSwitch topLimit;
    private LimitSwitch bottomLimit;

    private Shuttle()
    {
        topLimit = new LimitSwitch( 2, false );
        bottomLimit = new LimitSwitch( 1, true );
        motor = new RopVictor( 1, true );
    }

    public static Shuttle getInstance()
    {
        return ShuttleHolder.INSTANCE;
    }

    private static class ShuttleHolder
    {
        private static final Shuttle INSTANCE = new Shuttle();
    }

    public void down()
    {
        motor.set( DOWN_SPEED );
    }
    public void up()
    {
        motor.set( UP_SPEED );
    }
    public void stop()
    {
        motor.set( 0.0 );
    }
    public boolean getTopLimit()
    {
        return topLimit.get();
    }
    public boolean getBottomLimit()
    {
        return bottomLimit.get();
    }

    public void setSpeed( double speed )
    {
        if ( speed > -0.05 && speed < 0.05 )
        {
            motor.set( 0.0 );
            return;
        }
        if (speed < 0.0 && bottomLimit.get())
            motor.set( 0.0 );
        else if (speed > 0.0 && topLimit.get() )
            motor.set( 0.0 );
        else
            motor.set( speed * -1.0 );
    }
}
