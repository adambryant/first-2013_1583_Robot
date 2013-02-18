/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.action;

import com.rop.control.action.Action;
import com.rop.mechanism.RobotBody;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author robotics
 */
public class ShiftCGAction extends Action
{
    private double delay = 0.0;
    private double value = 0.5;
    private Timer timer;
    private int state = 0;
    private RobotBody body;

    public ShiftCGAction( double value, double delay )
    {
        this.delay = delay;
        this.value = value;
    }

    protected void startAction()
    {
        body = RobotBody.getInstance();
        timer = new Timer();
        timer.start();
    }

    protected boolean testComplete()
    {
        switch( state )
        {
            case 0:
                if (timer.get() > delay)
                    state++;
                break;

            case 1:
                body.shiftCg(value);
                state++;
                break;

            case 2:
                if ( body.shiftDone() )
                    return true;
                break;
        }

        return false;
    }

    protected void stopAction()
    {
        timer.stop();
    }
}
