package org.usfirst.frc.team4624.robot;

import org.usfirst.frc.team4624.robot.commands.AdjustShooter;
import org.usfirst.frc.team4624.robot.commands.CollectBall;
import org.usfirst.frc.team4624.robot.commands.RoboPause;
import org.usfirst.frc.team4624.robot.commands.ShootProcess;
import org.usfirst.frc.team4624.robot.commands.SwitchArmHeight;
import org.usfirst.frc.team4624.robot.library.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
    public static XboxController xboxController = new XboxController();
    
    public OI() {
    	
    	xboxController.a.whenPressed(new ShootProcess());
    	xboxController.b.whileHeld(new CollectBall());
    	xboxController.x.whenPressed(new SwitchArmHeight());
    	
    	xboxController.rb.whileHeld(new AdjustShooter(-.2, 0)); //up
    	xboxController.lb.whileHeld(new AdjustShooter(.2, 1)); //down
    	
    	//xboxController.rsButton.whileHeld(new CamCommand(true));
    	//xboxController.rtButton.whenReleased(new CamCommand(false));
    	
    	xboxController.start.toggleWhenPressed(new RoboPause());
    	
    }
    
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
}

