package frc.robot.auto;

// subsystem imports
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// utility imports
import frc.lib.RT;

public class shootAndMove {

	// global variables

	public static double m_initTime; // Time when auto was called

	public static boolean hasNotStarted;

	public static boolean hasNotShot;

	public static boolean hasNotReved;

	// methods

	public static void init() {

		m_initTime = RT.m_time;

		clear();

	}

	public static void clear() {

		hasNotStarted = true;

		hasNotShot    = true;

		hasNotReved   = true;

	}

	public static void moveOffTheLineAndShoot() {

		if (hasNotStarted) {

			DriveSubsystem.move(2); 

			hasNotStarted = false;

		} else if (hasNotReved && RT.m_time - 3 >= m_initTime) {

			ShootSubsystem.setVelocity(15000);

			hasNotReved = false;

		} else if (hasNotShot && RT.m_time - 5 >= m_initTime) {

			PneumaticsSubsystem.beltSolenoid.set(Value.kForward);

			hasNotShot = false;

		} else if (RT.m_time - 8 >= m_initTime) {

            ShootSubsystem.setVelocity(0);

	  	}

   	}

}