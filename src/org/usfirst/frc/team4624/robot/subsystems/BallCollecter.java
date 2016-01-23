
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.Robot;
import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.CollectBall;
import org.usfirst.frc.team4624.robot.library.Tools;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallCollecter extends Subsystem {
    
	private Jaguar rotate;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public BallCollecter() {
		
		this.rotate = new Jaguar(RobotMap.ballCollectJag);
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new CollectBall());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
public void setRaw(double raw) {
	    
        rotate.set(Tools.clamp(raw, -1, 1));
    }
}

