/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShuttleToBottomAction;

/**
 * Finish climb started in autonomous
 *
 * @author robotics
 */
public class ClimbStep2 extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShuttleToBottomAction() );
    }
}
