/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

/**
 * Step 3 - Shift CG to put arm against inside of rung 2
 *
 * @author robotics
 */
public class ResetStep1 extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShiftCGCenterAction(0.0) );
        actions.addElement( new ShuttleToTopAction() );
    }
}
