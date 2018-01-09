package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Dispenser extends Subsystem {
	
	private final Servo servo = RobotMap.servo;

	public void open() {
		servo.set(0.65f);
	}
	
	public void close() {
		servo.set(0.5f);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
