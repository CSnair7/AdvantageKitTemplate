// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticIntake extends SubsystemBase {
  private final DoubleSolenoidIOPCM intakeSolenoid;
  private final CompressorIOPCM compressor;
  private final DoubleSolenoidIOInputsAutoLogged sInputs = new DoubleSolenoidIOInputsAutoLogged();
  private final CompressorIOInputsAutoLogged cInputs = new CompressorIOInputsAutoLogged();

  private boolean toggle = false;;
  /** Creates a new PneumaticIntake. */
  public PneumaticIntake(DoubleSolenoidIOPCM intakeSolenoid, CompressorIOPCM compressor) {
    this.intakeSolenoid = intakeSolenoid;
    this.compressor = compressor;
  }

  // TODO: implement this function to toggle on and off the compressor
  // Params: none
  // Return: this function returns void
  public void toggleCompressor() {
    if (toggle == false) {
      compressor.enableCompressor();
      toggle = true;
    } else {
      compressor.disableCompressor();
      toggle = false;
    }
  }

  // TODO: implement this function to set the double solenoid to the forward position
  // Params: none
  // Return: this function returns void
  public void extendIntake() {
    intakeSolenoid.set(Value.kForward);
  }

  // TODO: implement this function to set the double solenoid to the reverse position
  // Params: none
  // Return: this function returns void
  public void retractIntake() {
    intakeSolenoid.set(Value.kReverse);
  }

  public void stopIntake() {
    intakeSolenoid.set(Value.kOff);
  }

  @Override
  public void periodic() {
    intakeSolenoid.updateInputs(sInputs);
    compressor.updateInputs(cInputs);

    Logger.processInputs("DoubleSolenoid", sInputs);
    Logger.processInputs("Compressor", cInputs);
    // This method will be called once per scheduler run
  }
}
