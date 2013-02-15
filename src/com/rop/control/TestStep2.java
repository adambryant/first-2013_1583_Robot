/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.RobotBody;

/**
 *
 * @author robotics
 */
public class TestStep2 extends Step
{

    protected void stepInit()
    {
        actions.addElement( new ShiftCGAction(RobotBody.CG_FULL_FORWARD, 0.0));
    }
}
