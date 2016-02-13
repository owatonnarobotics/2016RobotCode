
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.library.Tools;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallCollecter extends Subsystem {
    
	private Relay spike = new Relay(RobotMap.spike);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/*
	public BallCollecter() {
		
		this.rotate = new Jaguar(RobotMap.ballCollectJag);
	}
	*/

    public void initDefaultCommand() {
    	
    }
    
    public void turnOn() {
    	spike.set(Relay.Value.kOn);
	    spike.set(Relay.Value.kForward);
    }

    public void turnOff() {
    	spike.set(Relay.Value.kOff);
    }
}

