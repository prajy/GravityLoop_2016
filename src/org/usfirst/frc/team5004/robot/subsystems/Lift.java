package org.usfirst.frc.team5004.robot.subsystems;

import org.usfirst.frc.team5004.robot.Robot;
import org.usfirst.frc.team5004.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lift extends Subsystem {
	
	public Lift(){
		super();
		
		LiveWindow.addActuator("Lift", "Lift Motor 1", (CANTalon) m1);
		LiveWindow.addActuator("Lift", "Lift Motor 2", (CANTalon) m2);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//local variables for joysticks
	//Joystick joystick = Robot.oi.joySecondary;
	
	//initialize motor controllers from port numbers
	CANTalon m1 = new CANTalon(RobotMap.liftMotor1);
	CANTalon m2 = new CANTalon(RobotMap.liftMotor2);
	
	public void init(){
		/*//tell motor m2 to follow m1
		m2.changeControlMode(TalonControlMode.Follower);
		m2.set(RobotMap.leftMotor1);*/
	}
	
	public void joystickControl(){
		//set motor speed to joystick value
		double value = (Robot.oi.joySecondary.getY());
		
		if(value < 0){ value = value / 5;}
		
		m1.set(value);
		m2.set(value);
	}
	
	public void stop(){
		m1.set(0.0);
		m2.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

