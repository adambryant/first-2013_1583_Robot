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
public class ClimbStep4a extends Step
{
    protected void stepInit()
    {
        actions.addElement( new DelayAction( 1.5 ) );
    }
}
