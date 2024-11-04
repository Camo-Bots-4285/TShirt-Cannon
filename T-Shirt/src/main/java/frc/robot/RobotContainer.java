package main.java.frc.robot;

import frc.robot.subsystems.*;
import frc.robot.Constants.*;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.*;



public class RobotContainer {
    public static TankDriveSubsytem m_TankDrive = new TankDrive();
    
    private final Joystick driverJoystick;
      /* Parent Class */
  private final Robot m_robot;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer(Robot robot) {
    m_robot = robot;

    // Defines what port of the compter each controler will be located in
    driverJoystick = new Joystick(0);
    m_tankdrive.setDefaultCommand(
        new TeleopTank(
            m_TankDrive,
            () -> (driverJoystick.getRawAxis(Controller.translationAxis)),
            () -> (driverJoystick.getRawAxis(Controller.strafeAxis))
        ));
}

  public Joystick getJoystick() {
    return driverJoystick;
  }
}
