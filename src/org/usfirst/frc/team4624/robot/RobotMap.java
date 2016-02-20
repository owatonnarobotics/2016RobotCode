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
	
    //PWM
	public static final int leftMotor           = 0; //DriveTrain:    PWM: Motor Controller for the left side (drive) of the Robot
    public static final int rightMotor          = 1; //DriveTrain:    PWM: Motor Controller for the right side (drive) of the Robot
    public static final int tilterJag           = 2; //ShooterTilter: PWM: Motor Controller for tilting the shooter
    //public static final int ballCollectJag      = 3; //BallCollecter: PWM: Motor Controller for the motor that controls the ball collecter
    public static final int panCamServo         = 4; //CamPanTilt:    PWM: Servo that pans the camera on the robot
    public static final int tiltCamServo        = 5; //CamPanTilt:    PWM: Servo that tilts the camera on the robot
    
    //DIO
    public static final int lowerShooterSwitch  = 0;
    public static final int upperShooterSwitch  = 1;
    public static final int ECHO_CHANNEL        = 2; // {UltraRange Finder} The echo channel for the ultrasonic rangefinder
    public static final int PING_CHANNEL        = 3; // [Not Used]
    
    //PCM
    public static final int escapementSolenoid   = 0;
    public static final int cylinderSolenoid     = 1;
    public static final int grabberSolenoidShort = 2;
    public static final int grabberSolenoidLong  = 3;
    
    //RELAY
    public static final int flywheel             = 0;
    
    //ANALOG
    public static final int potentiometer        = 0;
    
    //world variable (2014)
    public static boolean hotGoal = false;
    
    //public static final int compressorPin        = 0;
    
    
    
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
