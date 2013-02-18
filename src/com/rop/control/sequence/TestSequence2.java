/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.sequence;

import com.rop.control.step.TestStep2;
import com.rop.control.sequence.Sequence;

/**
 *
 * @author robotics
 */
public class TestSequence2 extends Sequence
{

    protected void sequenceInit()
    {
        steps.addElement( new TestStep2() );
    }
}
