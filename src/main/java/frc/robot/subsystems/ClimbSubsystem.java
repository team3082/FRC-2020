package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ClimbSubsystem {
    private static TalonSRX winch = new TalonSRX(Constants.WINCH);
    public static double winchPower;

    public static void init() {
        winch.setInverted(true);
        clear();
    }

    public static void clear() {
        winchPower = 0;
    }

    public static void setSolenoid(double value) {

        if(value > 0)
            PneumaticsSubsystem.climbSolenoid.set(Value.kForward);
        else if(value < 0)
            PneumaticsSubsystem.climbSolenoid.set(Value.kReverse);
        else
            PneumaticsSubsystem.climbSolenoid.set(Value.kOff);
    
    }

    public static void update() {
        winch.set(ControlMode.PercentOutput, winchPower * 0.5);
    }

}