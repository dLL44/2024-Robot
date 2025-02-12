// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyroscope extends SubsystemBase {
    AHRS gyro;

    public Gyroscope() {
        SmartDashboard.putNumber("Gyroscope (Degrees)", 0);
        try {
            gyro = new AHRS(SPI.Port.kMXP); 
            SmartDashboard.putBoolean("Gyro", true);
        } 
        catch (RuntimeException ex ) {
            SmartDashboard.putBoolean("Gyro", false);
        }
        gyro.reset();
    }

  public double getYaw() {
    return gyro.getAngle();
  }

  public double getPitch() {
    return gyro.getRoll();
  }
  public double getRoll() {
    return gyro.getPitch();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Gyroscope Pitch", getPitch());
    SmartDashboard.putNumber("Gyroscope Roll", getRoll());
    SmartDashboard.putNumber("Gyroscope Yaw", getYaw());

  }
}