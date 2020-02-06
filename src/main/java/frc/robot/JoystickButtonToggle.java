package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class JoystickButtonToggle extends JoystickButton {

    /**
     * The value of whether or not the button is toggled "on" or "off"
     */
    private boolean buttonToggle = false;
    /**
     * The value of the button the last time get() or getToggle() was called
     */
    private boolean buttonLast = false;

    /**
     * Create a joystick button for triggering commands.
     *
     * @param joystick     The GenericHID object that has the button (e.g. Joystick, KinectStick,
     *                     etc)
     * @param buttonNumber The button number (see {@link GenericHID#getRawButton(int) }
     */
    public JoystickButtonToggle(GenericHID joystick, int buttonNumber) {
        super(joystick, buttonNumber);
    }

    public boolean get() {
        boolean value = super.get();
        update(value);
        return value;
    }

    public boolean getToggle() {
        update(super.get());
        return buttonToggle;
    }

    private void update(boolean buttonValue) {
        if(buttonValue && !buttonLast) {
            buttonToggle = !buttonToggle;
        }
        buttonLast = buttonValue;
    }
}
