// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.flywheel;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {
  private final FlywheelIO io;
  private final FlywheelIOInputsAutoLogged inputs = new FlywheelIOInputsAutoLogged();
  /** Creates a new Flywheel. */
  // TODO: implement this constructor to instantiate the io objects
  // Params: fill in the function parameters as needed by the implementation above
  public Flywheel (FlywheelIO io) {
    this.io = io;
  }

  public double getVelocity() {
    return inputs.velocity;
  }

  // TODO: implement this function to stop the flywheel
  // Param: none
  // Return: this function returns void
  public void stopFlywheel() {
    io.stop();
  }

  // TODO: implement this function to set the velocity of the flywheel to a given velocity then Log the target
  //       velocity value (see periodic function for hint on how to log)
  // Param: the velocity the flywheel will be set to
  // Return: this function returns void
  public void setFlywheelVelocity(double velocity) {
    io.setVelocity(velocity);
  }

  // TODO: implement this function to set the flywheel to a given voltage
  // Param: fill in the parameters as needed by the implementation above
  // Return: this function returns void
  public void setFlywheelVoltage(double voltage) {
    io.setVoltage(voltage);
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);

    Logger.processInputs("Flywheel", inputs);

    Logger.recordOutput("Flywheel Speed", getVelocity());
    // This method will be called once per scheduler run
  }
}
