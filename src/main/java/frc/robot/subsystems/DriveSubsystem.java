package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Controller;

public class DriveSubsystem {

    static boolean buttonToggle = false;
    static boolean driveButtonLast = false;

    static double speedmod;
    int s = 0;

    // Motors
    public static final WPI_TalonSRX motorLeft0 = new WPI_TalonSRX(Constants.MOTOR_LEFTFRONT);
    public static final WPI_TalonSRX motorLeft1 = new WPI_TalonSRX(Constants.MOTOR_LEFTBACK);
    public static final WPI_TalonSRX motorRight2 = new WPI_TalonSRX(Constants.MOTOR_RIGHTFRONT);
    public static final WPI_TalonSRX motorRight3 = new WPI_TalonSRX(Constants.MOTOR_RIGHTBACK);

    // Motor Control Groups
    private static final SpeedControllerGroup motorsLeft = new SpeedControllerGroup(motorLeft0, motorLeft1);
    private static final SpeedControllerGroup motorsRight = new SpeedControllerGroup(motorRight2, motorRight3);

    // Drivetrain object
    private static final DifferentialDrive drive = new DifferentialDrive(motorsLeft, motorsRight);

    public static void update() {
        if (Controller.slowButton.get()) {
            speedmod = 0.4;
        } else {
            speedmod = 0.8;
        }

        final double x = driveToggle(Controller.slowButton.get());

        drive.arcadeDrive(-Controller.driveCntrl.getY() * x, Controller.driveCntrl.getX() * x);
    }

    public static double driveToggle(final boolean buttonValue) {
        double speedmod;

        if (buttonValue && !driveButtonLast)
            buttonToggle = !buttonToggle;

            driveButtonLast = buttonValue;

        if(buttonToggle)
            speedmod = 0.4;

        else
            speedmod = 0.8;

        return speedmod;
    }
}