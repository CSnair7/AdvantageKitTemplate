package frc.robot.subsystems.intake;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class IntakePivotIOTalonFX implements IntakePivotIO{
    private final TalonFX falcon;

    private final StatusSignal<Double> pivotPosition;
    private final StatusSignal<Double> pivotVelocity;
    private final StatusSignal<Double> appliedVolts;
    private final StatusSignal<Double> currentAmps;

    public IntakePivotIOTalonFX(int id) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = 30;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        falcon = new TalonFX(id);

        falcon.getConfigurator().apply(config);

        pivotPosition = falcon.getPosition();
        pivotVelocity = falcon.getVelocity();
        appliedVolts = falcon.getMotorVoltage();
        currentAmps = falcon.getStatorCurrent();

        BaseStatusSignal.setUpdateFrequencyForAll(100, pivotPosition, pivotVelocity, appliedVolts, currentAmps);

    }

    @Override
    // TODO: implement this function the update all the attributes of the IntakePivotIOInputs object passed in
    // Params: object of IntakePivotIOInputs 
    // Return: this function returns void
    public void updateInputs(IntakePivotIOInputs inputs) {
        inputs.pivotPosition = pivotPosition.getValue();
        inputs.pivotVelocity = pivotVelocity.getValue();
        inputs.appliedVolts = appliedVolts.getValue();
        inputs.currentAmps = currentAmps.getValue();
    }

    @Override
    // TODO: implement this function to set the pivot motor to move to a given positional value
    // Params: fill in the function parameters as need by the implementation above
    // Return: this function returns void
    public void setPosition(double position) {
        falcon.setPosition(position);
    }

    @Override 
    // TODO: implement this function to set the pivot motor to move to a given velocity
    // Params: fill in the function parameters as need by the implementation above
    // Return: this function returns void
    public void setVelocity(double velocity) {
        falcon.set(velocity);
    }

    @Override
    // TODO: implement this function to stop the pivot motor
    // Params: none
    // Return: this function returns void
    public void stop() {
        falcon.set(0.0); // remove this line when you start
    }

    @Override
    public void configurePID(double kP, double kI, double kD) {
        Slot0Configs config = new Slot0Configs();

        config.kP = kP;
        config.kI = kI;
        config.kD = kD;

        falcon.getConfigurator().apply(config);
    }
}
