package org.usfirst.frc.team4624.autonomous;




import org.usfirst.frc.team4624.robot.commands.SwitchArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutoOpenGate extends CommandGroup {
    
    
    
    /**
     * Example auto period sequence
     */
    public AutoOpenGate() {
    	addSequential(new AutoDriveForward(1));
    	addSequential(new AutoAdjustShooter(38));
    	addSequential(new SwitchArmHeight());
    	pause(2.5);
    	addSequential(new AutoAdjustShooter(24));
    	addSequential(new AutoDriveForward(1));
    	addSequential(new SwitchArmHeight());
    	
        /*
        addSequential( new DriveToTote() );
        addSequential( new GrabTote() );
        addSequential( new LiftTote() );
        addSequential( new MoveToZone() );
        addSequential( new TurnToCenter() );
        addSequential( new IdentifyStack() );
        addSequential( new DriveToTote2() );
        addSequential( new StackTote() );
        addSequential( new AlignYourself() );
        */
    }
    
    private void pause(double time) {
        
        addSequential(new AutoPause(time));
    }
}