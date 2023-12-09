package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DoubleSolenoidIOPCM implements DoubleSolenoidIO {
    private final DoubleSolenoid dSolenoid;

    public DoubleSolenoidIOPCM (int module, int fChannel, int rChannel) {
        dSolenoid = new DoubleSolenoid(module,PneumaticsModuleType.CTREPCM, fChannel, rChannel);
    }

    @Override
     // TODO: implement this function the update all the attributes of the DoubleSolenoidIO object passed in
    // Params: object of DoubleSolenoidIOInputs 
    // Return: this function returns void
    public void updateInputs(DoubleSolenoidIOInputs inputs) {
        inputs.val = dSolenoid.get();
    }

    @Override
    // TODO: implement this function the set the Value of the DoubleSolenoid object
    // Params: fill in the functon parameters as needed by the implementation above
    // Return: this function returns void
    public void set(Value value) {
        dSolenoid.set(value);
    }
}
