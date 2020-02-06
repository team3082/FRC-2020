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

    private static Boolean lastShootbutton = false;
    private static double lastPressTime = 0;


    static {
        timer.start();
    }
    public static void update(){
        if(lastShootbutton == false && Controller.shootButton.get() == true){
            lastPressTime = timer.get();
        }

        lastShootbutton = Controller.shootButton.get();

        if(Controller.shootButton.get() && timer.get() != 0 && timer.get() - lastPressTime < 1){
            flyWheel1.setSpeed(1);
            flyWheel2.setSpeed(-1);
            beltMotor1.setSpeed(0);
            beltMotor2.setSpeed(0);
            SmartDashboard.putBoolean("Spinning Up", true);
        }
        else if(Controller.shootButton.get() && lastPressTime != 0 && timer.get() - lastPressTime > 1){
            flyWheel1.setSpeed(1);
            flyWheel2.setSpeed(-1);

            beltMotor1.setSpeed(0.5);
            beltMotor2.setSpeed(-0.5);
            SmartDashboard.putBoolean("Spinning Up", false);
        }
        else{
            flyWheel1.setSpeed(0);
            flyWheel2.setSpeed(0);

            beltMotor1.setSpeed(0);
            beltMotor2.setSpeed(0);
            SmartDashboard.putBoolean("Spinning Up", false);
        }

        lastShootbutton = Controller.shootButton.get();
    } 

}
