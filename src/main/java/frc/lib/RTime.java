package frc.lib;

//Robot Time
public class RTime { 

    public static int m_ticks; 
    private static double m_period;

    public static void init(double period) {
        m_period = period;
    }

    public static double getTime () {
        return m_ticks * m_period; 
    }

}