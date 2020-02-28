package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import frc.robot.Constants;
import frc.robot.subsystems.ShootSubsystem;

public class BeltSubsystem{

    public static Talon beltMotor1 = new Talon(Constants.BELT_MOTOR_LEFT);
    public static Talon beltMotor2 = new Talon(Constants.BELT_MOTOR_RIGHT);

    public static void beltOn(){
        if (ShootSubsystem.flyWheel1.getSelectedSensorVelocity() > (ShootSubsystem.TARGET_VELOCITY-100)){
            beltMotor1.setSpeed(-0.4);
            beltMotor2.setSpeed(0.4 );
        }
    }

    public static void beltOff(){
        beltMotor1.setSpeed(0);
        beltMotor2.setSpeed(0);
    }

}