package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Turret {
//    private DcMotorEx turretMotor;
//    private final double P_GAIN = 0.005;
//    private final double TICKS_PER_DEGREE = 28.0;
//    private final double MAX_TICKS = 2000;
//    private final double MIN_TICKS = -2000;
//    public void setTargetAngle;
//    public Turret(HardwareMap hardwareMap) {
//        turretMotor = hardwareMap.get(DcMotorEx.class, "turret_motor");
//        turretMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        turretMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
//        turretMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//
//    }
//    public void setTargetAngle(double targetAngle) {
//        // Clamp the angle within physical limits
//        targetAngle = Range.clip(targetAngle, MIN_TICKS, MAX_TICKS);
//
//        int targetTicks = (int) (targetAngle * TICKS_PER_DEGREE);
//        turretMotor.setTargetPosition(targetTicks);
//        turretMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        turretMotor.setPower(0.5); // Set tuning speed
//    }
//
//    public void setTargetAngle(double degrees) {
//        // Constrain target angle to physical limits
//        double targetTicks = degrees * TICKS_PER_DEGREE;
//        if (targetTicks > MAX_TICKS) targetTicks = MAX_TICKS;
//        if (targetTicks < MIN_TICKS) targetTicks = MIN_TICKS;
//
//
//        targetPosition = targetTicks;
//    }
//
//    public void update() {
//        // Simple P control loop calculation
//        double currentPosition = turretMotor.getCurrentPosition();
//        double error = targetPosition - currentPosition;
//        double power = error * P_GAIN;
//
//        // Cap power between -1.0 and 1.0
//        power = Math.max(-1.0, Math.min(1.0, power));
//
//        turretMotor.setPower(power);
//    }
//
//    public void stop() {
//        turretMotor.setPower(0);
//    }
//}
//I am turret pew pew pew
}