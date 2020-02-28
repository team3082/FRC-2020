package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class IntakeSubsystem {
    
    private static TalonSRX intakeMotor = new TalonSRX(Constants.INTAKE_MOTOR);
    public static double intakePower;
    // private static final DoubleSolenoid intakeMove = new DoubleSolenoid(Constants.INTAKE_SOLEDNOID_FWD, Constants.INTAKE_SOLEDNOID_BCK);

    public static void init() {
        intakeMotor.setInverted(false);
        
        clear();
    }

    public static void clear() {
        intakePower = 0;
    }

    //Runs every time robotPeriodic is run
    public static void update() {
        
        intakeMotor.set(ControlMode.PercentOutput, intakePower * 0.7);

        SmartDashboard.putNumber("Intake Current", Robot.pdp.getCurrent(12));
    }

}   