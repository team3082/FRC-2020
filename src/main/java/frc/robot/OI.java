package frc.robot;

import frc.lib.controllers.Controller;
import frc.robot.ControllerMap;
import frc.robot.subsystems.*;

public class OI {
    
    //Controller object and Button objects
    public static Controller driverController = new Controller(0);
    public static Controller manipulatorController = new Controller(1);

    public static void update() {
        IntakeSubsystem.intakePower = manipulatorController.getRaw(ControllerMap.Manipulator.intakeButtonFwd, ControllerMap.Manipulator.intakeButtonBack);

        BeltSubsystem.enabled = manipulatorController.getDown(ControllerMap.Manipulator.beltButton); 

        ClimbSubsystem.setSolenoid(driverController.getRaw(ControllerMap.Drive.climbPistonsForward, ControllerMap.Drive.climbPistonsBack));
        
        double driveForward = driverController.getRaw(ControllerMap.Drive.forward);
        double drivePivot = driverController.getRaw(ControllerMap.Drive.rotate);
		DriveSubsystem.leftPower  = driveForward + Math.max(drivePivot, 0);
        DriveSubsystem.rightPower = driveForward - Math.min(drivePivot, 0);
            
    }

}