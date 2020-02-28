package frc.lib;

public class Log {

    public static boolean m_enabled = false;

    public static void println(Object str) {
        if (m_enabled) {
            if (str == null) {
                System.out.println("null");
            } else {
                System.out.println(str.toString());
            }
        }
    }

    public static void println(String str) {
        if (m_enabled)
            System.out.println(str);
    }

    public static void print(Object str) {
        if (m_enabled) {
            if (str == null) {
                System.out.print("null");
            } else {
                System.out.print(str.toString());
            }
        }
    }

    public static void print(String str) {
        if (m_enabled)
            System.out.print(str);
    }

}
