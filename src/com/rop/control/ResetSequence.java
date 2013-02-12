/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

/**
 *
 * @author robotics
 */
public class ResetSequence extends Sequence
{
    protected void sequenceInit()
    {
        steps.addElement( new ResetStep1() );
        steps.addElement( new ResetStep2() );
    }
}
