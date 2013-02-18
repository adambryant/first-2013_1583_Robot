/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShuttleTo30PointAction;

/**
 * Step 3 - Shift CG to put arm against inside of rung 2
 *
 * @author robotics
 */
public class ClimbStep7 extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShuttleTo30PointAction() );
    }
}
