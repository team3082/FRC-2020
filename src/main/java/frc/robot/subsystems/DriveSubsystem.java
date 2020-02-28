package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.lib.RT;
import frc.robot.Constants;
import frc.robot.Controller;

public class DriveSubsystem {

    static boolean buttonToggle = false;
    static boolean driveButtonLast = false;

    static double speedmod;
    int s = 0;

    // Motors
    public static final WPI_TalonSRX motorLeft0 = new WPI_TalonSRX(Constants.MOTOR_LEFTFRONT);
    public static final WPI_TalonSRX motorLeft1 = new WPI_TalonSRX(Constants.MOTOR_LEFTBACK);
    public static final WPI_TalonSRX motorRight2 = new WPI_TalonSRX(Constants.MOTOR_RIGHTFRONT);
    public static final WPI_TalonSRX motorRight3 = new WPI_TalonSRX(Constants.MOTOR_RIGHTBACK);

    //Controls the Power of Motors
    public static double leftPower;
    public static double rightPower;

    public static void init(){
        motorLeft1.follow(motorLeft0);
        motorRight3.follow(motorRight2);
    }

    //Runs every time robotPeriodic is run
    public static void update() {
        
        motorLeft0.set(ControlMode.PercentOutput, leftPower);
        motorRight2.set(ControlMode.PercentOutput, rightPower);
        
    }

    public static double driveToggle(final boolean buttonValue) {
        double speedmod;

        if (buttonValue && !driveButtonLast)
            buttonToggle = !buttonToggle;

            driveButtonLast = buttonValue;

        if(buttonToggle)
            speedmod = 0.4;

        else
            speedmod = 0.8;

        return speedmod;

    }

    public static void move (double seconds) {
        double m_initialTime = RT.m_time; 

        motorLeft0.set(ControlMode.PercentOutput, 1); 
        motorLeft1.set(ControlMode.PercentOutput, 1); 
        motorRight2.set(ControlMode.PercentOutput, 1); 
        motorRight3.set(ControlMode.PercentOutput, 1); 

        if (RT.m_time - seconds >= m_initialTime) {
            motorLeft0.set(ControlMode.PercentOutput, 0); 
            motorLeft1.set(ControlMode.PercentOutput, 0); 
            motorRight2.set(ControlMode.PercentOutput, 0); 
            motorRight3.set(ControlMode.PercentOutput, 0); 
        }

    }

}