/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShuttleToTopAction;
import com.rop.control.action.ShiftCGAction;
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
        actions.addElement( new ShiftCGAction(RobotBody.CG_CENTER, 7.0) );
    }
}
