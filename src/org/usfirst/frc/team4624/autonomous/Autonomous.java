package org.usfirst.frc.team4624.autonomous;



import edu.wpi.first.wpilibj.command.CommandGroup;



public class Autonomous extends CommandGroup {
    
    
    
    /**
     * Example auto period sequence
     */
    public Autonomous() {
    	addSequential(new ZeroTilter());
    	addSequential(new )
    	//addSequential(new VisionTesting());
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
}