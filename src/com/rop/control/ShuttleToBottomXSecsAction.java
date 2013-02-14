/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.Shuttle;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author robotics
 */
public class ShuttleToBottomXSecsAction extends Action
{
    private double DELAY_TIME = 1.0;
    Shuttle shuttle;
    Timer timer;

    public ShuttleToBottomXSecsAction(double moveTime)
    {
        DELAY_TIME = moveTime;
    }

    protected void startAction()
    {
        shuttle = Shuttle.getInstance();

        shuttle.down();

        timer = new Timer();
        timer.start();
    }

    protected boolean testComplete()
    {
        return ( timer.get() > DELAY_TIME );
    }

    protected void stopAction()
    {
        shuttle.stop();
    }

}
