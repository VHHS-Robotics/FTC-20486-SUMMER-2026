package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; // Required if extending LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;       // Required for the @TeleOp annotation
import com.qualcomm.robotcore.eventloop.opmode.Disabled;     // Optional: Use @Disabled to hide from the Driver Station
import com.qualcomm.robotcore.hardware.DcMotor;       // For standard DC motors (drive train, lifts, etc.)
import com.qualcomm.robotcore.hardware.DcMotorSimple; // Useful for mapping motor directions (e.g., REVERSE)
import com.qualcomm.robotcore.hardware.Servo;         // For standard 180-degree servos
import com.qualcomm.robotcore.hardware.CRServo;       // For continuous rotation servos
import com.qualcomm.robotcore.hardware.ColorSensor;   // For color sensors
import com.qualcomm.robotcore.hardware.DistanceSensor;// For distance sensors
import com.qualcomm.robotcore.hardware.TouchSensor;   // For limit switches and touch buttons

class TellyOp{
    private DcMotor Right;
    private DcMotor Left;

        Right = hardwareMap.get(DcMotor.class, "Right");
        Left = hardwareMap.get(DcMotor.class, "Left");

    double L1 = gamepad1.left_stick_y;
    double R1 = gamepad.right_stick_x;

    Right.power(L1 - R1);
    Left.power(L1 + R1);
        }