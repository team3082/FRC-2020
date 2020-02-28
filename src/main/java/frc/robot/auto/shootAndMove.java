package frc.robot.auto;

// subsystem imports
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.DriveSubsystem;
// utility imports
import frc.lib.RT;
import frc.lib.Log;

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

			DriveSubsystem.move(5); 

			hasNotStarted = false;

			Log.println("started");

		} else if (hasNotReved && RT.m_time - 3 >= m_initTime) {

			// ShootSubsystem.setShooterVelocity();

			hasNotReved = false;

			Log.println("reved");

		} else if (hasNotShot && RT.m_time - 5 >= m_initTime) {

			// ShootSubsystem.setShooterVelocity();

			hasNotShot = false;

			Log.println("shot");

		} else if (RT.m_time - 8 >= m_initTime) {

			// ShootSubsystem.setShooterVelocity();

			Log.println("stopped");

	  	}

   	}

}