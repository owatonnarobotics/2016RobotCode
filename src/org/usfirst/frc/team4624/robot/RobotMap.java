package org.usfirst.frc.team4624.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static final int leftMotor          = 0;
    public static final int rightMotor         = 1;
    public static final int tilterJag          = 2;
    public static final int ballCollectJag     = 3;
    
    public static final int encoderA           = 0;
    public static final int encoderB           = 1;
    public static final int encoderResetSwitch = 2;
    public static final int encoderLimitSwitch = 3;
    
    public static final int escapementSolenoid = 0;
    public static final int cylinderSolenoid   = 1;
    
    //public static final int compressorPin      = 1;
    
    
    
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
