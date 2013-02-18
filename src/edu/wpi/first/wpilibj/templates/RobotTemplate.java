/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import com.rop.control.sequence.ClimbSequence;
import com.rop.control.sequence.ResetSequence;
import com.rop.control.sequence.TestSequence;
import com.rop.control.sequence.TestSequence2;
import com.rop.control.sequence.TestSequence3;
import com.rop.mechanism.RobotBody;
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

    RobotBody body;
//    Shuttle shuttle;
//    Driver driver;
//    Accelerometer arm;
//    Accelerometer body;

    protected void robotInit()
    {
        super.robotInit();

        body = RobotBody.getInstance();
//        shuttle = Shuttle.getInstance();
//        driver = Driver.getInstance();
//        arm = new Accelerometer(1);
//        body = new Accelerometer(2);
    }

    protected void disabled()
    {
        body.disable();
    }

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
//            shuttle.setSpeed( driver.getY() );
//            body.setSpeed( driver.getRot() );
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test()
    {

//        while ( isEnabled() )
//        {
////            System.out.println("Value: " + accIn.getAcceleration());
////            System.out.println("Value: " + body.getGyroAngle());
////            System.out.println("y: " + driver.getY() + "  rot: " + driver.getRot());
//            long y = (long)(driver.getY() * 1000.0);
//            long rot = (long)(driver.getRot() * 1000.0);
//            System.out.println("y: " + y + "  rot: " + rot);
////            driver.getRawAxis();
//        }


        while ( isEnabled() )
        {
            System.out.println("Half Back");
            TestSequence3 test3 = new TestSequence3();
            test3.doSequence();

            for (int i=0; i<10; i++)
            {
//                System.out.println("Angle: " + this.body.getDiff());
                Timer.delay( 1.0 );
            }

            System.out.println("Center");
            TestSequence test = new TestSequence();
            test.doSequence();

            for (int i=0; i<10; i++)
            {
//                System.out.println("Angle: " + this.body.getDiff());
                Timer.delay( 1.0 );
            }

            System.out.println("Half Forward");
            TestSequence2 test2 = new TestSequence2();
            test2.doSequence();

            for (int i=0; i<10; i++)
            {
//                System.out.println("Angle: " + this.body.getDiff());
                Timer.delay( 1.0 );
            }
        }

//        while (isEnabled())
//        {
//            System.out.println("body: " + body.getAcceleration() +
//                    "  arm: " + arm.getAcceleration() +
//                    "  diff: " + (body.getAcceleration() - arm.getAcceleration()));
//            Timer.delay( 0.25 );
//        }

//        ResetSequence reset = new ResetSequence();
//        reset.doSequence();
    }
}
