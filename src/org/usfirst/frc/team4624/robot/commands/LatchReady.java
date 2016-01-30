
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class LatchReady extends Command {

    public LatchReady() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooterTilter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(1);
    	Robot.shooterTilter.latchReady();
    	System.out.println("Latch is ready");
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
