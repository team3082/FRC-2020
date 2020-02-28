package frc.lib.controllers.logitech;

import frc.lib.controllers.IHID;

public class X3D {

    public enum Axis implements IHID {
        STICK_X(0),
        STICK_Y(1),
        TWIST(2),
        SLIDER(3),
        POV_X(90, true),
        POV_Y(180, true);

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
        TRIGGER(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        ELEVEN(11),
        TWELVE(12);

        int m_id;
        Button(int id) {
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
            return false;
        }
    }

}
