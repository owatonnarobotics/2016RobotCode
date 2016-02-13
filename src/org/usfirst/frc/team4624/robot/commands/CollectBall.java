
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;

public class CollectBall extends Command {
	
	/**
	 * turns on the ballcollecter
	 */
    public CollectBall() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.ballCollecter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(1);
    	Robot.ballCollecter.turnOff();
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if (Robot.oi.xboxController.b.get()) {
//    		Robot.ballCollecter.setRaw(1);
//    	}
    	Robot.ballCollecter.turnOn();
    	System.out.println("BallCollector Executed");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballCollecter.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ballCollecter.turnOff();
    }
}
