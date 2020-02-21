package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class Controller {
    
    //Controller object and Button objects
    public static Joystick driveControl = new Joystick(0);
    public static Joystick manipControl = new Joystick(1);

    public static final JoystickButton shootButton = new JoystickButton(manipControl, 1);
    public static final JoystickButton slowButton = new JoystickButton(driveControl, 2);
   
    public static final JoystickButton beltButton = new JoystickButton(manipControl, 4);

    public static final JoystickButton intakeButton = new JoystickButton(manipControl, 2);
    // public static final JoystickButton intakeToggle = new JoystickButton(driveControl, 4);

    public static final POVButton climbPistonsForward = new POVButton(driveControl, 0);
    public static final POVButton climbPistonsBack = new POVButton(driveControl, 180);
    public static final POVButton winch = new POVButton(driveControl, 90);


}