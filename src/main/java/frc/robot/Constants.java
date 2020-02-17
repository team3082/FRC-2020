package frc.robot;

public class Constants{
    //CAN
    public static final int MOTOR_LEFTFRONT = 1;
    public static final int MOTOR_LEFTBACK = 2;
    public static final int MOTOR_RIGHTFRONT = 3;
    public static final int MOTOR_RIGHTBACK = 4;

    public static final int SHOOTER_RIGHT = 5;
    public static final int SHOOTER_LEFT = 6; 

    public static final int PCM = 0;

    //PCM

    public static final int BELT_SOLENOID = 1;
    
    public static final int BELT_SOLENOID_FWD = 0;
    public static final int BELT_SOLENOID_BCK = 7;

    public static final int CLIMB_SOLENOID = 2;

    public static final int CLIMB_SOLENOID_FWD = 1;
    public static final int CLIMB_SOLENOID_BCK = 6;


    //PWM
    public static final int FLYWHEEL_MOTOR_LEFT = 4;
    public static final int FLYWHEEL_MOTOR_RIGHT = 5;

    public static final int BELT_MOTOR1 = 0;
    public static final int BELT_MOTOR2 = 1;

    public static final int INTAKE_MOTOR = 2; 

    public static final int INTAKE_SERVO = 3;
    
    //PID
    public static final double TARGET_FLYWHEEL_RPM = 500;
}


