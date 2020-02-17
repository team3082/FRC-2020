package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Servo;


public class IntakeSubsystem {
    
    public static Talon intakeMotor = new Talon(Constants.INTAKE_MOTOR);

    public static Servo intakeServo = new Servo(Constants.INTAKE_SERVO);

    public static boolean intakeButtonLast = false;
    public static boolean z = false;
    // private static final DoubleSolenoid intakeMove = new DoubleSolenoid(Constants.INTAKE_SOLEDNOID_FWD, Constants.INTAKE_SOLEDNOID_BCK);

    //Runs every time robotPeriodic is run
    public static void update() {
        if(Controller.intakeButton.get()){
            intakeMotor.setSpeed(-0.8);
            SmartDashboard.putBoolean("Intake On", true);
        }
        else{
            intakeMotor.setSpeed(0);
            SmartDashboard.putBoolean("Intake On", false);
        }
        
    }   
    public static void intakeAuto(){
        intakeServo.set(1);
    }

    public static void intakeInit(){
        if(intakeServo.get() != 0.4)
            intakeServo.set(0.4);
    }

}   