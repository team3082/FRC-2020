package frc.lib.controllers.logitech;

import frc.lib.controllers.IHID;

public class F310 {

    public enum Axis implements IHID {
        LEFT_STICK_X(0),
        LEFT_STICK_Y(1),
        LEFT_TRIGGER(2),
        RIGHT_TRIGGER(3),
        RIGHT_STICK_X(4),
        RIGHT_STICK_Y(5),
        DPAD_X(90, true),
        DPAD_Y(180, true);

        int m_id;
        boolean m_isPOV;

        Axis(int id) {
            m_id = id;
        }

        Axis(int id, boolean isPOV) {
            m_id = id;
            m_isPOV = isPOV;
        }

        public int getId() {
            return m_id;
        }

        public boolean isButton() {
            return false;
        }

        public boolean isAxis() {
            return true;
        }

        public boolean isPOV() {
            return m_isPOV;
        }
    }

    public enum Button implements IHID {
        A(1),
        B(2),
        X(3),
        Y(4),
        LEFT_BUMPER(5),
        RIGHT_BUMPER(6),
        BACK(7),
        START(8),
        LEFT_STICK(9),
        RIGHT_STICK(10),

        DPAD_UP(0, true),
        DPAD_RIGHT(90, true),
        DPAD_DOWN(180, true),
        DPAD_LEFT(270, true);


        int m_id;
        boolean m_isPOV;

        Button(int id) {
            m_id = id;
        }

        Button(int id, boolean isPOV) {
            m_id = id;
        }

        public int getId() {
            return m_id;
        }

        public boolean isButton() {
            return true;
        }

        public boolean isAxis() {
            return false;
        }

        public boolean isPOV() {
            return m_isPOV;
        }
    }

}
