package frc.robot.auto;

// subsystem imports
import frc.robot.subsystems.*;

// utility imports
import frc.lib.RTime;

public class ShootAndMove {

	public static double m_initTime; // Time when auto was called

	public static boolean hasNotStarted;

	public static boolean hasNotShot;

	// methods

	public static void start() {

		m_initTime = RTime.getTime();

		clear();

	}

	public static void clear() {

		hasNotStarted = true;
		hasNotShot   = true;

	}

	public static void moveOffTheLineAndShoot() {

		//drive backwards for 2 seconds then shoot
		if (hasNotStarted) {

			DriveSubsystem.leftPower = -1;
			DriveSubsystem.rightPower = -1; 

			hasNotStarted = false;

		} else if (hasNotShot && RTime.getTime() >= m_initTime + 2) {

			DriveSubsystem.leftPower = 0;
			DriveSubsystem.rightPower = 0; 

			ShootSubsystem.enabled = true;
			BeltSubsystem.enabled = true;

			hasNotShot = false;

		} else if (RTime.getTime() >= m_initTime + 13) {

			ShootSubsystem.enabled = false;
			BeltSubsystem.enabled = false;

	  	}

   	}

}