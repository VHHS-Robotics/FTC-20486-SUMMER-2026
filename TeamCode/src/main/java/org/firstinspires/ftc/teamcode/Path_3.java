package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Path_3" )
public class Path_3 extends OpMode {

    private DcMotor L;
    private DcMotor R;


    @Override
    public void init() {
        L = hardwareMap.get(DcMotor.class, "left");
        R = hardwareMap.get(DcMotor.class, "right");
    }

    @Override
    public void loop() {
        R.setPower(2);
        L.setPower(2);
    }
}