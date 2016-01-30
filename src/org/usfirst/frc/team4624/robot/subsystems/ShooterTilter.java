
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterTilter extends Subsystem {
	
	private Jaguar			lift			= new Jaguar(RobotMap.tilterJag);
	private Encoder			encoder			= new Encoder(RobotMap.encoderB, RobotMap.encoderA);
	private DigitalInput	encoderSwitch1	= new DigitalInput(RobotMap.encoderResetSwitch);
	private DigitalInput	encoderSwitch2	= new DigitalInput(RobotMap.encoderLimitSwitch);
	//private Solenoid        solenoid1       = new Solenoid(RobotMap.solenoid1);
	//private Solenoid        solenoid2       = new Solenoid(RobotMap.solenoid2);
	
	
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
	
	public boolean getEncoderSwitch(int eSwitch) {
		if (eSwitch == 1) {
			return encoderSwitch1.get();
		}
		else {
			return encoderSwitch2.get();
		}
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
	
	public void charge() {
		//TODO: put in stuff
	}
	
	public void shoot() {
		//TODO: put in stuff
	}
	
}
