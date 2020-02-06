package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.controller.PIDController;
// import edu.wpi.first.wpilibj.Encoder;

public class ShootSubsystem{



    public static Talon flyWheel1 = new Talon(Constants.FLYWHEEL_MOTOR1);
    public static Talon flyWheel2 = new Talon(Constants.FLYWHEEL_MOTOR2);

    public static Talon beltMotor1 = new Talon(Constants.BELT_MOTOR1);
    public static Talon beltMotor2 = new Talon(Constants.BELT_MOTOR2);

    public static Timer timer = new Timer();

    // private static Boolean lastShootbutton = false;
    // private static double lastPressTime = 0;

    public static void update(){
        if(Controller.shootButton.get() == true) {
            ShootSubsystem.flyWheel1.setSpeed(1);
            ShootSubsystem.flyWheel2.setSpeed(-1);

            SmartDashboard.putBoolean("flyon", true);
            
        }
        else{
            ShootSubsystem.flyWheel1.setSpeed(0);
            ShootSubsystem.flyWheel2.setSpeed(0);
            SmartDashboard.putBoolean("flyon", false);
        }
    } 

}
