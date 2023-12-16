package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.AutoLog;

public interface CompressorIO {
    @AutoLog
    public static class CompressorIOInputs {
        public boolean isOn = false;

        public double compressorCurrent = 0.0;
        public double compressorPressure = 0.0;
    }

    public default void updateInputs(CompressorIOInputs inputs) {}

    public default void enableCompressor() {}

    public default void disableCompressor() {}
}
