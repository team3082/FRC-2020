package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;  


public class ShootSubsystem{

    public static WPI_TalonSRX flyWheel1 = new WPI_TalonSRX(Constants.SHOOTER_LEFT);
    public static WPI_TalonSRX flyWheel2 = new WPI_TalonSRX(Constants.SHOOTER_RIGHT);

    public static Talon beltMotor1 = new Talon(Constants.BELT_MOTOR_LEFT);
    public static Talon beltMotor2 = new Talon(Constants.BELT_MOTOR_RIGHT);

    public static Timer timer = new Timer();

    private static Boolean lastShootbutton = false;
    private static double lastPressTime = 0;
    
    private static final double DELAY = 0.7;

    private static final double TARGET_VELOCITY = Constants.TARGET_FLYWHEEL_RPM * 4096 / 600;

    static {
        timer.start();
    }

    //Runs every time robotPeriodic is run

    public static void init(){
        flyWheel1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        flyWheel2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    }

    public static void update(){

        if(Controller.shootButton.get()){
            // flyWheel1.set(ControlMode.Velocity, -TARGET_VELOCITY);
            // flyWheel2.set(ControlMode.Velocity, TARGET_VELOCITY);
            flyWheel1.set(0.73);
            flyWheel2.set(0.73);

            PneumaticsSubsystem.beltSolenoid.set(Value.kReverse);

            SmartDashboard.putBoolean("Spinning Up", true);


            SmartDashboard.putNumber("Encoder output 1", flyWheel1.getSelectedSensorVelocity());
            SmartDashboard.putNumber("Encoder output 2", flyWheel2.getSelectedSensorVelocity());
        }

        else{
            flyWheel1.set(0);
            flyWheel2.set(0);

            PneumaticsSubsystem.beltSolenoid.set(Value.kForward);

            SmartDashboard.putBoolean("Spinning Up", false);
        }
    } 

}
