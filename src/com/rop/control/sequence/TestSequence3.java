/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.sequence;

import com.rop.control.step.TestStep3;

/**
 *
 * @author robotics
 */
public class TestSequence3 extends Sequence
{

    protected void sequenceInit()
    {
        steps.addElement( new TestStep3() );
    }
}
