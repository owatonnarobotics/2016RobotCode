
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.CamCommand;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CamPanTilt extends Subsystem {
    private Servo pan = new Servo(RobotMap.panCamServo);
    private Servo tilt = new Servo(RobotMap.tiltCamServo);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CamCommand(false));
    }
    
    public void setPosition(double p, double t) {
    	pan.set(p);
    	tilt.set(t);
    }
    
    public double getPan() {
    	return pan.getRaw();
    }
    
    public double getTilt() {
    	return tilt.getRaw();
    }
    
    public void displayPanTilt() {
    	SmartDashboard.putNumber("Camera Pan", pan.getPosition());
    	SmartDashboard.putNumber("Camera Tilt", tilt.getPosition());
    }
}

