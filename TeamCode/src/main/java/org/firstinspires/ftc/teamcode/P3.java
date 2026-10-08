
package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

import java.nio.file.Path;

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
        Follower panelsTelemetry = null;
        panelsTelemetry.debug();
        panelsTelemetry.debug();
        panelsTelemetry.debug();
        panelsTelemetry.debug();
        panelsTelemetry.update();
    }

    private void autonomousPathUpdate() {
    }
}


public class Paths {

    private final PoseFactory poseFactory = PoseFactory.degrees();

            private final Pose start = PoseFactory.of(56, 8, 90);
            private final Pose path1 = PoseFactory.of(55.4021, 26.2345, 90);
            private final Pose point2 = PoseFactory.of(35.4746, 48.0676, 90);
            private final Pose point3 = PoseFactory.of(34.2563, 105.7868, -90);
            private final Pose point4 = PoseFactory.of(57.099, 106.5186, -90);
            private final Pose point5 = PoseFactory.of(33.9738, 105.8308, -90);
            private final Pose point6Start = PoseFactory.of(33.9738, 105.8308, 90);
            private final Pose point6 = PoseFactory.of(34.3106, 13.3684, 180);
            private final Pose point7 = PoseFactory.of(8.2843, 8.5834, 180);
            private final Pose point8 = PoseFactory.of(55.2202, 26.5388, 90);
            private final Pose point9 = PoseFactory.of(34.8887, 48.2495, 90);
            private final Pose point10Start = PoseFactory.of(34.8887, 48.2495, 180);
            private final Pose point10 = PoseFactory.of(33.6904, 106.6591, -90);
            private final Pose point11 = PoseFactory.of(56.7174, 106.5186, -90);
            private final Pose point12 = PoseFactory.of(6.4814, 106.0956, -90);

            public Path path1() {
                return Paths.line(start, path1).linear(start, path1);
            }

            public Path path2() {
                return Paths.line(path1, point2).linear(path1, point2);
            }

            public Path path3() {
                return Paths.line(point2, point3).linear(point2, point3);
            }

            public Path path4() {
                return Paths.line(point3, point4).linear(point3, point4);
            }

            public Path path5() {
                return Paths.line(point4, point5).linear(point4, point5);
            }

            public Path path6() {
                return Paths.line(point6Start, point6).linear(point6Start, point6);
            }

            public Path path7() {
                return Paths.line(point6, point7).linear(point6, point7);
            }

            public Path path8() {
                return Paths.line(point7, point8).linear(point7, point8);
            }

            public Path path9() {
                return Paths.line(point8, point9).linear(point8, point9);
            }

            public Path path10() {
                return Paths.line(point10Start, point10).linear(point10Start, point10);
            }

            public Path path11()

    private static class PoseFactory {
    }
}
}