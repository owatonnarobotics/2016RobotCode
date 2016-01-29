
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterTilter extends Subsystem {
	
	private Jaguar			lift			= new Jaguar(RobotMap.tilterJag);
	private Encoder			encoder			= new Encoder(RobotMap.encoderB, RobotMap.encoderA);
	private DigitalInput	encoderSwitch	= new DigitalInput(RobotMap.encoderResetSwitch);
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	/*
	 * public ShooterTilter() { this.lift = new Jaguar(RobotMap.tilterJag); this.encoder = new Encoder(RobotMap.encoderB,
	 * RobotMap.encoderB); this.encoderSwitch = new DigitalInput(RobotMap.encoderResetSwitch); }
	 */
	
	public void initDefaultCommand() {
		//setDefaultCommand(new AdjustShooter());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setRaw(double raw) {
		lift.set(raw);
	}
	
	public boolean getEncoderSwitch() {
		return encoderSwitch.get();
	}
	
	public void resetEncoder() {
		encoder.reset();
	}
	
	public void displayInformation() {
		SmartDashboard.putNumber("Encoder Position", encoder.getDistance());
	}
	public double getRotations() {
		return encoder.getDistance();
	}
	
}
