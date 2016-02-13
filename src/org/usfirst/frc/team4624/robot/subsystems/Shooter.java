
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
	private Solenoid            escSolenoid     = new Solenoid(RobotMap.escapementSolenoid);
	private Solenoid            cylSolenoid     = new Solenoid(RobotMap.cylinderSolenoid);
	private AnalogPotentiometer potSensor       = new AnalogPotentiometer(RobotMap.potentiometer);
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void initDefaultCommand() {
		
	}
	
	/**
	 * sets the speed of the shooter tilting(between -1 and 1)
	 * @param raw speed of the shooter tilter between -1 and 1
	 */
	public void setRaw(double raw) {
		lift.set(raw);
	}
	
	/**
	 * displays the shooter angle to the SmartDashboard
	 */
	public void displayInformation() {
		SmartDashboard.putNumber("Shooter Angle", potSensor.get());
	}
	
	/**
	 * gets the angle of the shooter mechanism
	 * @return returns the angle of the shooter mechanism
	 */
	public double getAngle() {
		return potSensor.get();
	}
	
	/**
	 * sets the shooter solenoids in the ready position for shooting
	 */
	public void latchReady() {
		cylSolenoid.set(true);
		escSolenoid.set(false);
	}
	
	/**
	 * sets the shooter solenoids in the position to charge the shooter
	 */
	public void reload() {
		cylSolenoid.set(false);
		escSolenoid.set(true);
	}
	
	/**
	 * sets the shooter solenoids in the position to shoot the boulder
	 */
	public void shoot() {
		cylSolenoid.set(true);
		escSolenoid.set(true);
	}
	
}
