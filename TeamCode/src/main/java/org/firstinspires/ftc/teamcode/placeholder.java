package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp (name="placeholder")
public class placeholder extends OpMode {
    private DcMotor leftfront;
    private DcMotor rightfront;
    private DcMotor leftrear;
    private DcMotor rightrear;

    @Override
    public void init() {
        leftfront = hardwareMap.get(DcMotor.class, "left front");
        rightfront = hardwareMap.get(DcMotor.class, "right front");
        leftrear = hardwareMap.get(DcMotor.class, "left rear");
        rightrear = hardwareMap.get(DcMotor.class, "right rear");
        rightfront.setDirection(DcMotorSimple.Direction.REVERSE);
    }

@Override
public void loop() {
    double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
    double x = gamepad1.left_stick_x;
    double rx = gamepad1.right_stick_x;

    leftfront.setPower(y + x + rx);
    leftrear.setPower(y - x + rx);
    rightfront.setPower(y - x - rx);
    rightrear.setPower(y + x - rx);
if (gamepad1.aWasPressed()){
    leftfront.setPower(-y + x + rx);
    leftrear.setPower(-y - x + rx);
    rightfront.setPower(-y - x - rx);
    rightrear.setPower(-y + x - rx);
}
if (gamepad1.aWasReleased()){
    leftfront.setPower(y + x + rx);
    leftrear.setPower(y - x + rx);
    rightfront.setPower(y - x - rx);
    rightrear.setPower(y + x - rx);
}
if (gamepad1.bWasPressed()){
    leftfront.setPower(0.0);
    leftrear.setPower(0.0);
    rightfront.setPower(0.0);
    rightrear.setPower(0.0);
}
 if (gamepad1.xWasPressed()){
     leftfront.setPower(y + x + rx);
     leftrear.setPower(y - x + rx);
     rightfront.setPower(y - x - rx);
     rightrear.setPower(y + x - rx);
 }
//if (gamepad1.left_stick_x <= -0.5) {
//rightfront.setPower(1);
//leftfront.setPower(-1);
//leftrear.setPower(1);
//rightrear.setPower(-1);
//}
//if (gamepad1.left_stick_x >= 0.5) {
//rightfront.setPower(-1);
//leftfront.setPower(1);
//leftrear.setPower(-1);
//rightrear.setPower(1);
//}
//if (gamepad1.right_stick_x <= -0.5) {
//rightfront.setPower(1);
//leftfront.setPower(-1);
//leftrear.setPower(1);
//rightrear.setPower(-1);
//}
//if (gamepad1.right_stick_x >= 0.5) {
//rightfront.setPower(1);
//leftfront.setPower(-1);
//leftrear.setPower(1);
//rightrear.setPower(-1);
//}
//if (gamepad1.right_stick_y <= -0.5) {
//    rightfront.setPower(-1);
//    leftfront.setPower(-1);
//    leftrear.setPower(-1);
//    rightrear.setPower(-1);
//}
// if (gamepad1.right_stick_y >= 0.5) {
//rightfront.setPower(1);
//leftfront.setPower(1);
//leftrear.setPower(1);
//rightrear.setPower(1);
//        }
//        if (gamepad1.right_stick_x == 0) {
//            if (gamepad1.left_stick_y == 0) {
//                if (gamepad1.left_stick_x == 0) {
//                    rightfront.setPower(0);
//                    leftfront.setPower(0);
//                    leftrear.setPower(0);
//                    rightrear.setPower(0);
//                }
//            }
//
//        }
//
                            }
                        }



