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

import org.usfirst.frc2832.Robot2017.autonCommands.AutonCommandGroup;
import org.usfirst.frc2832.Robot2017.autonCommands.ParseInput;
import org.usfirst.frc2832.Robot2017.commands.Climb;
import org.usfirst.frc2832.Robot2017.commands.InterfaceFlip;
import org.usfirst.frc2832.Robot2017.commands.shooter.ShooterSequenceOff;
//import org.usfirst.frc2832.Robot2017.pixy.PixyException;
//import org.usfirst.frc2832.Robot2017.pixy.PixyI2C;
//import org.usfirst.frc2832.Robot2017.pixy.PixyPacket;
import org.usfirst.frc2832.Robot2017.subsystems.BallIntake;
import org.usfirst.frc2832.Robot2017.subsystems.Climbing;
import org.usfirst.frc2832.Robot2017.subsystems.DriveTrain;
import org.usfirst.frc2832.Robot2017.subsystems.GearIntake;
import org.usfirst.frc2832.Robot2017.subsystems.GearScore;
import org.usfirst.frc2832.Robot2017.subsystems.Lights;
import org.usfirst.frc2832.Robot2017.subsystems.NavX;
import org.usfirst.frc2832.Robot2017.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
//robot code
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static BallIntake ballIntake;
    public static Climbing climb;
    public static GearIntake gearIntake;
    public static GearScore gearScore;
    public static Shooter shooter;
    public static Lights lights;
    public static boolean isClimbing = false;
    public static boolean isIngesting = false;
    public static boolean povActivated = false;
    public static boolean shootMethod1 = true;
    public static NavX navX;
    public static double lTrigger, rTrigger;
    //public static PixyI2C testPixy;
    public static int shootSpeeed = 70, pov;
    //public static AnalogInput ultraSonic;
    public static DigitalInput distSensor;
    //public static AnalogInput pixyInput;
    //public static AnalogInput pixyWidth;
    public static SendableChooser<String> auto;
    public static PowerDistributionPanel pdp;
    public static int camera = 0;
 
    public static I2C pixyCamera;
    public static Port port;
    public static byte[] buffer;
    public static int pixyValue;

    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	setBrakeMode(false);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        navX = new NavX();

    	//ultraSonic = new AnalogInput(0);
    	distSensor = new DigitalInput(0);
    	//pixyInput = new AnalogInput(1);
    	//pixyWidth = new AnalogInput(2);
    	port = Port.kOnboard;
    	pixyCamera = new I2C(port, 63);// 42);
    	pixyValue = (byte) 300;
    	buffer = new byte[1];
    	
    	
  //  	lights = new Lights();
    
    	
 //   	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//	    camera.setResolution(360, 240);
	    
	    /* TODO: commenting out all this extra stuff 
     	if (camera.isConnected() == true) {
     		
     		new Thread(() -> {
 		        	
 			        CvSink cvSink = CameraServer.getInstance().getVideo();
 			        CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
 			        
 			        Mat source = new Mat();
 			        Mat output = new Mat();
 			        
 			        while(true) {
 			        	//System.out.println("Camera1 is connected");
 			            cvSink.grabFrame(source);
 			            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
 			            outputStream.putFrame(output);
 			        }
 			        
     		}).start();
     		
     	}
	    */ 	
	     /*	UsbCamera cameraTwo = CameraServer.getInstance().startAutomaticCapture();
	     	cameraTwo.setResolution(320, 240);
	     	
	     	if (cameraTwo.isConnected() == true) {
	     		
	     		new Thread(() -> {
	 		        	
	 			        CvSink cvSink = CameraServer.getInstance().getVideo();
	 			        CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	 			        
	 			        Mat source = new Mat();
	 			        Mat output = new Mat();
				        
	 			        while(true) {
	 			        	System.out.println("Camera2 is conncted");
	 			            cvSink.grabFrame(source);
	 			            Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
	 			            outputStream.putFrame(output);
	 			        }
	 			        
	     		}).start();
	     	}
        */
	    
	    new Thread(() -> {
	    	UsbCamera c0 = CameraServer.getInstance().startAutomaticCapture(0);
	    	UsbCamera c1 = CameraServer.getInstance().startAutomaticCapture(1);
	    	while(true) {
	    		if(camera == 0) {
	    			NetworkTable.getTable("").putString("c", c0.getName());
	    		} else {
	    			NetworkTable.getTable("").putString("c", c1.getName());
	    		}
	    		try {
					Thread.sleep(20);
				} catch (InterruptedException e) {

				}
	    	}
	    }).start();

        driveTrain = new DriveTrain();
        ballIntake = new BallIntake();
        climb = new Climbing();
        gearIntake = new GearIntake();
        gearScore = new GearScore();
        shooter = new Shooter();
        lights = new Lights();
       // testPixy = new PixyI2C();
     
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        pdp = new PowerDistributionPanel();
        
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        auto = new SendableChooser<String>();
        auto.addDefault("Do nothing at all", "0");
        auto.addObject("Expel Gear from Center (practice bot)", "e9");
        auto.addObject("Expel Gear from Center (actual bot)", "d6"); //4 = 80 in for practice bot
        auto.addObject("Drive Forward from left or right position (practice bot)", "c5");
        auto.addObject("Drive Forward from left or right position (actual bot)", "b4");
        auto.addObject("Expel Gear From left NavX(practice bot)", "h3");
        auto.addObject("Expel Gear From left NavX(actual bot)", "g3");
        auto.addObject("Expel Gear From right NavX(practice bot)", "i3");
        auto.addObject("Expel Gear From right NavX(actual bot)", "a3");
        auto.addObject("autonAimGear", "j7");
     
        
        SmartDashboard.putData("Autonomous Selection", auto);
        autonomousCommand = ((CommandGroup) new AutonCommandGroup (ParseInput.takeInput((String) auto.getSelected())));

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	GearScore.gearScoreDoor.set(DoubleSolenoid.Value.kForward);
    	setBrakeMode(false);
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	 
    	setBrakeMode(true);
        // schedule the autonomous command (example)
    	//next two lines of code work for now, but we'll probably want to replace them with a more 
    	//elegant way of selecting the auton mode we want from the smart dashboard 
    	DriveEncoders.intializeEncoders();
    	RobotMap.driveTrainRightFront.setPosition(0);
    	RobotMap.driveTrainLeftFront.setPosition(0);
    	System.out.print(auto.getSelected());
    	autonomousCommand = (CommandGroup)new AutonCommandGroup (ParseInput.takeInput((String)auto.getSelected())); 
       
    	if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if (! Robot.pixyCamera.read(0, 1, buffer))
    		pixyValue =  buffer[0] & 0xFF;
    		
        SmartDashboard.putNumber("Pixy X value", pixyValue  );
        
       
        
     

    }

    public void teleopInit() {
    	
    	DriveEncoders.intializeEncoders();
    	GearScore.gearScoreDoor.set(DoubleSolenoid.Value.kForward);
    	setBrakeMode(true);
    	InterfaceFlip.isFlipped = false;
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if (! Robot.pixyCamera.read(0, 1, buffer))
        	pixyValue =  buffer[0] & 0xFF;
		
        SmartDashboard.putNumber("Pixy X value", pixyValue  );
       // SmartDashboard.putNumber("Analog dist", Math.round(ultraSonic.getAverageVoltage() * 1000 / 9.8));
       // SmartDashboard.putBoolean("Digital", !distSensor.get());
     
        //SmartDashboard.putNumber("LeftFront Current", pdp.getCurrent(14));
        //SmartDashboard.putNumber("LeftRear Current", pdp.getCurrent(15));
        //SmartDashboard.putNumber("RightFront Current", pdp.getCurrent(0));
        //SmartDashboard.putNumber("RightRear Current", pdp.getCurrent(1));
        SmartDashboard.putBoolean("IsIngesting", isIngesting);
     
        SmartDashboard.putNumber("Right Encoder", DriveEncoders.getRawRightValue());
        SmartDashboard.putNumber("Left Encoder", DriveEncoders.getRawLeftValue());
        SmartDashboard.putNumber("Encoder Differences", DriveEncoders.getRawEncDifference());
        
        //SmartDashboard.putData("SensorForward", new SensorForward());
        //SmartDashboard.putData("DriveBackward", new DriveBackward());
       // SmartDashboard.putNumber("Is Door Open", GearScore.gearScoreDoor.get());
        SmartDashboard.putNumber("Accelerometer", NavX.ahrs.getWorldLinearAccelY());
        SmartDashboard.putBoolean("IMU_Connected", NavX.ahrs.isConnected());
        SmartDashboard.putNumber("IMU_Yaw", NavX.ahrs.getYaw());
   
        
        
        lTrigger = oi.getXBoxController().getRawAxis(2);
        rTrigger = oi.getXBoxController().getRawAxis(3);
        pov = oi.getXBoxController().getPOV(0);
        
        /* Climbing control - variable on Left Trigger */
        if(lTrigger > 0.1)
        	new Climb().start();
        
        /* Shooting Balls - Right Trigger */
        if(rTrigger > 0.1) {
        	if(shootMethod1) {
        		shooter.trigger();
        	} else {
        		//new Shoot();
        	}
        } else {
        	new ShooterSequenceOff().start();
        }
        
        if (isIngesting) {
    		BallIntake.ballIntakeMotor.set(0.3);
    	} else {
    		BallIntake.ballIntakeMotor.set(0);
    	}
        
        /* Allow adjusting Speed of Shooter Motor to test distance */
        //if(pov == -1) {
       	//	povActivated = false;
        //} else {
        	if (pov != -1)
        		if(pov > 90 && pov < 270) {
        			shootSpeeed--;
        		} else {
        			shootSpeeed++;
        		}
        				
        //}
        SmartDashboard.putNumber("Shooting speeed", shootSpeeed);
   /*     
     try {
        	
        	PixyPacket example1 = testPixy.readPacket(1);
        	PixyPacket example2 = testPixy.readPacket(1);
        	if (example1 != null){
        		
        		SmartDashboard.putNumber("height 1", example1.Height);
	        	SmartDashboard.putNumber("width 1", example1.Width);
	        	SmartDashboard.putNumber("x 1", example1.X);
	        	SmartDashboard.putNumber("y 1", example1.Y);
        	}
        	if (example2 != null){
        		
        		SmartDashboard.putNumber("height 2", example2.Height);
	        	SmartDashboard.putNumber("width 2", example2.Width);
	        	SmartDashboard.putNumber("x 2", example2.X);
	        	SmartDashboard.putNumber("y 2", example2.Y);
        	}
     	}
         catch (PixyException e){
        	e.printStackTrace();
        }
       */

    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void setBrakeMode(boolean b) {
    	RobotMap.driveTrainLeftFront.enableBrakeMode(b);
    	RobotMap.driveTrainRightFront.enableBrakeMode(b);
    	RobotMap.driveTrainLeftRear.enableBrakeMode(b);
    	RobotMap.driveTrainRightRear.enableBrakeMode(b);
    }
}
