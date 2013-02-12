/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.control;

import com.rop.mechanism.RobotBody;
import com.rop.mechanism.Shuttle;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author robotics
 */
public class Control
{
    Shuttle shuttle;
    RobotBody body;
    int step = 0;

    private Control()
    {
        shuttle = Shuttle.getInstance();
        body = RobotBody.getInstance();
    }

    public static Control getInstance()
    {
        return ControlHolder.INSTANCE;
    }

    private static class ControlHolder
    {
        private static final Control INSTANCE = new Control();
    }

    public void testToTop()
    {
        shuttle.toTop();
    }

    public void testToBottom()
    {
        shuttle.toBottom();
    }

    public void testCycle()
    {
        shuttle.toTop();
        Timer.delay( 0.5 );

        while (shuttle.toTopIsActive())
            ;

        shuttle.toBottom();
    }

    public void testLimitSwitches()
    {
        shuttle.testLimitSwitches();
    }

    public void reset()
    {
        shuttle.toTop();
        Timer.delay( 0.5 );

        while (shuttle.toTopIsActive())
            ;

        shuttle.halfwayDown();
    }
}
