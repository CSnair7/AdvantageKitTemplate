package frc.robot.subsystems.flywheel;

import org.littletonrobotics.junction.AutoLog;

public interface FlywheelIO {
    @AutoLog
    public static class FlywheelIOInputs {
        public double velocity = 0.0;
        public double appliedVolts = 0.0;
        public double[] currentAmps = new double[] {};
    }

    public default void updateInputs(FlywheelIOInputs inputs) {}

    public default void setVoltage(double voltage) {}

    public default void setVelocity(double velocity) {}

    public default void stop() {}

    public default void configurePID(double kP, double kI, double kD) {}
}
