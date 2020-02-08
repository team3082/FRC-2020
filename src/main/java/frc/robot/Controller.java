package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controller {
    
    //Controller object and Button objects
    public static Joystick driveCntrl = new Joystick(0);

    public static final JoystickButton shootButton = new JoystickButton(driveCntrl, 1);
   
    public static final JoystickButton slowButton = new JoystickButton(driveCntrl, 2);
   
    public static final JoystickButton intakeButton = new JoystickButton(driveCntrl, 3);

}