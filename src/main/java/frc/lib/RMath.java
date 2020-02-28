/*
 * These are helper methods.
 */

package frc.lib;

public class RMath {

    public static double getAngleDifference(double target, double current) {

        double stay = target-current;
		double forward = target-current+360;
		double back = target-current-360;

		double optimalPos = stay;

		if (Math.abs(forward) < Math.abs(optimalPos))
			optimalPos = forward;
		if (Math.abs(back) < Math.abs(optimalPos))
			optimalPos = back;

		return optimalPos;

	}

	public static double averageAngles(double a, double b) {

		// Force a and b to positive values from 0 to 360
		a %= 360;
		b %= 360;
		if (a < 0)
			a += 360;
		if (b < 0)
			b += 360;

		double angle = (b + getAngleDifference(a,b) / 2) % 360;
		if (angle < 0)
			angle += 360;

		return angle;

	}

	public static double rangeToPercent(double min, double max, double value) {
		return (value-min)/(max-min);
	}

	public static double clamp(double min, double max, double value) {
		return Math.max(Math.min(value, max), min);
	}

    public static double average(double ...a){
        double sum = 0.0;
        for (double x : a) {
            sum += x;
        }
        return (sum/a.length);
    }

	//keeps angles between 0 and 360
	public static double subtractAngles(double a, double b) {
		double deg = (a - b) % 360;
		if (deg < 0)
			deg += 360;
		return deg;
	}

	public static double addAngles(double a, double b) {
		double deg = (a + b) % 360;
		if (deg < 0)
			deg += 360;
		return deg;
	}

}
