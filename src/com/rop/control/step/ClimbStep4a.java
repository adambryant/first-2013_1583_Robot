/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.DelayAction;

/**
 * Step 3 - Shuttle to top
 *
 * @author robotics
 */
public class ClimbStep4a extends Step
{
    protected void stepInit()
    {
        actions.addElement( new DelayAction( 1.5 ) );
    }
}
