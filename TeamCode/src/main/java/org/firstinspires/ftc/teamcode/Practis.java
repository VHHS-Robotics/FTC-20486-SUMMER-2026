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
        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        LR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double y = -gamepad1.right_stick_y; // Remember, Y stick is reversed!
        double x = gamepad1.right_stick_x;
        double rx = gamepad1.left_stick_x;

        LF.setPower(y + x + rx + y + x + rx);
        LR.setPower(y - x + rx + y - x + rx);
        RF.setPower(y - x - rx + y - x - rx);
        RR.setPower(y + x - rx + y + x - rx);

        if (gamepad1.left_stick_y > 0) {
            RR.setDirection(DcMotorSimple.Direction.FORWARD);
            LF.setDirection(DcMotorSimple.Direction.FORWARD);
            LR.setDirection(DcMotorSimple.Direction.FORWARD);
            RF.setDirection(DcMotorSimple.Direction.REVERSE);
        }
/*
        if (gamepad1.left_stick_x <= -0.5) {
            RF.setPower(1);
            RR.setPower(1);
            LF.setPower(-1);
            LR.setPower(-1);
        }
        if (gamepad1.left_stick_x >= 0.5) {
            RF.setPower(-1);
            RR.setPower(-1);
            LF.setPower(1);
            LR.setPower(1);
        }
        if (gamepad1.right_stick_x >= 0.5) {
            RF.setPower(-1);
            RR.setPower(1);
            LF.setPower(1);
            LR.setPower(-1);
        }
        if (gamepad1.right_stick_x <= -0.5) {
            RF.setPower(1);
            RR.setPower(-1);
            LF.setPower(-1);
            LR.setPower(1);
        }
        if (gamepad1.right_stick_y >= 0.5) {
            RF.setPower(-1);
            RR.setPower(-1);
            LF.setPower(-1);
            LR.setPower(-1);
        }
        if (gamepad1.right_stick_y <= -0.5) {
            RF.setPower(1);
            RR.setPower(1);
            LF.setPower(1);
            LR.setPower(1);
        }
            if (gamepad1.right_stick_y == 0) {
                if (gamepad1.right_stick_x == 0) {
                    if (gamepad1.left_stick_x == 0) {
                        RF.setPower(0);
                        RR.setPower(0);
                        LF.setPower(0);
                        LR.setPower(0);
                }
            }
        }*/
    }
}
