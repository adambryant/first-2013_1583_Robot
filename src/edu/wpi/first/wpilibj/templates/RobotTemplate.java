/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import com.rop.control.ClimbSequence;
import com.rop.control.ResetSequence;
import com.rop.control.TestSequence;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot
{
//    AnalogChannel accIn;

    protected void robotInit()
    {
        super.robotInit();

//        accIn = new AnalogChannel(7);
    }

    protected void disabled()
    {
        
    }

//    public void robotMain()
//    {
//        super.robotMain();
//    }

//    public void startCompetition()
//    {
////        super.startCompetition();
//    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous()
    {
//        while ( isEnabled() )
//        {
//            System.out.println("In isEnabled() in autonomous");
//            Timer.delay( 1.0 );
//        }
//        System.out.println("After isEnabled() while loop in autonomous");
        ClimbSequence climb = new ClimbSequence();

        climb.doSequence();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl()
    {
        while ( isEnabled() )
        {
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test()
    {
        
//        while ( isEnabled() )
//        {
//            System.out.println("Value: " + accIn.getValue() + "   Voltage: " + accIn.getVoltage());
//            Timer.delay( 0.5 );
//        }

//        ResetSequence reset = new ResetSequence();
//        reset.doSequence();

        TestSequence test = new TestSequence();
        test.doSequence();
    }
}
