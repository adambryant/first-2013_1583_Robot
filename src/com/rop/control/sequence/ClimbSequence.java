/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control.sequence;

import com.rop.control.step.ClimbStep1;
import com.rop.control.step.ClimbStep3;
import com.rop.control.step.ClimbStep4;
import com.rop.control.step.ClimbStep4a;

/**
 *
 * @author robotics
 */
public class ClimbSequence extends Sequence
{
    protected void sequenceInit()
    {
        steps.addElement( new ClimbStep1() );
//        steps.addElement( new ClimbStep2() );
        steps.addElement( new ClimbStep3() );
        steps.addElement( new ClimbStep4() );
        steps.addElement( new ClimbStep4a() );
//        steps.addElement( new ClimbStep4b() );
//        steps.addElement( new ClimbStep5() );
//        steps.addElement( new ClimbStep5a() );
//        steps.addElement( new ClimbStep6() );
//        steps.addElement( new ClimbStep6a() );
//        steps.addElement( new ClimbStep7() );
    }
}
