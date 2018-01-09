package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.RobotMap;
import org.usfirst.frc.team1277.robot.commands.Drive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {

    private final SpeedController lMotor = RobotMap.driveTrainLeft; 
    private final SpeedController rMotor = RobotMap.driveTrainRight;
    
    //private double currentDirection = 0, previousDirection = 0;
    
    //Rotational speed is the amount of degrees rotated each clock cycle at max speed
    //Correction extremity affects the correlation between how far off the rotation is and the amount of power given
    
    public DriveTrain(){
    	
    }
    
    public void drive(double move, double rotate) {
    	double greatestControl, greatestSpeed;
    	
    	//Preliminary calculations
    	greatestControl = Math.max(Math.abs(move), Math.abs(rotate));
    	greatestSpeed = Math.max(Math.abs(-move - rotate), Math.abs(move - rotate));
    	//if(greatestSpeed == 0) greatestSpeed = 0.1;
    	
    	//Dashboard
    	SmartDashboard.putNumber("Foward", move);
    	SmartDashboard.putNumber("Turn", rotate);
    	SmartDashboard.putNumber("Facing", OI.getAhrs().getAngle());
    	
    	//Drive the motors
    	lMotor.set((move + rotate)* greatestControl / greatestSpeed);
    	rMotor.set((-move + rotate)* greatestControl / greatestSpeed);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
    /*
	public double getCurrentDirection() {
		return currentDirection;
	}

	public void setDesiredDirection(double desiredDirection) {
		this.desiredDirection = desiredDirection;
	}
	public void setCurrentDirection(double currentDirection) {
		this.currentDirection = currentDirection;
	}*/
}