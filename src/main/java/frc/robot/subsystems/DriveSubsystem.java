package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.lib.RTime;
import frc.robot.Constants;

public class DriveSubsystem {


    // Motors
    private static final TalonSRX motorLeftMain      = new TalonSRX(Constants.MOTOR_LEFTFRONT);
    private static final TalonSRX motorLeftFollower  = new TalonSRX(Constants.MOTOR_LEFTBACK);
    private static final TalonSRX motorRightMain     = new TalonSRX(Constants.MOTOR_RIGHTFRONT);
    private static final TalonSRX motorRightFollower = new TalonSRX(Constants.MOTOR_RIGHTBACK);

    private static final boolean wheelsOnTheInside = true;

    //Controls the Power of Motors
    public static double leftPower;
    public static double rightPower;

    private static boolean buttonToggle;
    private static double speedmod;

    public static void init(){

        
        motorLeftMain.configFactoryDefault();
        motorLeftFollower.configFactoryDefault();
        motorRightMain.configFactoryDefault();
        motorRightFollower.configFactoryDefault();
        
        motorLeftFollower.follow(motorLeftMain);
        motorRightFollower.follow(motorRightMain);

        motorLeftMain.setInverted(wheelsOnTheInside);
        motorLeftFollower.setInverted(wheelsOnTheInside);

        motorRightMain.setInverted(!wheelsOnTheInside);
        motorRightFollower.setInverted(!wheelsOnTheInside);

        //allows for stronger turns
        motorLeftMain.setNeutralMode(NeutralMode.Brake);
        motorRightMain.setNeutralMode(NeutralMode.Brake);
        
        //"full output" will now scale to 10 Volts for all control modes when enabled
        //keeps driving consistent while the battery drains
        motorLeftMain.configVoltageCompSaturation(10);
        motorLeftMain.enableVoltageCompensation(true);
        motorRightMain.configVoltageCompSaturation(10);
        motorRightMain.enableVoltageCompensation(true);

        clear();
    }

    public static void clear() {
        leftPower = 0;
        rightPower = 0;
        speedmod = 0.4;
        buttonToggle = false; 
    }

    //Runs every time robotPeriodic is run
    public static void update() {
        
        motorLeftMain.set(ControlMode.PercentOutput, leftPower * speedmod);
        motorRightMain.set(ControlMode.PercentOutput, rightPower * speedmod);
        
    }

    public static void boostToggle() {

        buttonToggle = !buttonToggle;

        if(buttonToggle)
            speedmod = 0.4;
        else
            speedmod = 0.8;

    }

}