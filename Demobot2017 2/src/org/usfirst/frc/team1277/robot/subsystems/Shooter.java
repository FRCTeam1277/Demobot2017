package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {
	
	private final SpeedController shooterMotor = RobotMap.shooterMotor;
	private final SpeedController loader = RobotMap.shooterLoader;
	//private final Encoder encoder = RobotMap.encoder;
	
	//private static double TARGET_SPEED = 1.0f, ERROR_MARGIN = 0.05f;
	//private double shooterPower = 0;
	
	public Shooter(){
		
	}
	
	public void shoot() {
		
		//Spin shooter
		shooterMotor.set(0.7f);		
		
		fire();
	}
	
	public void fire() {
		loader.set(1.0f);
	}
	
	public void ceasefire() {
		loader.set(0);
	}
	
	public void stop() {
		loader.set(0);
		shooterMotor.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
