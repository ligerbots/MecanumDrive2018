package org.usfirst.frc.team2877.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2877.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    CANTalon talon1;
    CANTalon talon2;
    CANTalon talon3;
    CANTalon talon4;
    RobotDrive robotDrive;
    AHRS navx;

    
    public DriveTrain() {
        
        talon1 = new CANTalon(RobotMap.CT_1);
        talon2 = new CANTalon(RobotMap.CT_2);
        talon3 = new CANTalon(RobotMap.CT_3);
        talon4 = new CANTalon(RobotMap.CT_4);
        
        talon1.changeControlMode(TalonControlMode.PercentVbus);
        talon2.changeControlMode(TalonControlMode.PercentVbus);
        talon3.changeControlMode(TalonControlMode.PercentVbus);
        talon4.changeControlMode(TalonControlMode.PercentVbus);

        robotDrive = new RobotDrive(talon1, talon2, talon3, talon4);
        
        navx = new AHRS(SPI.Port.kMXP);

    }
    
    public void MecanumDrive(double forward, double strafe, double rotate, double gyroAngle) {
        robotDrive.mecanumDrive_Cartesian(strafe, forward, rotate, gyroAngle);
    }
    
    public double getYaw() {
        return navx.getYaw();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

