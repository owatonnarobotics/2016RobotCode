package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.AdjustShooter;
import org.usfirst.frc.team4624.robot.library.Tools;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterTilter extends Subsystem {
	
	private Jaguar			lift			= new Jaguar(RobotMap.tilterJag);
	private Encoder			encoder			= new Encoder(RobotMap.encoderB, RobotMap.encoderB);
	private DigitalInput	encoderSwitch	= new DigitalInput(RobotMap.encoderResetSwitch);
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	/*
	 * public ShooterTilter() { this.lift = new Jaguar(RobotMap.tilterJag); this.encoder = new Encoder(RobotMap.encoderB,
	 * RobotMap.encoderB); this.encoderSwitch = new DigitalInput(RobotMap.encoderResetSwitch); }
	 */
	
	public void initDefaultCommand() {
		
		setDefaultCommand(new AdjustShooter());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	private void displayInformation() {
		
		SmartDashboard.putNumber("Encoder Position", correctDistance() / 250);
	}
	
	private double correctDistance() {
		// TODO Auto-generated method stub
		return encoder.getDistance();
	}
	
	public void setRaw(double raw) {
		
		lift.set(Tools.clamp(raw, -1, 1));
	}
	
	public void resetEncoder() {
		
		if (!encoderSwitch.get()) {
			encoder.reset();
		}
	}
	
	public void update() {
		
		displayInformation();
		
	}
}
