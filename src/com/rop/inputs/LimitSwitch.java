/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.inputs;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author adam
 */
public class LimitSwitch
{

    DigitalInput di;
    boolean reversed = false;

    public LimitSwitch( int channel, boolean reversed )
    {
        di = new DigitalInput( channel );
        this.reversed = reversed;
    }

    public boolean get()
    {
        if ( reversed )
        {
            return !di.get();
        }
        else
        {
            return di.get();
        }
    }
}
