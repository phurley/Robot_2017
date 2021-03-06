// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2832.Robot2017;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainLeftFront;
    public static CANTalon driveTrainRightFront;
    public static CANTalon driveTrainLeftRear;
    public static CANTalon driveTrainRightRear;
    public static CANTalon climbMotor;
    public static DoubleSolenoid gearIntakeRamp;
    public static RobotDrive driveTrainRobotDrive41;
    public static Relay lightsLightEnable;
    public static Compressor compressor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	compressor = new Compressor();
    	
        driveTrainLeftFront = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "LeftFront", driveTrainLeftFront);
        driveTrainRightFront = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "RightFront", driveTrainRightFront);
        driveTrainLeftRear = new CANTalon(2);
        driveTrainLeftRear.changeControlMode(TalonControlMode.Follower);
        driveTrainLeftRear.set(driveTrainLeftFront.getDeviceID());
        LiveWindow.addActuator("DriveTrain", "LeftRear", driveTrainLeftRear);
        driveTrainRightRear = new CANTalon(4);
        driveTrainRightRear.changeControlMode(TalonControlMode.Follower);
        driveTrainRightRear.set(driveTrainRightFront.getDeviceID());
        driveTrainRightRear.reverseOutput(false);
        LiveWindow.addActuator("DriveTrain", "RightRear", driveTrainRightRear);
        
        driveTrainLeftFront.setInverted(true);
        driveTrainRightFront.setInverted(true);
        driveTrainLeftRear.setInverted(true);
        driveTrainRightRear.setInverted(true);
        
        driveTrainRobotDrive41 = new RobotDrive(driveTrainRightFront, driveTrainLeftFront);
		driveTrainRobotDrive41.setSafetyEnabled(true);
		driveTrainRobotDrive41.setExpiration(0.1);
		driveTrainRobotDrive41.setSensitivity(0.5);
		driveTrainRobotDrive41.setMaxOutput(1.0);
        
        climbMotor = new CANTalon(5);
        LiveWindow.addActuator("Climbing", "Motor", climbMotor);
        
        lightsLightEnable = new Relay(0);
        LiveWindow.addActuator("Lights", "LightEnable", lightsLightEnable);
        
        gearIntakeRamp = new DoubleSolenoid(1, 0);
        LiveWindow.addActuator("GearIntake", "IntakeRamp", gearIntakeRamp);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
