/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import com.rop.inputs.Driver;
import com.rop.outputs.Chassis;
import edu.wpi.first.wpilibj.SimpleRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot
{
    Driver driver;
    Chassis chassis;

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous()
    {
    }

    protected void disabled()
    {
        super.disabled();
    }

    protected void robotInit()
    {
        super.robotInit();

        driver = Driver.getInstance();
        chassis = Chassis.getInstance();
    }

    public void robotMain()
    {
        super.robotMain();
    }

    public void startCompetition()
    {
        super.startCompetition();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl()
    {
        while ( isEnabled() )
        {
            chassis.drive( driver.getX(), driver.getY(), driver.getRot(), 0.0f );
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test()
    {
    }
}
