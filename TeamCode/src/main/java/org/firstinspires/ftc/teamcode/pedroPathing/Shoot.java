import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
public class Shoot extends OpMode{
    private TelemetryManager panelsTelemetry; // Panels Telemetry instance
    public Follower follower; // Pedro Pathing follower instance
    private int pathState = 0; // Current autonomous path state (state machine)
    private Paths paths;

    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();

        follower = Constants.createFollower(hardwareMap);
       follower.setStartingPose(56.3986, 5.8077, 90);
        paths = new Paths(follower);

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
                                new BeizerLine(
                                        new Pose(56.3986, 5.8077, 90)
                                        new Pose(56.9261, 6.1197, 30.6024)
                                        new Pose(56.5979, 31.2169, 90.7492)
                                )
                )
                setConstantHeadingInterpolation(Math.toRadians(180))
                        .build();

                FirstLine = follower.pathBuilder()
                        .addPath(
                                new BezierLine(
                                        new Pose(35.0761, 39.4979, 158.9546)
                                        new Pose(36.2873, 122.0408, 89.1593)
                    )
                )
                setConstantHeadingInterpolation(Math.toRadians(180))
                        .build();
                SecondLine = follower.pathBuilder()
                        .addPath(
                                new BeizerLine(
                                        new Pose(52.3789, 106.7232, -43.5885)
                                        new Pose(52.8606, 130.0338, 88.8162)
                                )
                )
                setConstantHeadingInterpolation(Math.toRadians((180))
                        .build();
                ThirdLine = follower.pathBuilder()
                        .addPath(
                                new BeizerLine(
                                        new Pose(21.6683, 90.8627, -128.5306)
                                        new Pose(27.543, 24.6169, -84.9323)
                                )
                        )
                   .setConstantHeadingInterpolation(Math.toRadians(180))
                        .build();
                End = follower.pathBuilder()
                        .addpath(
                                new BeizerLine(
                                       new Pose(17.2359, 13.3542, -132.4632)
                                       new Pose(8.8761, 107.4077, 95.0793)
                                )
                        )
                 .setConstantHeadingInterpolation(Math.toRadians(180))
                        .build();
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
                }
                public pathStates turretPathstates = pathStates.pathState1;

                public void autonomousPathUpdate() {
                    follower.update();
                    switch (turretPathstates)
                    case pathState1:
                        if (!follower.isbusy())
                            follower.followPath(paths.Start, 0.2, true);
                        turretPathstates = pathStates.pathState2;
                        break;
                    case pathState2:
                        if (!follower.isbusy())
                            follower.followPath(paths.FirstLine, 0.2, true);
                        turretPathstates = pathStates.pathState3;
                        }
                        break
                    case pathState3:
                        if (!follower.isbusy())
                        follower.followPath(paths.SecondLine,0.2, true);
                        turretPathstates = pathStates.pathState4;
                        }
                        break;
                        case pathState4:
                            if (!follower.isbusy())
                        follower.followPath(paths.ThirdLine,0.2, true);
                        turretPathstates = pathStates.pathState5;
                        break;
                        }
                    case pathState5:
                        if (!follower.isbusy())
                        follower.followPath(paths.End,0.2, true);
                        myPathstates = pathStates.pathState6;
                        break;
                        case pathState6;
                 }
             }
         }