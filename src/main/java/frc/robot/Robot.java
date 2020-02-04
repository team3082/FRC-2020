/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * methods corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private static final String DEFAULT_AUTO = "Default";
    private static final String CUSTOM_AUTO = "My Auto";
    private String autoSelected;
    private final SendableChooser<String> chooser = new SendableChooser<>();

    boolean buttonToggle = false;
    boolean driveButtonLast = false;
    boolean testButtonToggleFun = false;
    
    int s = 0;

    // Motors
    private WPI_TalonSRX motorLeft0 = new WPI_TalonSRX(Constants.MOTOR_LEFTFRONT);
    private WPI_TalonSRX motorLeft1 = new WPI_TalonSRX(Constants.MOTOR_LEFTBACK);
    private WPI_TalonSRX motorRight2 = new WPI_TalonSRX(Constants.MOTOR_RIGHTFRONT);
    private WPI_TalonSRX motorRight3 = new WPI_TalonSRX(Constants.MOTOR_RIGHTBACK);
    private Talon flyWheel1 = new Talon(Constants.FLYWHEEL_MOTOR1);
    private Talon flyWheel2 = new Talon(Constants.FLYWHEEL_MOTOR2);

    //Motor Control Groups
    private SpeedControllerGroup motorsLeft = new SpeedControllerGroup(motorLeft0, motorLeft1);
    private SpeedControllerGroup motorsRight = new SpeedControllerGroup(motorRight2, motorRight3);

    //Drivetrain object
    private final DifferentialDrive drive = new DifferentialDrive(motorsLeft, motorsRight);

    //Controller object
    private final Joystick driveCntrl = new Joystick(0);

    private final JoystickButton shootButton = new JoystickButton(driveCntrl, 1);
    private final JoystickButton slowButton = new JoystickButton(driveCntrl, 2);

    /**
     * This method is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        chooser.setDefaultOption("Default Auto", DEFAULT_AUTO);
        chooser.addOption("My Auto", CUSTOM_AUTO);
        SmartDashboard.putData("Auto choices", chooser);
        
        // testMotor.set(ControlMode.PercentOutput, 0);
        motorLeft0.configFactoryDefault();
        motorLeft1.configFactoryDefault();
        motorRight2.configFactoryDefault();
        motorRight3.configFactoryDefault();
        // drive.setRightSideInverted(false);
    }
    /**
     * This method is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     * <p>
     * This runs after the mode specific periodic methods, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic()
    {
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString line to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional comparisons to
     * the switch structure below with additional strings. If using the
     * SendableChooser make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit() {
        autoSelected = chooser.getSelected();
        // autoSelected = SmartDashboard.getString("Auto Selector",
        // defaultAuto);
        System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This method is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        switch (autoSelected)
        {
            case CUSTOM_AUTO:
                // Put custom auto code here
                break;
            case DEFAULT_AUTO:
            default:
                // Put default auto code here
                break;
        }
    }

    /**
     * This method is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        // double speedmod; 
        // if(slowButton.get()){
        //     speedmod = 0.4;
        // }
        // else {
        //     speedmod = 0.8;
        // }
        
        double x = driveToggle(slowButton.get());
        

        // drive.arcadeDrive(-driveCntrl.getY() * x, driveCntrl.getX() * x);

        flyWheel1.setSpeed(driveCntrl.getRawAxis(3));
        flyWheel2.setSpeed(-driveCntrl.getRawAxis(3));

        
        
        


        
        if(shootButton.get() && testButtonToggleFun == false) {
            s = (s + 1) % 4; 
        }

        testButtonToggleFun = shootButton.get();

        switch(s){
            case 0:
                drive.arcadeDrive(0, 0);
                break;
            case 1:
                drive.arcadeDrive(0.1, 0);
                break;
            case 2:
                drive.arcadeDrive(0, 0);
                break;
            case 3:
                drive.arcadeDrive(-0.1, 0);

            
        }
        

        // if(shootButton.get() == true) {
        //     // flyWheel.setSpeed(0.6);
        //     flyWheel1.setSpeed(1);
        //     flyWheel2.setSpeed(-1);

        //     SmartDashboard.putBoolean("flyon", true);
            
        // }
        // else{
        //     flyWheel1.setSpeed(0);
        //     flyWheel2.setSpeed(0);
        //     SmartDashboard.putBoolean("flyon", false);
        // }
    } 

    public double driveToggle(boolean buttonValue) {
        double speedmod;   

        if(buttonValue && !driveButtonLast)
            buttonToggle = !buttonToggle;     

            driveButtonLast = buttonValue;

        if(buttonToggle)
            speedmod = 0.4;

        else
            speedmod = 0.8;

        return speedmod;
    }



    /**
     * This method is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
    }
}
