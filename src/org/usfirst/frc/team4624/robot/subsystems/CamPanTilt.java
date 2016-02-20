
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
        setDefaultCommand(new CamCommand());
    }
    
    /**
     * sets the private pan and tilt values to the values inputed
     * @param p pan servo position
     * @param t tilt servo position
     */
    public void setPosition(double p, double t) {
    	pan.set(p);
    	tilt.set(t);
    }
    
    /**
     * gets the servo pan position value
     * @return the pan position value
     */
    public double getPan() {
    	return pan.getPosition();
    }
    
    /**
     * gets the servo tilt position value
     * @return the tilt position value
     */
    public double getTilt() {
    	return tilt.getPosition();
    }
    
    /**
     * Puts pan and tilt position to the SmartDashboard
     */
    public void displayPanTilt() {
    	SmartDashboard.putNumber("Camera Pan", pan.getPosition());
    	SmartDashboard.putNumber("Camera Tilt", tilt.getPosition());
    }
}

