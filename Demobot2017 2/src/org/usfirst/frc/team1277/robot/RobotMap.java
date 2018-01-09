package org.usfirst.frc.team1277.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Drive Motors
	public static SpeedController driveTrainLeft, driveTrainRight;
	
	//Shooter Motors and Encoder
	public static SpeedController shooterMotor, shooterLoader;
	public static Encoder encoder;
	
	//Dispenser Servo
	public static Servo servo;
	
	public static void init(){
		
		//Drive Motors
		driveTrainLeft = new Spark(0);
		driveTrainRight = new Spark(1);
		
		//Shooter Motors and Encoder
		shooterMotor = new Spark(2);
		shooterLoader = new Spark(3);
		encoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		encoder.setMaxPeriod(.5);
		encoder.setSamplesToAverage(3);
		
		//Dispenser Servo
		servo = new Servo(4);
	}
}
