package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class placeholder extends OpMode{
    DcMotor leftfront;
    DcMotor rightfront;
    DcMotor leftrear;
    DcMotor rightrear;

    @Override
    public void init() {
    leftfront = hardwareMap.get(DcMotor.class, "leftfront");
    rightfront = hardwareMap.get(DcMotor.class,"rightfront");
    leftrear = hardwareMap.get(DcMotor.class, "leftrear");
    rightrear = hardwareMap.get(DcMotor.class, "rightrear");
    }

    @Override
    public void loop() {
    if (gamepad1.left_stick_x <=-0.5) {
        rightfront.setPower(1);
        leftfront.setPower(-1);
        leftrear.setPower(-1);
        rightrear.setPower(1);
    } else {
        if (gamepad2.right_stick_x <= 0.5) {
            rightfront.setPower(-1);
            leftfront.setPower(1);
            leftrear.setPower(1);
            rightrear.setPower(-1);
        } else {
            rightfront.setPower(0);
            leftfront.setPower(0);
            leftrear.setPower(0);
            rightrear.setPower(-0);
            if (gamepad2.left_stick_y <= -0.5){
                rightfront.setPower(-1);
                leftfront.setPower(-1);
                leftrear.setPower(-1);
                rightrear.setPower(-1);
        } else {
                if (gamepad2.right_stick_y <= 0.5) {
                    rightfront.setPower(1);
                    leftfront.setPower(1);
                    leftrear.setPower(1);
                    rightrear.setPower(1);
                } else {
                    if (gamepad2.right_stick_x <= -0.5) {
                        rightfront.setPower(1);
                        leftfront.setPower(-1);
                        leftrear.setPower(1);
                        rightrear.setPower(-1);
                    } else {
                        if (gamepad2.right_stick_x <= 0.5) {
                            rightfront.setPower(-1);
                            leftfront.setPower(1);
                            leftrear.setPower(-1);
                            rightrear.setPower(1);
                        }


                    }
                }
            }
            }
        }
    }
}
