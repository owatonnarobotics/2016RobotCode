
package org.usfirst.frc.team4624.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

public class AutoDriveReverse extends Command {
	double time;
	/**
	 * makes the robot drive backwards...
	 */
    public AutoDriveReverse(double t) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(time);
    	Robot.driveTrain.setDrive(0.75, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.setDrive(0, 0);
    }
}
