package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.Joystick;

// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.controller.PIDController;
// import edu.wpi.first.wpilibj.Encoder;

public class ShootSubsystem{

    public static TalonSRX flyWheel1 = new TalonSRX(Constants.FLYWHEEL_MOTOR1);
    public static TalonSRX flyWheel2 = new TalonSRX(Constants.FLYWHEEL_MOTOR2);

    public static Talon beltMotor1 = new Talon(Constants.BELT_MOTOR1);
    public static Talon beltMotor2 = new Talon(Constants.BELT_MOTOR2);

    public static Timer timer = new Timer();

    private static Boolean lastShootbutton = false;
    private static double lastPressTime = 0;
    
    private static final double DELAY = 0.7;

    private static final double TARGET_VELOCITY = Constants.TARGET_FLYWHEEL_RPM * 4096 / 600;

    static {
        timer.start();
    }

    //Runs every time robotPeriodic is run
    public static void update(){
        if(lastShootbutton == false && Controller.shootButton.get() == true){
            lastPressTime = timer.get();
        }

        lastShootbutton = Controller.shootButton.get();

        if(Controller.shootButton.get() && timer.get() != 0 && timer.get() - lastPressTime < DELAY){
            flyWheel1.set(ControlMode.Velocity, TARGET_VELOCITY);
            flyWheel2.set(ControlMode.Velocity, -TARGET_VELOCITY);

            beltMotor1.setSpeed(0);
            beltMotor2.setSpeed(0);

            SmartDashboard.putBoolean("Spinning Up", true);
        }
        else if(Controller.shootButton.get() && lastPressTime != 0 && timer.get() - lastPressTime > DELAY){
            flyWheel1.set(ControlMode.Velocity, TARGET_VELOCITY);
            flyWheel2.set(ControlMode.Velocity, -TARGET_VELOCITY);

            beltMotor1.setSpeed(0.5);
            beltMotor2.setSpeed(-0.5);

            SmartDashboard.putBoolean("Spinning Up", false);
        }
        else{
            flyWheel1.set(ControlMode.Velocity, 0);
            flyWheel2.set(ControlMode.Velocity, 0);

            beltMotor1.setSpeed(0);
            beltMotor2.setSpeed(0);

            SmartDashboard.putBoolean("Spinning Up", false);
        }

        lastShootbutton = Controller.shootButton.get();
    } 

}
