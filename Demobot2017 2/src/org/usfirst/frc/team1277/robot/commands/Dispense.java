package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Dispense extends Command {

	private int counter;
	
	public Dispense() {
		requires(Robot.dispenser);
	}


    // Called just before this Command runs the first time
    protected void initialize() {
    	counter = 0;
    	Robot.dispenser.open();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	counter ++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(counter >= 10) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.dispenser.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.dispenser.close();
    }

}
