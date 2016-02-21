
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

public class SwitchArmHeight extends Command {
	
	/**
	 * switches the arm height
	 */
    public SwitchArmHeight() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.grabberArm);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.shooter.getAngle() >= 38){
    	Robot.grabberArm.switchArmHeight();
    	}
    	else if (Robot.shooter.getAngle() < 38 && Robot.grabberArm.shortSolGet() && !(Robot.grabberArm.longSolGet())) {
    		Robot.grabberArm.switchArmHeight();
    	}
<<<<<<< HEAD
    	else if (Robot.shooter.getAngle() < 38 && Robot.grabberArm.shortSolGet() && Robot.grabberArm.longSolGet()) {
=======
    	else if (Robot.shooter.getAngle() < 30 && Robot.grabberArm.shortSolGet() && Robot.grabberArm.longSolGet()){
>>>>>>> origin/vision-alpha
    		Robot.grabberArm.setArmHeight(1);
    	}
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
