/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.RobotBody;

/**
 * Step 3 - Shuttle to top
 *
 * @author robotics
 */
public class ClimbStep4 extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShiftCGAction(RobotBody.CG_HALF_FORWARD, 0.0 ) );
    }
}
