/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.RobotBody;

/**
 * Step 3 - Shift CG to put arm against inside of rung 2
 *
 * @author robotics
 */
public class ClimbStep3 extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShuttleToTopAction() );
        actions.addElement( new ShiftCGAction(RobotBody.CG_HALF_BACK, 7.0) );
    }
}
