/* Created Sun Jan 10 10:25:50 PST 2016 */
package com.team2521.robot;

import org.strongback.Strongback;
import org.strongback.components.Motor;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.FlightStick;
import org.strongback.components.ui.InputDevice;
import org.strongback.hardware.Hardware;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CANTalon;
public class Robot extends IterativeRobot 
{
	private static final int JOYSTICK_PORT = 0;
	private static final int TALON_PORT = 52;
	
	
	private ContinuousRange speed;
	private CANTalon wheelSRX;
	private InputDevice joystick;
	private Motor wheel;
    @Override
    public void robotInit() 
    {
    	wheelSRX = new CANTalon(TALON_PORT);
    	wheel = Hardware.Motors.talonSRX(wheelSRX,0);
    	joystick = Hardware.HumanInterfaceDevices.driverStationJoystick(JOYSTICK_PORT);
    	speed = joystick.getAxis(1);
    } 

    @Override
    public void teleopInit() 
    {
        // Start Strongback functions ...
        Strongback.start();
    }

    @Override
    public void teleopPeriodic() 
    {
    	wheel.setSpeed(speed.read());
    }

    @Override
    public void disabledInit() 
    {
        // Tell Strongback that the robot is disabled so it can flush and kill commands.
        Strongback.disable();
    }

}
