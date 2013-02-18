/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.sequence;

import com.rop.control.step.TestStep1;
import com.rop.control.sequence.Sequence;

/**
 *
 * @author robotics
 */
public class TestSequence extends Sequence
{

    protected void sequenceInit()
    {
        steps.addElement( new TestStep1() );
    }
}
