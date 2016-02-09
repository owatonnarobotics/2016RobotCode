
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class VisionProcessing extends Command {

    public VisionProcessing() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.camera.cameraUpdate();
    	//SmartDashboard.putNumber("centerX", Robot.camera.getX());
    	//SmartDashboard.putNumber("centerY", Robot.camera.getY());
    	//SmartDashboard.putNumber("width", Robot.camera.getWidth());
    	//SmartDashboard.putNumber("height", Robot.camera.getHeight());
    	//SmartDashboard.putNumber("area", Robot.camera.getArea());
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
