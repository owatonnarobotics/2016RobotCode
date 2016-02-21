
package org.usfirst.frc.team4624.robot.commands;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;
import org.usfirst.frc.team4624.robot.library.Tools;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CamCommand extends Command {
	
	double p = .49;
	double t = .4;
	private final double sensitivity = 100.0;
	
	/**
	 * command to move the camera
	 * @param rs boolean to see if the rightstick is pressed
	 */
    public CamCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.camPanTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//this.setTimeout(.01);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (OI.xboxController.rsButton.get()) {
    		p = 0.49;
    		t = 0.4;
    	}
    	else {
    		p +=   OI.xboxController.rightStick.getX()  / sensitivity; //sets the pan value for the camera
        	t += (-OI.xboxController.rightStick.getY()) / sensitivity; //sets the tilt value for the camera
        	
        	p = Tools.clamp(p, 0.0, 1.0);
        	t = Tools.clamp(t, 0.0, 1.0);
    	}
    	
    	Robot.camPanTilt.displayPanTilt();
    	Robot.camPanTilt.setPosition(p,t);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	p = .49;
    	t = .4;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	p = .49;
    	t = .4;
    }
}
