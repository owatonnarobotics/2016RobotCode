
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;

public class CollectBall extends Command {

    public CollectBall() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.ballCollecter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("CollectBall was initialized");
    	this.setTimeout(.1);
    	Robot.ballCollecter.setRaw(0);
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if (Robot.oi.xboxController.b.get()) {
//    		Robot.ballCollecter.setRaw(1);
//    	}
    	Robot.ballCollecter.setRaw(-1);
    	System.out.println("BallCollector Executed");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballCollecter.setRaw(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ballCollecter.setRaw(0);
    }
}
