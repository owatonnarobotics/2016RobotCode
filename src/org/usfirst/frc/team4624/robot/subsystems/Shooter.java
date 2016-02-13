
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {
	
	private Jaguar			    lift			= new Jaguar(RobotMap.tilterJag);
	private Encoder		    	encoder			= new Encoder(RobotMap.encoderB, RobotMap.encoderA);
	private DigitalInput	    encoderSwitch1	= new DigitalInput(RobotMap.encoderResetSwitch);
	private DigitalInput	    encoderSwitch2	= new DigitalInput(RobotMap.encoderLimitSwitch);
	private Solenoid            escSolenoid     = new Solenoid(RobotMap.escapementSolenoid);
	private Solenoid            cylSolenoid     = new Solenoid(RobotMap.cylinderSolenoid);
	private AnalogPotentiometer potSensor       = new AnalogPotentiometer(RobotMap.potentiometer);
	
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
		SmartDashboard.putNumber("Shooter Angle", potSensor.get());
	}
	
	public double getRotations() {
		return encoder.getDistance();
	}
	
	public void latchReady() {
		cylSolenoid.set(true);
		escSolenoid.set(false);
	}
	
	public void reload() {
		cylSolenoid.set(false);
		escSolenoid.set(true);
	}
	
	public void shoot() {
		cylSolenoid.set(true);
		escSolenoid.set(true);
	}
	
}
