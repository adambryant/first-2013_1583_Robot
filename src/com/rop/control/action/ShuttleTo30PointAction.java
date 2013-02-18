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
public class ShuttleTo30PointAction extends Action
{
    private final static double DELAY_TIME = 5.5;
    Shuttle shuttle;
    Timer timer;

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
