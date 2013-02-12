/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.mechanism;

import com.rop.inputs.LimitSwitch;
import com.rop.outputs.motor.RopVictor;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author robotics
 */
public class Shuttle
{
    static final double UP_SPEED = 0.25;
    static final double DOWN_SPEED = -0.3;
    static final double DOWN_TIME = 2.5;

    private RopVictor motor;
    private LimitSwitch topLimit;
    private LimitSwitch bottomLimit;
    private MoveShuttle toTopThread;
    private MoveShuttle toBottomThread;

    private Shuttle()
    {
        topLimit = new LimitSwitch( 1, true );
        bottomLimit = new LimitSwitch( 2, false );
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

    public void toTop()
    {
        if ( toTopThread == null ||
                (toTopThread != null && !toTopThread.isActive()) )
        {
            toTopThread = new MoveShuttle( UP_SPEED, topLimit );
            toTopThread.start();
        }
    }

    public void toBottom()
    {
        if ( toBottomThread == null ||
                (toBottomThread != null && !toBottomThread.isActive()) )
        {
            toBottomThread = new MoveShuttle( DOWN_SPEED, bottomLimit );
            toBottomThread.start();
        }
    }

    public boolean toTopIsActive()
    {
        return toTopThread.isActive();
    }

    public boolean toBottomIsActive()
    {
        return toBottomThread.isActive();
    }

    // NOTE!! Assumes shuttle is at the top.
    public void halfwayDown()
    {
        Timer timer = new Timer();
        motor.set( DOWN_SPEED );
        timer.start();
        while (timer.get() < DOWN_TIME)
            ;
        motor.stopMotor();
    }

    public void testLimitSwitches()
    {
        System.out.println("Top: " + this.topLimit.get() + "  Bottom: " + this.bottomLimit.get() );
    }

    protected class MoveShuttle extends Thread
    {
        private double speed;
        private LimitSwitch limit;
        private boolean active = false;
        private boolean cancelled = false;

        public MoveShuttle( double motorSpeed, LimitSwitch limit )
        {
            speed = motorSpeed;
            this.limit = limit;
        }

        public void run()
        {
            active = true;

            motor.set( speed );

            System.out.println("Speed: " + speed + "  Sw: " + limit.get() + "  SW is on: " + limit.getChannel());

            while ( !limit.get() && !cancelled )
            {
                System.out.println("Speed: " + speed + "  Sw: " + limit.get());

                Thread.yield();
            }

            motor.stopMotor();

            active = false;
        }

        public boolean isActive()
        {
            return active;
        }

        public void setCancelled( boolean cancelled )
        {
            this.cancelled = cancelled;
        }

        
    }
}
