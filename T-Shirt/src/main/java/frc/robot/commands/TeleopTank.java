package main.java.frc.commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.TankConstants;
import frc.robot.Robot;


public class TeleopTank extends Command {
  /*
   * Teleoperated Tank Drive Command
   * ---------------------------------
   * 
   * This command hooks up to the Tank Drive subsystem
   * and passes in our joystick inputs into it.
   */

  private final TankBase drive;

  /*
   * Joysticks return DoubleSuppliers when the get methods are called
   * This is so that joystick getter methods can be passed in as a parameter but
   * will continuously update,
   * versus using a double which would only update when the constructor is called
   */
  private final DoubleSupplier forwardLeft;
  private final DoubleSupplier forwardRight;
  private final DoubleSupplier speedchange;
  private final SlewRateLimiter LeftLimiter, RightLimiter;
  public static double fwdLeft;
  public static double fwdRight;


  public TeleopTank(
      TankBase subsystem,
      DoubleSupplier fwdLeft,
      DoubleSupplier fwdRight
    ) {

    drive = subsystem;
    forwardLeft = fwdLeft;
    forwardRight = fwdRight;
  



    this.LeftLimiter = new SlewRateLimiter(TankConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
    this.RightLimiter = new SlewRateLimiter(TankConstants.kTeleDriveMaxAccelerationUnitsPerSecond);


    addRequirements(subsystem);
  }

  @Override
  public void execute() {
        // System.out.println(fwdLeft);
        // System.out.println(fwdRight);
if (TankBase.AllowMainDriving == true){
   
    /*
     * Units are given in meters per second radians per second. Since joysticks give output
     * from -1 to 1, we multiply the outputs by the max speed. Otherwise, our max speed
     * would be only 1 meter per second and 1 radian per second.
     */
   
    fwdLeft = forwardLeft.getAsDouble();
    fwdRight = forwardRight.getAsDouble();
   
    
    // 2. Apply deadband/deadzone, can edit this later to have smoother behavior
    //If velocity is less then number it will be set to zero need to tune these value with driver
    fwdLeft = Math.abs(fwdLeft) > 0.1 ? fwdLeft : 0.0; 
    fwdRight = Math.abs(fwdRight) > 0.04 ? fwdRight : 0.0;//0.1
    

    // 3. Make the driving smoother this will set max velocity in teleop 
    //There should be three setting that are programed in normal and other two are activated by buttons 
    //superfast and superslow(should be pared with high amps if push needed)
    fwdLeft = LeftLimiter.calculate(fwdLeft) * TankConstants.kTeleDriveMaxSpeedMetersPerSecond;
    fwdRight = RightLimiter.calculate(fwdRight) * TankConstants.kTeleDriveMaxSpeedMetersPerSecond;

 
    drive.drive(
        -fwdLeft,
        -fwdRight
       
      );
}
  }
}

