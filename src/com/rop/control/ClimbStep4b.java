/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

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
        actions.addElement( new DelayAction( 12.0 ) );
    }
}
