/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

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
        actions.addElement( new ShiftCGAction(RobotBody.CG_FULL_FORWARD, 1.0) );
    }
}