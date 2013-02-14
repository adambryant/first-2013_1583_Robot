/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import java.util.Vector;
/**
 *
 * @author robotics
 */
public abstract class Step
{
    private boolean cancelled = false;
    protected Vector actions = new Vector();

    abstract protected void stepInit();

    final public void cancel()
    {
        for ( int i = 0; i < actions.size(); i++ )
        {
            Action act = (Action)actions.elementAt( i );
            act.cancel();
        }

        cancelled = true;
    }

    final public void doStep()
    {
        stepInit();
        
        for ( int i = 0; i < actions.size(); i++ )
        {
            System.out.println("Starting Action: " + i);

            Action act = (Action)actions.elementAt( i );
            act.start();
        }
    }

    final public boolean isDone()
    {
        boolean done = true;

        if (cancelled)
        {
            return true;
        }

        for ( int i = 0; i < actions.size(); i++ )
        {
//            System.out.println("Checking action: " + i);

            Action act = (Action)actions.elementAt( i );
            if (act.isAlive())
            {
//                System.out.println("Action " + i + " is NOT done");
                
                done = false;
            }
        }
        if (done == true)
            System.out.println("Step is DONE");

        return done;
    }
}
