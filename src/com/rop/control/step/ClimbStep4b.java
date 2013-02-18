/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.step;

import com.rop.control.action.ShuttleToBottomXSecsAction;
import com.rop.control.action.DelayAction;

/**
 * Step 3 - Shuttle to top
 *
 * @author robotics
 */
public class ClimbStep4b extends Step
{
    protected void stepInit()
    {
        actions.addElement( new ShuttleToBottomXSecsAction( 3.0 ) );
        actions.addElement( new DelayAction( 6.0 ) );
    }
}
