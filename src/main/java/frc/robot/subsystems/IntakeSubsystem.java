package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem {
    
    public static Talon intakeMotor = new Talon(Constants.INTAKE_MOTOR);



    public static void update() {
        if(Controller.intakeButton.get()){
            intakeMotor.setSpeed(0.8);
            SmartDashboard.putBoolean("Intake On", true);
        }
        else{
            intakeMotor.setSpeed(0);
            SmartDashboard.putBoolean("Intake On", false);
        }

    }   
}