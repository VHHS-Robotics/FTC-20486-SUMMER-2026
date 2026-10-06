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
import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
public class ZigZag {

         TelemetryManager telemetry;
        @Override
        public void init(){

    }


        public class Paths {

            private final PoseFactory poseFactory = PoseFactory.degrees();

            private final Pose startiguess = poseFactory.of(59.388, 135.5493, 90);
            private final Pose point1Start = poseFactory.of(59.388, 135.5493, -90);
            private final Pose point1 = poseFactory.of(59.9, 135.2775, -90);
            private final Pose point2 = poseFactory.of(59.3901, 104.6676, -90);
            private final Pose point3 = poseFactory.of(27.6838, 97.4359, -90);
            private final Pose point4 = poseFactory.of(25.6521, 8.0789, -180);
            private final Pose point5Start = poseFactory.of(25.6521, 8.0789, 180);
            private final Pose point5 = poseFactory.of(7.1866, 8.9275, -180);
            private final Pose point6Start = poseFactory.of(7.1866, 8.9275, 90);
            private final Pose point6 = poseFactory.of(52.3754, 35.0141, 90);
            private final Pose point7 = poseFactory.of(26.5711, 36.8021, -90);
            private final Pose point8 = poseFactory.of(27.7021, 96.8951, -90);
            private final Pose point9 = poseFactory.of(59.4655, 104.757, -90);
            private final Pose point10 = poseFactory.of(59.9225, 105.5979, -90);
            private final Pose point11 = poseFactory.of(127.4817, 136.519, 0);
            private final Pose point12 = poseFactory.of(59.6683, 105.2049, -90);
            private final Pose point13 = poseFactory.of(6.1162, 105.8556, 179.3038);

            public Path path1() {
                return Paths.line(point1Start, point1).linear(point1Start, point1);
            }

            public Path path2() {
                return Paths.line(point1, point2).linear(point1, point2);
            }

            public Path path3() {
                return Paths.line(point2, point3).linear(point2, point3);
            }

            public Path path4() {
                return Paths.line(point3, point4).linear(point3, point4);
            }

            public Path path5() {
                return Paths.line(point5Start, point5).linear(point5Start, point5);
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
                return Paths.line(point9, point10).linear(point9, point10);
            }

            public Path path11() {
                return Paths.line(point10, point11).linear(point10, point11);
            }

            public Path path12() {
                return Paths.line(point11, point12).linear(point11, point12);
            }

            public Path path13() {
                return Paths.line(point12, point13).tangent();
            }
        }
}
