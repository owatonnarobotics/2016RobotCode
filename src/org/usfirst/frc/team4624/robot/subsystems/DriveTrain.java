
package org.usfirst.frc.team4624.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private RobotDrive driveTrain = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());

	}
	
	/**
	 * sets the driving speed for the drivetrain motor controllers
	 * @param x forwards/backwards speed value
	 * @param y rotation speed value
	 */
	public void setDrive(double x, double y) {
		driveTrain.arcadeDrive(-x, -y, true);
	}
	
	public void stop() {
		driveTrain.stopMotor();
	}
}
