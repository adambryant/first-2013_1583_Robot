/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.RobotBody;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author robotics
 */
public class ShiftCGFrontAction extends Action
{
    private double delay = 0.0;
    Timer timer;
    int state = 0;
    RobotBody body;

    public ShiftCGFrontAction( double delay )
    {
        this.delay = delay;
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
                body.shiftCgFront();
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
