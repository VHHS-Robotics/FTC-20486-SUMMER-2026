
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains a minimal example of an iterative (Non-Linear) "OpMode". An OpMode is a
 * 'program' that runs in either the autonomous or the TeleOp period of an FTC match. The names
 * of OpModes appear on the menu of the FTC Driver Station. When an selection is made from the
 * menu, the corresponding OpMode class is instantiated on the Robot Controller and executed.
 *
 * Remove the @Disabled annotation on the next line or two (if present) to add this OpMode to the
 * Driver Station OpMode list, or add a @Disabled annotation to prevent this OpMode from being
 * added to the Driver Station.
 */
@Autonomous(name = "LimeLightTest")
public class LimeLightTest extends OpMode {
    /* Declare OpMode members. */
    private HuskyLens camera;
    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;

    public enum direction {
        Left,
        Right,
        Forward,
        Back,
        TurnL,
        TurnR
    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");


        
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        
        
        front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        front_right.setDirection(DcMotorSimple.Direction.FORWARD);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        
        telemetry.update();
    }
    

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }
     

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        //Old auto code for huskey lens
//        if(objectID == 1){
//            telemetry.addData("object detected",  String.valueOf(objectID));
//        }
//
//        if(xCenter < 140){
//            telemetry.addData("Move: ", "Left");
//            drive(0.2, 0.5, direction.Left);
//        }
//        else if(xCenter > 180){
//            telemetry.addData("Move: ", "Right");
//            drive(0.2, 0.5, direction.Right);
//        }else if(xCenter >= 140 && xCenter <= 180){
//            telemetry.addData("Move: ", "Forward(Centered)");
//            drive(0.3, 0.5, direction.Forward);
//        } else{
//            telemetry.addData("Move: ", "Turn(No object detected)");
//            drive(0.3, 0.5, direction.TurnL);
//            drive(0.3, 0.5, direction.TurnR);
//
//        }
        //then do something

    }

    /**
     * Drive left for a specific period of time
     * @param maxPower max Power ranging from 0-1
     * @param time to run 
     * @param dir direction to drive
     * 
     * TIME DOES NOT WORK RIGHT NOW BECAUSE I FORGOT HOW TO RUN ASYNC WITHOUT BUKKIT
     * PLS ADD LINTING :3
     **/
    public void drive(double maxPower, double time, direction dir) {
        ElapsedTime timer = new ElapsedTime();
        timer.reset(); //reset timer back to 0 and start it
        
        double mili = time * 1000; //convert time parameter to miliseconds
        
        while (timer.milliseconds() < mili) {
            
            telemetry.addData("direction", dir);

            telemetry.update();
            
            //actually drive based on dir
            switch (dir) {
                case Forward:
                    front_left.setPower(maxPower);
                    front_right.setPower(maxPower);
                    back_left.setPower(maxPower);
                    back_right.setPower(maxPower);
                    break;
                case Back:
                    front_left.setPower(-maxPower);
                    front_right.setPower(-maxPower);
                    back_left.setPower(-maxPower);
                    back_right.setPower(-maxPower);
                    break;
                case Left:
                    front_left.setPower(-maxPower);
                    front_right.setPower(maxPower);
                    back_left.setPower(maxPower);
                    back_right.setPower(-maxPower);
                    break;
                case Right:
                    front_left.setPower(maxPower);
                    front_right.setPower(-maxPower);
                    back_left.setPower(-maxPower);
                    back_right.setPower(maxPower);
                    break;
                case TurnL:
                    front_left.setPower(-maxPower);
                    front_right.setPower(maxPower);
                    back_left.setPower(-maxPower);
                    back_right.setPower(maxPower);
                    break;
                case TurnR:
                    front_left.setPower(maxPower);
                    front_right.setPower(-maxPower);
                    back_left.setPower(maxPower);
                    back_right.setPower(-maxPower);
                    break;
            }
        }
        front_left.setPower(0);
        front_right.setPower(0);
        back_left.setPower(0);
        back_right.setPower(0);

    }
    
    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
}
