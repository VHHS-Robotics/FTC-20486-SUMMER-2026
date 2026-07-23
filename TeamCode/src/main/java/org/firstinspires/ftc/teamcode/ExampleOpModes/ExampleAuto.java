package org.firstinspires.ftc.teamcode.ExampleOpModes;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class ExampleAuto extends OpMode {

    DcMotor front_left,front_right,back_left,back_right;
    public Follower follower;
    public Paths path;
    @Override
    public void init() {
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        follower = Constants.createFollower(hardwareMap);
        Paths paths = new Paths(follower);
    }

    @Override
    public void loop() {
        if (!follower.isBusy()) {
            follower.followPath(path.MainChain);
        }
    }



    public static class Paths {
        public PathChain MainChain;

        public Paths(Follower follower) {
            MainChain = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(56.000, 8.000),
                                    new Pose(56.000, 36.000)
                            )
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(56.000, 36.000),
                                    new Pose(16.109, 35.305)
                            )
                    )
                    .setTangentHeadingInterpolation()
                    .addPath(
                            new BezierCurve(
                                    new Pose(16.109, 35.305),
                                    new Pose(33.543, 6.990),
                                    new Pose(56.000, 8.000)
                            )
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(90))
                    .build();
        }
    }
}
