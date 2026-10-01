package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;


@Autonomous(name = "PinpointOdoTest")
public class PinpointOdotest extends LinearOpMode{
GoBildaPinpointDriver pinpoint;

public void runOpMode() {
    pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
    pinpoint.setOffsets(0, 0, DistanceUnit.INCH);
    pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

    pinpoint.resetPosAndIMU();
    waitForStart();

    while (opModeIsActive()) {
        pinpoint.update();

        Pose2D pose = pinpoint.getPosition();
        telemetry.addData("X position for Inches", pose.getX(DistanceUnit.INCH));
        telemetry.addData("Y position for Inches", pose.getY(DistanceUnit.INCH));
        telemetry.addData("Heading (DEG)", pinpoint.getHeading(AngleUnit.DEGREES));

        telemetry.addData("Paralell encoder ticks", pinpoint.getEncoderX());
        telemetry.addData("Perpendicular Encoder ticks", pinpoint.getEncoderY());
        telemetry.update();
     }
    }
}
