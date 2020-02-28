package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.auto.shootAndMove; 


public class Robot extends TimedRobot {

    private static final String DEFAULT_AUTO = "Default";
    private static final String CUSTOM_AUTO = "My Auto";

    public static final PowerDistributionPanel pdp = new PowerDistributionPanel(0);

    private String autoSelected;
    private final SendableChooser<String> chooser = new SendableChooser<>();

    @Override
    public void robotInit() {

        chooser.setDefaultOption("Default Auto", DEFAULT_AUTO);
        chooser.addOption("My Auto", CUSTOM_AUTO);
        SmartDashboard.putData("Auto choices", chooser);
        
        DriveSubsystem.motorLeft0.configFactoryDefault();
        DriveSubsystem.motorLeft1.configFactoryDefault();
        DriveSubsystem.motorRight2.configFactoryDefault();
        DriveSubsystem.motorRight3.configFactoryDefault();
        
        ShootSubsystem.init();
        CameraServer.getInstance().startAutomaticCapture();
        
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void autonomousInit() {

        shootAndMove.init(); 

        autoSelected = chooser.getSelected();

        System.out.println("Auto selected: " + autoSelected);
        
    }

    @Override
    public void autonomousPeriodic() {
    }


    @Override
    public void teleopPeriodic() {

        ShootSubsystem.update();
        IntakeSubsystem.update();
        DriveSubsystem.update();

        PneumaticsSubsystem.runCompressor();

    }

    @Override
    public void testPeriodic() {
    }

}
