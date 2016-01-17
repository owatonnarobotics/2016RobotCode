
package org.usfirst.frc.team4624.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4624.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private RobotDrive driveTrain = new RobotDrive(0, 1);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());

	}

	public void setDrive(double x, double y) {
		if (x < .1 && x > -.1){
			x = 0;
		}
		if (y < .1 && y > -.1){
			y = 0;
		}
		driveTrain.arcadeDrive(-x, -y, true);
	}
}
