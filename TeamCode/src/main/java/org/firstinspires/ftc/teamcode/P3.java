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


@Autonomous(name = "P3", group = "Autonomous")
@Configurable
abstract class p3 extends OpMode {
    private TelemetryManager panelsTelemetry;
    // Panels Telemetry instance
    private Follower follower; // Pedro Pathing follower instance
    private int pathState = 0; // Current autonomous path state (state machine)
    private Paths paths; // Paths defined in the Paths class

    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(56, 8, Math.toRadians(90)));
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

    private void autonomousPathUpdate() {
        
    }
}

public static class Paths {
    public PathChain Start;
        new Pose(56, 8, Math.toRadians(90)
            new Pose(55.4021, 26.2345, Math.toRadians(90);
                new Pose(35.4746, 48.0676, Math.toRadians(90);
    public PathChain FirstLine;
        new Pose(34.2563, 105.7868, Math.toRadians(-90);
            new Pose(57.099, 106.5186, Math.toRadians(-90);
                new Pose(33.9738, 105.8308, Math.toRadians(-90);
    public PathChain SecondLine;
            new pose(33.9738, 105.8308, Math.toRadians(90);
                new pose(34.3106, 13.3684, Math.toRadians(180);
                    new pose(8.2843, 8.5834, Math.toRadians(180);
    public PathChain ThirdLine;
        new pose(55.2202, 26.5388, Math.toRadians(90); 
            new pose(34.8887, 48.2495, Math.toRadians(90);
                new pose(34.8887, 48.2495, Math.toRadians(180);
    public PathChain End;
        new pose(33.6904, 106.6591, Math.toRadians(-90);
            new pose(56.7174, 106.5186, Math.toRadians(-90);
                new pose(6.4814, 106.0956, Math.toRadians(-90);

    public Paths(Follower follower) {
        Start = follower.pathBuilder()
                .addPath(new BezierLine( new Pose(56, 8, Math.toRadians(90),
                         new Pose(55.4021, 26.2345, Math.toRadians(90)
                         new Pose(35.4746, 48.0676, Math.toRadians(90);
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(180))
                        .build();
                )
        
                );
    }

    public void setConstantHeadingInterpolation(double constantHeadingInterpolation) {
        this.constantHeadingInterpolation = constantHeadingInterpolation;
    }

    