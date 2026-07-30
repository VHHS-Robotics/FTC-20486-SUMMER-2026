package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Practis" )
public class Practis extends OpMode {
    private DcMotor LF;
    private DcMotor RF;
    private DcMotor LR;
    private DcMotor RR;


    @Override
    public void init() {
        LF = hardwareMap.get(DcMotor.class, "left front");
        RF = hardwareMap.get(DcMotor.class, "right front");
        LR = hardwareMap.get(DcMotor.class, "left rear");
        RR = hardwareMap.get(DcMotor.class, "right rear");

        RR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_x <= -0.5) {
            RF.setPower(1);
            RR.setPower(1);
            LF.setPower(-1);
            LR.setPower(-1);
        } else if (gamepad1.left_stick_x >= 0.5) {
                RF.setPower(-1);
                RR.setPower(-1);
                LF.setPower(1);
                LR.setPower(1);
            } else if (gamepad1.right_stick_x >= 0.5) {
                    RF.setPower(-1);
                    RR.setPower(1);
                    LF.setPower(1);
                    LR.setPower(-1);
                } else if (gamepad1.right_stick_x <= -0.5) {
                        RF.setPower(1);
                        RR.setPower(-1);
                        LF.setPower(-1);
                        LR.setPower(1);
                    } else if (gamepad1.right_stick_y >= 0.5) {
                            RF.setPower(1);
                            RR.setPower(1);
                            LF.setPower(1);
                            LR.setPower(1);
                        } else if (gamepad1.right_stick_y <= -0.5) {
                                RF.setPower(-1);
                                RR.setPower(-1);
                                LF.setPower(-1);
                                LR.setPower(-1);
                            } else {
                                RF.setPower(0);
                                RR.setPower(0);
                                LF.setPower(0);
                                LR.setPower(0);
        }
    }
}