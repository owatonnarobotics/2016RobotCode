/*
package org.usfirst.frc.team4624.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4624.robot.RobotMap;

import org.usfirst.frc.team4624.robot.Robot;

*//**
 *
 *//*
public class VisionTesting extends Command {

    public VisionTesting() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.hotGoal = false;
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
    	 boolean cameraWorking = Robot.camera.getPic();
         if(cameraWorking){
        	 Robot.camera.processPic();
         }
         if(RobotMap.hotGoal){
             System.out.println("HOT GOAL!!!!!!!");
             System.out.println("Distance: " + Robot.camera.getDistance());
         }
         else{
             System.out.println("NOT HOT GOAL");
         }
         SmartDashboard.putBoolean("IsHot", RobotMap.hotGoal);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
*/