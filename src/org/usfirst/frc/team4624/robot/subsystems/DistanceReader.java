
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.DistanceGetter;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Developer
 */
public class DistanceReader extends Subsystem{
    private Ultrasonic sensor;// = new Ultrasonic(RobotMap.ECHO_CHANNEL, RobotMap.PING_CHANNEL);
    
    private int trueAutoCount = 0; // The number of times the range was correct
    //Shot Range
    public static final double minRange = 6 * 12;
    public static final double maxRange = 10 * 12;
    
        //Autonomous Shot Range
    public static final double minAutoRange = 3 * 12;
    public static final double maxAutoRange = 8 * 12;
   
    /**
     * this is the constructor 
     */
    public DistanceReader(){
        sensor = new Ultrasonic(RobotMap.PING_CHANNEL, RobotMap.ECHO_CHANNEL);
        sensor.setEnabled(true);
        sensor.setAutomaticMode(true);
    }
   
    protected void initDefaultCommand() {
    	setDefaultCommand(new DistanceGetter());
    }
    
    /**
     * gets the distance between the ultrasonic sensor and what is in front of it
     * @return the distance recorded by the ultrasonic sensor
     */
    public double getDistance(){
        double distance = sensor.getRangeInches();
        return distance;
    }
    
    /**
     * displays distance on SmartDashboard
     */
    public void displayDistance() {
    	double distance = this.getDistance();
    	SmartDashboard.putNumber("UltraS. Dist.", distance);
    }
}

