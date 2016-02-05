
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;
import org.usfirst.frc.team4624.robot.library.Tools;

/**
 *
 */
public class CamCommand extends Command {
	
	double p = .4;
	double t = .4;
	private final double sensitivity = 100.0;
	boolean rtPressed = false;
	
    public CamCommand(boolean rt) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.camPanTilt);
        rtPressed = rt;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//this.setTimeout(.01);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	if (rtPressed) {
    		p = 0.4;
    		t = 0.4;
    	}else {
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	p = .4;
    	t = .4;
    }
}
