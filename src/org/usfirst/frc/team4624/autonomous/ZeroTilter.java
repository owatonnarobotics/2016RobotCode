package org.usfirst.frc.team4624.autonomous;



import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;



public class ZeroTilter extends Command {
    
    
    
    /**
     * Example auto period sequence
     */
    public ZeroTilter() {
    	requires(Robot.shooter);
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

	@Override
	protected void initialize() {
		Robot.shooter.setRaw(1);
	}

	@Override
	protected void execute() {
		Robot.shooter.displayInformation();
	}

	@Override
	protected boolean isFinished() {
		return Robot.shooter.getEncoderSwitch(1);
	}

	@Override
	protected void end() {
		Robot.shooter.setRaw(0);
		Robot.shooter.resetEncoder();
		Robot.shooter.displayInformation();
		
	}

	@Override
	protected void interrupted() {
		Robot.shooter.setRaw(0);
		Robot.shooter.resetEncoder();
		Robot.shooter.displayInformation();
	}
}