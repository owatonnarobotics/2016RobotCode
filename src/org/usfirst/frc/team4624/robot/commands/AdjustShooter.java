/*
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;


public class AdjustShooter extends Command {

    public AdjustShooter() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooterTilter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterTilter.setRaw(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.shooterTilter.setRaw(OI.xboxController.rt.getX() - OI.xboxController.lt.getX());
    	if (!Robot.encoderReset.get()) {
    		Robot.shooterTilter.resetEncoder();
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
*/