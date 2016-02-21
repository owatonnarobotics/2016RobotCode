
package org.usfirst.frc.team4624.autonomous;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoResetArmHeight extends Command {

    public AutoResetArmHeight() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.grabberArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabberArm.resetArmHeight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}