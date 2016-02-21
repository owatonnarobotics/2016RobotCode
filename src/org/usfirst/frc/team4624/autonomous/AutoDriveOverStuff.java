package org.usfirst.frc.team4624.autonomous;



import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutoDriveOverStuff extends CommandGroup {
    
    
    
    /**
     * Example auto period sequence
     */
    public AutoDriveOverStuff() {
    	addSequential(new AutonomousInit());
    	addSequential(new AutoAdjustShooter(15));
    	addSequential(new AutoDrive(-.5, 0, 7, 0));
    
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