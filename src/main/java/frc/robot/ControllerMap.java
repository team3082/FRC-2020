package frc.robot;

import frc.lib.controllers.IHID;
import frc.lib.controllers.xbox.XboxOne;

public final class ControllerMap {
  
    public static final class Manipulator {

        public static final IHID shootButton = XboxOne.Button.RIGHT_BUMPER;
        public static final IHID beltButton = XboxOne.Button.Y;    
        public static final IHID intakeButtonFwd = XboxOne.Button.LEFT_BUMPER;
        public static final IHID intakeButtonBack = XboxOne.Button.X;
    
    }

    public static final class Drive {
        public static final IHID forward = XboxOne.Axis.LEFT_STICK_Y;
        public static final IHID rotate = XboxOne.Axis.LEFT_STICK_X;

        public static final IHID slowButton = XboxOne.Button.B;
        public static final IHID climbPistonsForward = XboxOne.Button.X;
        public static final IHID climbPistonsBack = XboxOne.Button.Y;
        public static final IHID winch = XboxOne.Button.A;
    
    }

}