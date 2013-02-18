/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.sequence;

import com.rop.control.step.Step;
import java.util.Vector;

/**
 *
 * @author robotics
 */
public abstract class Sequence
{

    protected Vector steps = new Vector();

    abstract protected void sequenceInit();

    final public void doSequence()
    {
        sequenceInit();
        
        for ( int i = 0; i < steps.size(); i++ )
        {
            System.out.println("Step number: " + i);
            
            Step step = (Step) steps.elementAt( i );

            step.doStep();

            while ( !step.isDone() )
                ;
        }
    }
}
