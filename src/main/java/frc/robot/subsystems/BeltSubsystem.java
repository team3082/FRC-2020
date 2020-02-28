package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants;
import frc.robot.subsystems.ShootSubsystem;

public class BeltSubsystem{

    private static TalonSRX beltMotorMain = new TalonSRX(Constants.BELT_MOTOR_LEFT);
    private static TalonSRX beltMotorFollower = new TalonSRX(Constants.BELT_MOTOR_RIGHT);
    
    public static boolean enabled;

    public static void init() {
        beltMotorMain.setInverted(true);
        beltMotorFollower.setInverted(false);

        beltMotorFollower.follow(beltMotorMain);
    }
    public static void clear() {
        enabled = false;
    }

    public static void update(){
        //this prevents the belt from feeding power cells before the shooter is up to speed
        if (enabled && ShootSubsystem.atSetpoint()){
            beltMotorMain.set(ControlMode.PercentOutput, 0.4);
        }
        else {
            beltMotorMain.set(ControlMode.PercentOutput, 0);
        }
    }

}