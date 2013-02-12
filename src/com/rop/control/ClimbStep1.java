/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

/**
 * Step 1 - Start initial climb
 * 
 * @author robotics
 */
public class ClimbStep1 extends Step
{
    protected void stepInit()
    {
//        actions.addElement( new ShiftCGCenterAction(0.0) );
        actions.addElement( new ShuttleToBottomAction() );
        actions.addElement( new ShiftCGFrontAction(2.0) );
    }
}
