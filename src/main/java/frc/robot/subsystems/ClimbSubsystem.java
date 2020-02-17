package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Controller;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;



public class ClimbSubsystem {
    private static Talon winch = new Talon(9);


    public static void update(){
        if(Controller.climbPistonsForward.get())
            PneumaticsSubsystem.climbSolenoid.set(Value.kForward);

        else if(Controller.climbPistonsBack.get())
            PneumaticsSubsystem.climbSolenoid.set(Value.kReverse);

        if(Controller.winch.get())
            winch.set(0.5);

        else
            winch.set(0);
            
    }
}


