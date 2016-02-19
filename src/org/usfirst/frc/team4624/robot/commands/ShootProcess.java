package org.usfirst.frc.team4624.robot.commands;



import edu.wpi.first.wpilibj.command.CommandGroup;



public class ShootProcess extends CommandGroup {
    
    
    
    /**
     * process the robot goes through to shoot and then reload
     */
    public ShootProcess() {
    	addSequential(new Shoot()); //Shoots
    	addSequential(new Recharge());
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