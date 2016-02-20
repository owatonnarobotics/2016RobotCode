
package org.usfirst.frc.team4624.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class AutoAdjustShooter extends Command {
	double targetAngle;
	int direction; //-1 is up and 1 is down!!!
	
	/**
	 * Makes the shooter rise to the specified angle/height
	 * @param ang reading the potentiometer will read 
	 */
    public AutoAdjustShooter(double ang) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
        this.targetAngle = ang;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setRaw(0);
    	if (Robot.shooter.getAngle() > targetAngle) {
    		direction = -1;
    	}
    	else if (Robot.shooter.getAngle() < targetAngle) {
    		direction = 1;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (direction == -1) {
    		Robot.shooter.setRaw(-.2);
    	}
    	else if (direction == 1) {
    		Robot.shooter.setRaw(.2);
    	}
    	else {
    		Robot.shooter.setRaw(0);
    	}
    	Robot.shooter.displayInformation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((direction == 1 && Robot.shooter.getAngle() > targetAngle) || (direction == -1 && Robot.shooter.getAngle() < targetAngle));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setRaw(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.setRaw(0);
    }
}
