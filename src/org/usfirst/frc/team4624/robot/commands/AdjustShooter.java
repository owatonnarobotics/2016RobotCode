
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.OI;
import org.usfirst.frc.team4624.robot.Robot;

public class AdjustShooter extends Command {

	double speed = 0;
	int button = 0;

	public AdjustShooter(double speed, int button) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooterTilter);
		this.speed = speed;
		this.button = button;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setTimeout(300);
		/*
		double mySpeed = speed;

		this.setTimeout(.1);
		System.out.println(Robot.shooterTilter.getEncoderSwitch());
		if (Robot.shooterTilter.getEncoderSwitch()) {
			speed = -1;
			System.out.println("Shooter encoder switch was triggered");
			Robot.shooterTilter.resetEncoder();
			OI.xboxController.setRumble(.5);
			Robot.shooterTilter.setRaw(speed);
			speed = mySpeed;
		} else {
			Robot.shooterTilter.setRaw(speed);
			System.out.println(speed);
		}
		Robot.shooterTilter.displayInformation();
		*/
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double mySpeed = speed;

		//System.out.println(Robot.shooterTilter.getEncoderSwitch());
		
		if (Robot.shooterTilter.getEncoderSwitch() && button == 1) {
			speed = 0;
			
			System.out.println("Shooter encoder is 0");
			
			Robot.shooterTilter.setRaw(speed);
			Robot.shooterTilter.resetEncoder();
			OI.xboxController.setRumble(.5);
			speed = mySpeed;
		}
		else if (Robot.shooterTilter.getRotations() >= 4600 && button == 0) {
			speed = 0;
			
			System.out.println("Shooter encoder is about 4600");
			
			Robot.shooterTilter.setRaw(speed);
			OI.xboxController.setRumble(.5);
			speed = mySpeed;
		}
		else {
			Robot.shooterTilter.setRaw(speed);
			//System.out.println(speed);
		}
		Robot.shooterTilter.displayInformation();

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooterTilter.setRaw(0);
		OI.xboxController.setRumble(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooterTilter.setRaw(0);
		OI.xboxController.setRumble(0);
	}
}
