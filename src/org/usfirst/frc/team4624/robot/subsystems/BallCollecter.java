
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.library.Tools;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollecter extends Subsystem {
    
	private Relay flywheel = new Relay(RobotMap.flywheel);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/*
	public BallCollecter() {
		
		this.rotate = new Jaguar(RobotMap.ballCollectJag);
	}
	*/

    public void initDefaultCommand() {
    	
    }
    
    /**
     * turns on ball fly on the robot and sets relay value to forward
     */
    public void turnOn() {
    	flywheel.set(Relay.Value.kOn);
    	flywheel.set(Relay.Value.kForward);
    }
    
    /**
     *  turns off ball fly wheels on robot
     */
    public void turnOff() {
    	flywheel.set(Relay.Value.kOff);
    }
}

