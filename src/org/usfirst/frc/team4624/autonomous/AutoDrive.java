
package org.usfirst.frc.team4624.autonomous;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	double xSpeed;
	double ySpeed;
	double time;
	double distance;
	
	/**
	 * makes the robot drive in autonomous with the specified values given
	 * @param x x speed
	 * @param y y speed
	 * @param t duration for command to run (seconds)
	 * @param d distance to reach (when driving forwards only) if time entered is 0
	 */
    public AutoDrive(double x, double y, double t, double d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.xSpeed = x;
        this.ySpeed = y;
        this.time = t;
        this.distance = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (!(time == 0)) {
        	this.setTimeout(time);
        }
    	Robot.driveTrain.setDrive(xSpeed, ySpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (!(time == 0)) {
        	return this.isTimedOut();
        }
        else {
        	return (Robot.distanceReader.getDistance() <= distance);
        }
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
