package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class IntakeSubsystem {
    
    public static Talon intakeMotor = new Talon(Constants.INTAKE_MOTOR);

    public static boolean intakeButtonLast = false;
    public static boolean z = false;
    // private static final DoubleSolenoid intakeMove = new DoubleSolenoid(Constants.INTAKE_SOLEDNOID_FWD, Constants.INTAKE_SOLEDNOID_BCK);

    //Runs every time robotPeriodic is run
    public static void update() {
        if(Controller.intakeButtonFwd.get())
            intakeMotor.set(0.7);
        else if(Controller.intakeButtonBack.get())
            intakeMotor.set(-0.7);
        else
            intakeMotor.set(0);


        if(Controller.beltButton.get()) {
            BeltSubsystem.beltOn();
        } else {
            BeltSubsystem.beltOff();
        }
        SmartDashboard.putNumber("Intake Current", Robot.pdp.getCurrent(12));

    }

}   