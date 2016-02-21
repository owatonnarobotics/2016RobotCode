package org.usfirst.frc.team4624.autonomous;



import org.usfirst.frc.team4624.robot.commands.Recharge;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutonomousInit extends CommandGroup {
	
    public AutonomousInit() {
    	addSequential(new AutoResetArmHeight());
    	pause(3);
    	addSequential(new AutoAdjustShooter(10));
    	addSequential(new Recharge());
    	
    	//addSequential(new VisionTesting());
    }
    
    private void pause(double time) {
        
        addSequential(new AutoPause(time));
    }
}