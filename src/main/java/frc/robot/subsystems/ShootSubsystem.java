package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;  
import com.ctre.phoenix.motorcontrol.*;

public class ShootSubsystem{

    public static TalonSRX flyWheelMain = new TalonSRX(Constants.SHOOTER_LEFT);
    public static TalonSRX flyWheelFollower = new TalonSRX(Constants.SHOOTER_RIGHT);

    public static final double TARGET_VELOCITY = Constants.TARGET_FLYWHEEL_RPM * 4096 / 600;

    //Velocity Control PID
    //TUNE THIS!
    private static final double kP      = 0.045;
    private static final double kI      = 0.00005;
    private static final double kD      = 0;
    //https://phoenix-documentation.readthedocs.io/en/latest/ch16_ClosedLoop.html#calculating-velocity-feed-forward-gain-kf
    private static final double kF      = 1023 * 0.73 / 7200.0; // 1023 is max feed forward 72000 is max velocity at 73% battery output 
    
    private static final int kPIDLoopIdx = 0;
    private static final int kTimeoutMs  = 30;
    
    private static final double velocityThreshold = 100;
    
    //we only have one target velocity, so we can just add an enable variable
    public static boolean enabled;

    public static void init(){

        flyWheelMain.configFactoryDefault();
        flyWheelFollower.configFactoryDefault();

        flyWheelFollower.follow(flyWheelMain);

        flyWheelMain.setInverted(false);
        flyWheelFollower.setInverted(false);

        flyWheelMain.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, kPIDLoopIdx, kTimeoutMs);
		flyWheelMain.setSensorPhase(false); //is the sensor inverted?

        // This is just some boilerplate code for setting up the pids
		flyWheelMain.configNominalOutputForward(0, kTimeoutMs);
		flyWheelMain.configNominalOutputReverse(0, kTimeoutMs);
		flyWheelMain.configPeakOutputForward(1, kTimeoutMs);
		flyWheelMain.configPeakOutputReverse(-1, kTimeoutMs);
		flyWheelMain.config_kF(kPIDLoopIdx, kF, kTimeoutMs);
		flyWheelMain.config_kP(kPIDLoopIdx, kP, kTimeoutMs);
		flyWheelMain.config_kI(kPIDLoopIdx, kI, kTimeoutMs);
        flyWheelMain.config_kD(kPIDLoopIdx, kD, kTimeoutMs);
        flyWheelMain.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        
        //follower might need the same code above? cant remember very tired
        flyWheelFollower.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

        clear();
    }

    public static void clear() {
        enabled = false;
    }
    //Runs every time robotPeriodic is run
    public static void update(){

        

        if(enabled){
            flyWheelMain.set(ControlMode.Velocity, TARGET_VELOCITY);

            PneumaticsSubsystem.beltSolenoid.set(Value.kReverse);

            SmartDashboard.putBoolean("Spinning Up", true);
            SmartDashboard.putBoolean("Spun Up", atSetpoint());


            SmartDashboard.putNumber("Encoder output 1", flyWheelMain.getSelectedSensorVelocity());
            SmartDashboard.putNumber("Encoder output 2", flyWheelFollower.getSelectedSensorVelocity());
        }

        else{
            flyWheelMain.set(ControlMode.PercentOutput, 0);

            PneumaticsSubsystem.beltSolenoid.set(Value.kForward);

            SmartDashboard.putBoolean("Spinning Up", false);
            SmartDashboard.putBoolean("Spun Up", false);
        }
    } 

    public static boolean atSetpoint() {
        return Math.abs(ShootSubsystem.TARGET_VELOCITY-velocityThreshold) < ShootSubsystem.flyWheelMain.getSelectedSensorVelocity();
    }

}
