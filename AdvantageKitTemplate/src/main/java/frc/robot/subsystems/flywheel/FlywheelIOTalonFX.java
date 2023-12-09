package frc.robot.subsystems.flywheel;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.util.Units;

public class FlywheelIOTalonFX implements FlywheelIO{
    private final TalonFX leader;
    private final TalonFX follower;

    private final StatusSignal<Double> velocity;
    private final StatusSignal<Double> appliedVolts;
    private final StatusSignal<Double> mCurrentAmps;
    private final StatusSignal<Double> sCurrentAmps;

    public FlywheelIOTalonFX(int mID, int sID) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = 40;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        this.leader = new TalonFX(mID);
        this.follower = new TalonFX(sID);

        follower.setControl(new Follower(leader.getDeviceID(), false));

        leader.getConfigurator().apply(config);
        follower.getConfigurator().apply(config);

        this.velocity = leader.getVelocity();
        this.appliedVolts = leader.getMotorVoltage();
        this.mCurrentAmps = leader.getStatorCurrent();
        this.sCurrentAmps = follower.getStatorCurrent();

        BaseStatusSignal.setUpdateFrequencyForAll(100, velocity, appliedVolts, mCurrentAmps, sCurrentAmps);
    }

    @Override
    // TODO: implement this function the update all the attributes of the FlywheelIOInputs object passed in
    // Params: object of FlywheelIOInputs 
    // Return: this function returns void
    public void updateInputs(FlywheelIOInputs inputs) {
        inputs.velocity = leader.getVelocity();
    }

    @Override
    // TODO: implement this function to set the lead motor to a certain voltage
    // Params: fill in the function parameters as need by the implementation above
    // Return: this function returns void
    public void setVoltage(<REPLACE_WITH_PARAM>) {
        throw Error("Not Implemented Yet"); // remove this line when you start
    }

    @Override
    // TODO: implement this function to set the lead motor to move to a given velocity
    // Params: velocity of flywheel
    // Return: this function returns void
    public void setVelocity(double velocity) {
        throw Error("Not Implemented Yet"); // remove this line when you start
    }

    @Override 
    // TODO: implement this function to stop the lead motor
    // Params: none
    // Return: this function returns void
    public void stop() {
        throw Error("Not Implemented Yet"); // remove this line when you start
    }

    @Override
    public void configurePID(double kP, double kI, double kD) {
        Slot0Configs config = new Slot0Configs();
        config.kP = kP;
        config.kI = kI;
        config.kD = kD;
        leader.getConfigurator().apply(config);
    }
}