package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public interface DoubleSolenoidIO {
    @AutoLog
    public static class DoubleSolenoidIOInputs {
        public Value val = Value.kOff;
    }

    public default void updateInputs(DoubleSolenoidIOInputs inputs) {}

    public default void set(Value value) {}
}
