package frc.lib.controllers.logitech;

import frc.lib.controllers.IHID;

public class Attack3 {

    public enum Axis implements IHID {
        STICK_X(0),
        STICK_Y(1),
        SLIDER(2);

        int m_id;
        
        Axis(int id) {
            m_id = id;
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
            return false;
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
        ELEVEN(11);

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
