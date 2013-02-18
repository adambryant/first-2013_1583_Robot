/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.action;

import com.rop.control.action.Action;
import com.rop.mechanism.Shuttle;

/**
 *
 * @author robotics
 */
public class ShuttleToBottomAction extends Action
{
    Shuttle shuttle;

    protected void startAction()
    {
        shuttle = Shuttle.getInstance();

        shuttle.down();
    }

    protected boolean testComplete()
    {
        return shuttle.getBottomLimit();
    }

    protected void stopAction()
    {
        shuttle.stop();
    }

}
