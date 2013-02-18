/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.action;

import com.rop.control.action.Action;
import com.rop.mechanism.Shuttle;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author robotics
 */
public class DelayAction extends Action
{
    private double DELAY_TIME = 1.0;
    Timer timer;

    public DelayAction(double delayTime)
    {
        DELAY_TIME = delayTime;
    }

    protected void startAction()
    {
        timer = new Timer();
        timer.start();
    }

    protected boolean testComplete()
    {
        return ( timer.get() > DELAY_TIME );
    }

    protected void stopAction()
    {
    }

}
