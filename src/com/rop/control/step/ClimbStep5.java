/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShuttleToBottomAction;
import com.rop.control.action.ShiftCGAction;
import com.rop.mechanism.RobotBody;

/**
 * Finish climb started in autonomous
 *
 * @author robotics
 */
public class ClimbStep5 extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShuttleToBottomAction() );
        actions.addElement( new ShiftCGAction(RobotBody.CG_FULL_FORWARD, 5.0) );
//        actions.addElement( new ShiftCGAction(RobotBody.CG_FULL_FORWARD, 6.0) );
//        actions.addElement( new ShiftCGAction(RobotBody.CG_FULL_FORWARD, 7.0) );
    }
}
