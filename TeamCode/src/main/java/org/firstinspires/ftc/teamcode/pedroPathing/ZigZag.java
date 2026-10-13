
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
public class ZigZag extends OpMode{

    import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

    public class Paths {

        private final PoseFactory poseFactory = PoseFactory.degrees();

        private final Pose startiguess = poseFactory.of(57.6085, 137.1923, 90);
        private final Pose point1 = poseFactory.of(57.7866, 136.8556, -62.1082);
        private final Pose point2 = poseFactory.of(57.9951, 111.4437, -89.53);
        private final Pose point3 = poseFactory.of(27.6838, 97.4359, -155.1969);
        private final Pose point4 = poseFactory.of(9.7085, 7.481, -101.3004);
        private final Pose point5 = poseFactory.of(35.8338, 31.6261, 42.7441);
        private final Pose point6 = poseFactory.of(33.2838, 106.8732, 91.9409);
        private final Pose point7 = poseFactory.of(131.0676, 134.4254, 15.736);
        private final Pose point8 = poseFactory.of(60.7852, 108.6536, -159.8626);
        private final Pose point9 = poseFactory.of(4.4106, 107.6176, -178.9472);

        public Path path1() {
            return Paths.line(startiguess, point1).tangent();
        }

        public Path path2() {
            return Paths.line(point1, point2).tangent();
        }

        public Path path3() {
            return Paths.line(point2, point3).tangent();
        }

        public Path path4() {
            return Paths.line(point3, point4).tangent();
        }

        public Path path5() {
            return Paths.line(point4, point5).tangent();
        }

        public Path path6() {
            return Paths.line(point5, point6).tangent();
        }

        public Path path7() {
            return Paths.line(point6, point7).tangent();
        }

        public Path path8() {
            return Paths.line(point7, point8).tangent();
        }

        public Path path9() {
            return Paths.line(point8, point9).tangent();
        }
    }