
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

public class AdjustShooter extends Command {

	double speed = 0;

	public AdjustShooter(double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooterTilter);
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		double mySpeed = speed;

		this.setTimeout(.1);
		System.out.println(Robot.shooterTilter.getEncoderSwitch());
		if (Robot.shooterTilter.getEncoderSwitch()) {
			speed = -1;
			System.out.println("Encoder switch was triggered");
			Robot.shooterTilter.setRaw(speed);
			speed = mySpeed;
		} else {
			Robot.shooterTilter.setRaw(speed);
			System.out.println(speed);
		}

		// Robot.shooterTilter.displayInformation();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*
		 * Robot.shooterTilter.setRaw(OI.xboxController.rt.getX() -
		 * OI.xboxController.lt.getX()); if (!Robot.shooterTilter.getEncoder())
		 * { Robot.shooterTilter.resetEncoder(); }
		 */

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooterTilter.setRaw(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooterTilter.setRaw(0);
	}
}
