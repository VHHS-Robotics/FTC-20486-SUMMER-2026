package org.firstinspires.ftc.teamcode;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.bylazar.telemetry.PanelsTelemetry;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.pedropathing.geometry.Pose;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@Autonomous(name = "Isaac Pathing Autonomous", group = "Autonomous")
@Configurable // Panels
public class isaacPathing extends OpMode {
    private TelemetryManager panelsTelemetry; // Panels Telemetry instance
    public Follower follower; // Pedro Pathing follower instance
    private int pathState = 0; // Current autonomous path state (state machine)
    private Paths paths; // Paths defined in the Paths class

    @Override
    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(63.809, 14.507, Math.toRadians(90)));

        paths = new Paths(follower); // Build paths

        panelsTelemetry.debug("Status", "Initialized");
        panelsTelemetry.update(telemetry);
    }

    @Override
    public void loop() {
        follower.update(); // Update Pedro Pathing
        autonomousPathUpdate(); // Update autonomous state machine

        // Log values to Panels and Driver Station
        panelsTelemetry.debug("Path State", pathState);
        panelsTelemetry.debug("X", follower.getPose().getX());
        panelsTelemetry.debug("Y", follower.getPose().getY());
        panelsTelemetry.debug("Heading", follower.getPose().getHeading());
        panelsTelemetry.update(telemetry);
    }

    public static class Paths {
        public PathChain Start;
        public PathChain FirstLine;
        public PathChain SecondLine;
        public PathChain ThirdLine;
        public PathChain End;

        public Paths(Follower follower) {
            Start = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(63.809, 14.508),
                                    new Pose(47.07490144546648, 14.059132720105131)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .build();

            FirstLine = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(47.12290275675396, 35.409),
                                    new Pose(13.375, 35.381)
                            )
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(13.375, 35.381),
                                    new Pose(47.215, 35.381)
                            )
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .setReversed()
                    .addPath(
                            new BezierLine(
                                    new Pose(47.075, 14.059),
                                    new Pose(47.123, 35.409)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .build();

            SecondLine = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(47.215, 35.381),
                                    new Pose(47.180, 59.592)
                            )
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(47.180, 59.592),
                                    new Pose(12.135, 59.387)
                            )
                    )
                    .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(12.135, 59.387),
                                    new Pose(47.238, 59.569)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .setReversed()
                    .build();

            ThirdLine = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(47.238, 59.569),
                                    new Pose(47.327, 83.584)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(47.327, 83.584),
                                    new Pose(11.714, 83.487)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(11.714, 83.487),
                                    new Pose(47.696, 83.505)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .setReversed()
                    .build();

            End = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(47.696, 83.505),
                                    new Pose(47.067, 14.104)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .addPath(
                            new BezierLine(
                                    new Pose(47.067, 14.104),
                                    new Pose(63.844, 14.687)
                            )
                    )
                    .setConstantHeadingInterpolation(Math.toRadians(180))
                    .build();
        }
    }

    public enum pathStates {
        pathState1,
        pathState2,
        pathState3,
        pathState4,
        pathState5,
        pathState6,
        pathState7,
        pathState8,
        pathState9,
        pathState10,
        pathState11,
        pathState12,
        pathState13;
    }

    public pathStates myPathstates = pathStates.pathState1;


    public void autonomousPathUpdate() {
        follower.update();
        // Add your state machine Here
        // Access paths with paths.pathName
        // Refer to the Pedro Pathing Docs (Auto Example) for an example state machine
        switch (myPathstates) {
            case pathState1:
                follower.followPath(paths.Start,0.2, true);
                myPathstates = pathStates.pathState2;
                break;
        case pathState2:
            if (!follower.isBusy()) {
                follower.followPath(paths.FirstLine, 0.2, true);
                myPathstates = pathStates.pathState3;
            }
            break;
        case pathState3:
            if (!follower.isBusy()) {
                follower.followPath(paths.SecondLine,0.2, true);
                myPathstates = pathStates.pathState4;
            }
            break;
        case pathState4:
            if (!follower.isBusy()) {
                follower.followPath(paths.ThirdLine,0.2, true);
                myPathstates = pathStates.pathState5;
            }
            break;
        case pathState5:
            if (!follower.isBusy()) {
                follower.followPath(paths.End,0.2, true);
                myPathstates = pathStates.pathState6;
            }
            break;
        case pathState6:
            //do nothing
    }
   }
  }
