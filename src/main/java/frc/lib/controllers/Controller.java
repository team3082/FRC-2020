package frc.lib.controllers;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

    private Joystick m_controller;

    public Controller(int id) {
        m_controller = new Joystick(id);
    }

    public double getRaw(IHID hid) {
        if (hid == null)
            return 0;

        if (hid.isButton()) {
            if(hid.isPOV())
                return (m_controller.getPOV() == hid.getId()) ? 1 : 0;
            return m_controller.getRawButton(hid.getId()) ? 1 : 0;
        }

        //direction of the id determines the direction of the axis
        if(hid.isPOV()) {
            double dir = Math.toRadians(m_controller.getPOV() - hid.getId());
            return Math.cos(dir);
        }
        return m_controller.getRawAxis(hid.getId());
    }

    public double getRaw(IHID positive, IHID negative) {
        return getRaw(positive) - getRaw(negative);
    }

    public boolean getDown(IHID hid) {
        if (hid == null)
            return false;

        if (hid.isButton()) {
            if(hid.isPOV())
                return m_controller.getPOV() == hid.getId();
            return m_controller.getRawButton(hid.getId());
        }

        //direction of the id determines the direction of the axis
        if(hid.isPOV()) {
            double dir = m_controller.getPOV() - hid.getId() * Math.PI / 180.0;
            return Math.abs(Math.cos(dir)) > 0.05;
        }
        return Math.abs(m_controller.getRawAxis(hid.getId())) > 0.05;
    }

    public boolean getReleased(IHID hid){
        if (hid == null)
            return false;

        if (hid.isButton())
            return m_controller.getRawButtonReleased(hid.getId());

        return false;
    }
    public String getName(){
        return m_controller.getName();
    }

}
