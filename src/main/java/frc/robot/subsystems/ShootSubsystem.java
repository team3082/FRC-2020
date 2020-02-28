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

    private static final double kP      = 0.045;
    private static final double kI      = 0.00005;
    private static final double kD      = 00;
    //WE NEED TO TEST THE SECOND VALUE:
    private static final double kF      = 1023/21525.0;
    public static final int kSlotIdx    = 0;
    public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutMs  = 30;

    //Runs every time robotPeriodic is run

    public static void init(){

        flyWheel1.configFactoryDefault();

        flyWheel1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, kPIDLoopIdx, kTimeoutMs);

		flyWheel1.setSensorPhase(true);

        // THIS IS ALL SETUP FOR VELOCITY CONTROLL DO NOT CHANGE:
		flyWheel1.configNominalOutputForward(0, kTimeoutMs);
		flyWheel1.configNominalOutputReverse(0, kTimeoutMs);
		flyWheel1.configPeakOutputForward(1, kTimeoutMs);
		flyWheel1.configPeakOutputReverse(-1, kTimeoutMs);
		flyWheel1.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
		flyWheel1.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		flyWheel1.config_kI(kPIDLoopIdx, kI, kTimeoutMs);
        flyWheel1.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
        flyWheel1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        flyWheel2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        flyWheel2.follow(flyWheel1);



    }

    public static void update(){

        if(Controller.shootButton.get()){
            // flyWheel1.set(ControlMode.Velocity, -TARGET_VELOCITY);
            // flyWheel2.set(ControlMode.Velocity, TARGET_VELOCITY);
            flyWheel1.set(0.73);

            PneumaticsSubsystem.beltSolenoid.set(Value.kReverse);

            SmartDashboard.putBoolean("Spinning Up", true);


            SmartDashboard.putNumber("Encoder output 1", flyWheel1.getSelectedSensorVelocity());
            SmartDashboard.putNumber("Encoder output 2", flyWheel2.getSelectedSensorVelocity());
        }

        else{
            flyWheel1.set(0);

            PneumaticsSubsystem.beltSolenoid.set(Value.kForward);

            SmartDashboard.putBoolean("Spinning Up", false);
        }
    } 

    public static void setVelocity(double vel){
        flyWheel1.set(ControlMode.Velocity,vel);
    }

}
