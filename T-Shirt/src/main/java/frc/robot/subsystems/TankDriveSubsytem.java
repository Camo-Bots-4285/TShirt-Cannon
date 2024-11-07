package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankDriveConstants;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;



public class TankDriveSubsytem extends SubsystemBase {  
  
   PWMSparkMax LeftTopDrive;
    PWMSparkMax LeftBottomDrive;
    PWMSparkMax RightTopDrive;
    PWMSparkMax RightBottomDrive;


  public TankDriveSubsytem() {
    LeftTopDrive = new PWMSparkMax(0);
    LeftBottomDrive = new PWMSparkMax(0);
    RightTopDrive = new PWMSparkMax(0);
    RightBottomDrive = new PWMSparkMax(0);

    LeftTopDrive.setInverted(false);
    LeftBottomDrive.setInverted(false);
    RightTopDrive.setInverted(false);
    RightBottomDrive.setInverted(false);


  }
  @Override
  public void periodic() {

   
    // SmartDashboard.putString("FL Wheel Angle", frontLeft.getCanCoderAngle().toString());
    // SmartDashboard.putString("FR Wheel Angle", frontRight.getCanCoderAngle().toString());
    // SmartDashboard.putString("RL Wheel Angle", rearLeft.getCanCoderAngle().toString());
    // SmartDashboard.putString("RR Wheel Angle", rearRight.getCanCoderAngle().toString());

    // SmartDashboard.putNumber("FL Wheel Speed",  frontLeft.getCurrentVelocityRadiansPerSecond()/(2*Math.PI)*SwerveConstants.wheelCircumference);
    // SmartDashboard.putNumber("FR Wheel Speed", frontRight.getCurrentVelocityRadiansPerSecond()/(2*Math.PI)*SwerveConstants.wheelCircumference);
    // SmartDashboard.putNumber("RL Wheel Speed", rearLeft.getCurrentVelocityRadiansPerSecond()/(2*Math.PI)*SwerveConstants.wheelCircumference);
    // SmartDashboard.putNumber("RR Wheel Speed", rearRight.getCurrentVelocityRadiansPerSecond()/(2*Math.PI)*SwerveConstants.wheelCircumference);

    // SmartDashboard.putNumber("FL Wheel Speed2", Math.round(frontLeft.getCurrentVelocityMetersPerSecond()));
    // SmartDashboard.putNumber("FR Wheel Speed2", Math.round(frontRight.getCurrentVelocityMetersPerSecond()));
    // SmartDashboard.putNumber("RL Wheel Speed2", Math.round(rearLeft.getCurrentVelocityMetersPerSecond()));
    // SmartDashboard.putNumber("RR Wheel Speed2", Math.round(rearRight.getCurrentVelocityMetersPerSecond()));
   
 }
  

  /**
   * method for driving the robot
   * Parameters:
   * forward linear value
   * sideways linear value
   * rotation value
   * if the control is field relative or robot relative
   */
  
  public void drive(double LeftSpeed,double RightSpeed) {

    /**
     * ChassisSpeeds object to represent the overall state of the robot
     * ChassisSpeeds takes a forward and sideways linear value and a rotational
     * value
     * 
     * speeds is set to field relative or default (robot relative) based on
     * parameter
     */
    
    
    double LeftMotorSpeed = LeftSpeed / TankDriveConstants.WHEEL_CIRCUMFERENCE* TankDriveConstants.GEAR_RATIO;
    double RightMotorSpeed = RightSpeed / TankDriveConstants.WHEEL_CIRCUMFERENCE* TankDriveConstants.GEAR_RATIO;

    LeftTopDrive.setVoltage(LeftMotorSpeed);
    LeftBottomDrive.setVoltage(LeftMotorSpeed);
    RightTopDrive.setVoltage(RightMotorSpeed);
    RightBottomDrive.setVoltage(RightMotorSpeed);
    }

    public void stop(){
    LeftTopDrive.stopMotor();
    LeftBottomDrive.stopMotor();
    RightTopDrive.stopMotor();
    RightBottomDrive.stopMotor();

    }
}


