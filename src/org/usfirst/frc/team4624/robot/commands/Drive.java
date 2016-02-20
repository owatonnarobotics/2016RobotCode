
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;
import org.usfirst.frc.team4624.robot.library.Tools;

public class Drive extends Command {
	
	/**
	 * drives the robot...
	 */
    public Drive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setDrive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!(OI.xboxController.lsButton.get())) {
    		Robot.driveTrain.setDrive(Tools.clamp(Robot.oi.xboxController.getRawAxis(1), -.93, .93), Tools.clamp(Robot.oi.xboxController.getRawAxis(0), -.93, .93));
    	}
    	else {
    		Robot.driveTrain.setDrive(Robot.oi.xboxController.getRawAxis(1), Robot.oi.xboxController.getRawAxis(0));
    	}
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
    }
}