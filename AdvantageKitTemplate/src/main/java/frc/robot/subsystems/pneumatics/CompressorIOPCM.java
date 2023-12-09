package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class CompressorIOPCM implements CompressorIO{
    private final Compressor compressor;

    public CompressorIOPCM(int module) {
        compressor  = new Compressor(module, PneumaticsModuleType.CTREPCM);
    }

    @Override
    // TODO: implement this function the update all the attributes of the CompressorIOInputs object passed in
    // Params: object of CompressorIOInputs 
    // Return: this function returns void
    public void updateInputs(CompressorIOInputs inputs) {
        inputs.isOn = compressor.isEnabled();
        inputs.compressorCurrent = compressor.getCurrent();
        inputs.compressorPressure = compressor.getPressure();
    }

    @Override
    // TODO: implement this function to enable the compressor object
    // Params: none
    // Return: this function returns void
    public void enableCompressor() {
        compressor.enableDigital();
    }

    @Override 
    // TODO: implement this function to disable the compressor object
    // Params: none
    // Return: this function returns void
    public void disableCompressor() {
        compressor.disable();
    }
}
