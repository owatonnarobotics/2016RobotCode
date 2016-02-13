
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;

public class AdjustShooter extends Command {

	double speed = 0;
	int button = 0;
	
	/**
	 * Command to adjust the shooter angle
	 * @param speed the speed the shooter should move at from -1 to 1
	 * @param button the button being used to control the angle (leftbutton = 0 and rightbutton = 1
	 */
	public AdjustShooter(double speed, int button) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
		this.speed = speed;
		this.button = button;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setTimeout(300);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double mySpeed = speed;
		
		if (Robot.shooter.getAngle() >= .75 && button == 1) {
			speed = 0;
			
			System.out.println("Shooter can't go lower!");
			
			Robot.shooter.setRaw(speed);
			OI.xboxController.setRumble(.5);
			speed = mySpeed;
		}
		else if (Robot.shooter.getAngle() <= .4 && button == 0) {
			speed = 0;
			
			System.out.println("Shooter can't go higher");
			
			Robot.shooter.setRaw(speed);
			OI.xboxController.setRumble(.5);
			speed = mySpeed;
		}
		else {
			Robot.shooter.setRaw(speed);
		}
		
		Robot.shooter.displayInformation();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.setRaw(0);
		OI.xboxController.setRumble(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.setRaw(0);
		OI.xboxController.setRumble(0);
	}
}
