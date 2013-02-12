/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

/**
 *
 * @author robotics
 */
public abstract class Action extends Thread
{

    private boolean active = false;
    private boolean cancelled = false;

    public boolean isActive()
    {
        return active;
    }

    public void cancel()
    {
        cancelled = true;
    }

    // This should return true normally, false to cause thread to end
    public abstract boolean doAction();

    public void run()
    {
        while ( doAction() && !cancelled )
        {
            Thread.yield();
        }
    }
}
