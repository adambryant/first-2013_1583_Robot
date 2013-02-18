/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShuttleToBottomAction;
import com.rop.control.action.ShiftCGAction;
import com.rop.mechanism.RobotBody;

/**
 * Step 1 - Start initial climb
 * 
 * @author robotics
 */
public class ClimbStep1 extends Step
{
    protected void stepInit()
    {
//        actions.addElement( new ShiftCGCenterAction(0.0) );
        actions.addElement( new ShuttleToBottomAction() );
        actions.addElement( new ShiftCGAction(RobotBody.CG_FULL_BACK, 1.5) );
//        actions.addElement( new ShiftCGHalfBackAction(4.0) );
        actions.addElement( new ShiftCGAction(RobotBody.CG_HALF_FORWARD, 5.0) );
    }
}
