
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberArm extends Subsystem {
    
	private Solenoid        longSolenoid     = new Solenoid(RobotMap.grabberSolenoidLong);
	private Solenoid        shortSolenoid    = new Solenoid(RobotMap.grabberSolenoidShort);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * switches between the 3 heights possible for the arm, down, half-mast, and full-mast
     */
    public void switchArmHeight() {
    	if (!shortSolenoid.get() && !longSolenoid.get()) {
    		shortSolenoid.set(true);
    	} else if (shortSolenoid.get() && !longSolenoid.get()) {
    		longSolenoid.set(true);
    	} else if (shortSolenoid.get() && longSolenoid.get()) {
    		shortSolenoid.set(false);
    		longSolenoid.set(false);
    	}
    }
    
    /**
     * resets the arm height
     * this is needed, because otherwise the robot stays
     * in the position it left off in
     */
    public void resetArmHeight() {
    	shortSolenoid.set(false);
    	longSolenoid.set(false);
    }
}

