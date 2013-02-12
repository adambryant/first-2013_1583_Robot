/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.Shuttle;

/**
 *
 * @author robotics
 */
public class ShuttleToTopAction extends Action
{
    Shuttle shuttle;

    protected void startAction()
    {
        shuttle = Shuttle.getInstance();

        shuttle.up();
    }

    protected boolean testComplete()
    {
//        System.out.println("TopLimit: " + shuttle.getTopLimit());
        return shuttle.getTopLimit();
    }

    protected void stopAction()
    {
//        System.out.println("stopAction called");
        shuttle.stop();
    }

}
