package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {
	
	private static double MOVE_SPEED = 1.0f, ROTATE_SPEED = 1.0f, CONTROL_EXPONENT_MOVE = 1.0f, CONTROL_EXPONENT_ROTATE = 1.5f;
    private static double MOVE_DEADZONE = 0.025f, ROTATE_DEADZONE = 0.1f;

    public Drive() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	OI.getAhrs().zeroYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double move = -OI.getJoystick().getRawAxis(1), rotate = OI.getJoystick().getRawAxis(2);
    	
    	//Adjust for Move Deadzone
    	if (move >= MOVE_DEADZONE) move -= MOVE_DEADZONE;
    	else if (move <= -MOVE_DEADZONE) move += MOVE_DEADZONE;
    	else move = 0.0f;
    	move /= 1.0f - MOVE_DEADZONE;
    	
    	//Adjust for Rotate Deadzone
    	if (rotate >= ROTATE_DEADZONE) rotate -= ROTATE_DEADZONE;
    	else if (rotate <= -ROTATE_DEADZONE) rotate += ROTATE_DEADZONE;
    	else rotate = 0.0f;
    	rotate /= 1.0f - ROTATE_DEADZONE;
    	
    	//Exponential Adjustment
    	move *= Math.pow(Math.abs(move), CONTROL_EXPONENT_MOVE - 1.0f);
    	rotate *= Math.pow(Math.abs(rotate), CONTROL_EXPONENT_ROTATE - 1.0f);
    	
    	//Linear Adjustment for Maximum Speed
    	move *= MOVE_SPEED;
    	rotate *= ROTATE_SPEED;
    	
    	//Drive the Robot
    	Robot.driveTrain.drive(move, rotate);
    }

	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0,0);
    	//Robot.driveTrain.setDesiredDirection(Robot.driveTrain.getCurrentDirection());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.drive(0,0);
    }

    //Getters and Setters
    public static void setMOVE_DEADZONE(double mOVE_DEADZONE) {
		MOVE_DEADZONE = mOVE_DEADZONE;
	}

	public static void setROTATE_DEADZONE(double rOTATE_DEADZONE) {
		ROTATE_DEADZONE = rOTATE_DEADZONE;
	}
	
	public static void setMOVE_SPEED(double mOVE_SPEED) {
		MOVE_SPEED = mOVE_SPEED;
	}

	public static void setROTATE_SPEED(double rOTATE_SPEED) {
		ROTATE_SPEED = rOTATE_SPEED;
	}
   
	public static void setCONTROL_EXPONENT_MOVE(double cONTROL_EXPONENT_MOVE) {
		CONTROL_EXPONENT_MOVE = cONTROL_EXPONENT_MOVE;
	}

	public static void setCONTROL_EXPONENT_ROTATE(double cONTROL_EXPONENT_ROTATE) {
		CONTROL_EXPONENT_ROTATE = cONTROL_EXPONENT_ROTATE;
	}

}