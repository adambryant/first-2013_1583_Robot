/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShiftCGAction;
import com.rop.mechanism.RobotBody;

/**
 *
 * @author robotics
 */
public class TestStep3 extends Step
{

    protected void stepInit()
    {
        actions.addElement( new ShiftCGAction(RobotBody.CG_HALF_BACK, 0.0));
    }
}
