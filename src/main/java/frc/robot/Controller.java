package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controller {
    
    //Controller object and Button objects
    public static Joystick driveControl = new Joystick(0);
    public static Joystick manipControl = new Joystick(1);

    public static final JoystickButton shootButton = new JoystickButton(manipControl, 6);
    public static final JoystickButton slowButton = new JoystickButton(driveControl, 2);
   
    public static final JoystickButton beltButton = new JoystickButton(manipControl, 4);


    public static final JoystickButton intakeButtonFwd = new JoystickButton(manipControl, 5);
    public static final JoystickButton intakeButtonBack = new JoystickButton(manipControl, 3);
    // public static final JoystickButton intakeToggle = new JoystickButton(driveControl, 4);

    public static final JoystickButton climbPistonsForward = new JoystickButton(driveControl, 3);
    public static final JoystickButton climbPistonsBack = new JoystickButton(driveControl, 4);
    public static final JoystickButton winch = new JoystickButton(driveControl, 1);


}