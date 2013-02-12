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
    private boolean cancelled = false;

    final public void cancel()
    {
        cancelled = true;
    }

    protected abstract void startAction();

    // This should return false normally, true to cause thread to end
    protected abstract boolean testComplete();

    protected abstract void stopAction();

    final public void run()
    {
        startAction();

        while ( !testComplete() && !cancelled )
        {
            Thread.yield();
        }

        stopAction();
    }
}
