package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.ControllerMap.Drive;
import frc.robot.auto.ShootAndMove; 
import frc.lib.RTime;

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
        
        RTime.init(m_period); //m_period is a variable made in the base class that sets the interval between ticks

        BeltSubsystem.init();
        ClimbSubsystem.init();
        DriveSubsystem.init();
        IntakeSubsystem.init();
        ShootSubsystem.init();
        
        CameraServer.getInstance().startAutomaticCapture();
        
    }

    @Override
    public void disabledInit() {
        
        //clean out vars on shutdown to prevent things from running accidentally
        BeltSubsystem.clear();
        ClimbSubsystem.clear();
        DriveSubsystem.clear();
        IntakeSubsystem.clear();
        ShootSubsystem.clear();
        
        ShootAndMove.clear(); 
    }

    @Override
    public void robotPeriodic() {
        RTime.m_ticks++;
    }

    @Override
    public void autonomousInit() {

        ShootAndMove.start(); 

        autoSelected = chooser.getSelected();

        System.out.println("Auto selected: " + autoSelected);
        
    }

    @Override
    public void autonomousPeriodic() {
        
        ShootAndMove.update();

        BeltSubsystem.update();
        DriveSubsystem.update();
        IntakeSubsystem.update();
        ShootSubsystem.update();
        
    }


    @Override
    public void teleopPeriodic() {

        OI.update();

        BeltSubsystem.update();
        ClimbSubsystem.update();
        DriveSubsystem.update();
        IntakeSubsystem.update();
        ShootSubsystem.update();
        

        PneumaticsSubsystem.runCompressor();

    }

    @Override
    public void testPeriodic() {
    }

}
