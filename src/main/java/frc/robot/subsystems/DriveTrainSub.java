// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import frc.robot.Constants;

public class DriveTrainSub extends SubsystemBase {
  /** Creates a new DriveTrainSub. */
  private WPI_VictorSPX rightMotor1;
  private WPI_VictorSPX rightMotor2;
  private WPI_VictorSPX leftMotor1;
  private WPI_VictorSPX leftMotor2;

  public DriveTrainSub() {
    rightMotor1 = new WPI_VictorSPX(Constants.RIGHT_MOTOR_1);
    rightMotor2 = new WPI_VictorSPX(Constants.RIGHT_MOTOR_2);
    leftMotor1 = new WPI_VictorSPX(Constants.LEFT_MOTOR_1);
    leftMotor2 = new WPI_VictorSPX(Constants.LEFT_MOTOR_2);

    rightMotor1.configFactoryDefault();
    rightMotor2.configFactoryDefault();
    leftMotor1.configFactoryDefault();
    leftMotor2.configFactoryDefault();

    rightMotor1.setInverted(true);
    leftMotor1.setInverted(false);

    rightMotor2.follow(rightMotor1);
    leftMotor2.follow(leftMotor1);
  }

  public void setRightMotors(double power) {
    rightMotor1.set(VictorSPXControlMode.PercentOutput, power);
  }

  public void setLeftMotor(double power) {
    leftMotor1.set(VictorSPXControlMode.PercentOutput, power);
  }

  public void stopMotors() {
    rightMotor1.neutralOutput();
    leftMotor1.neutralOutput();
  }

  public void setArcadeDrive(double forwardPower, double turnPower) {
    setRightMotors(forwardPower - turnPower);
    setLeftMotor(forwardPower +  turnPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
