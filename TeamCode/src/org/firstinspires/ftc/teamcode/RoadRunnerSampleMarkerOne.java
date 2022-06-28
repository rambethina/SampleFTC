package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.rr_quickstart_examples.drive.SampleMecanumDrive;

@Autonomous(name = "RoadRunnerSampleMarkerOne", group = "road-runner")
public class RoadRunnerSampleMarkerOne extends LinearOpMode {
    SampleMecanumDrive drive;
    Servo armServo;

    //back_servo
    @Override
    public void runOpMode() throws InterruptedException {
        drive = new SampleMecanumDrive(hardwareMap);
        armServo = hardwareMap.servo.get("back_servo");

        Trajectory trajectory = drive.trajectoryBuilder(new Pose2d())
                .splineTo(new Vector2d(36, 36), Math.toRadians(0))
                .addDisplacementMarker(() -> {
                    // Run your action in here!
                    // Drop servo, start motor, whatever
                    armServo.setPosition(0.5);
                })
                .splineTo(new Vector2d(72, 0), Math.toRadians(0))
                .build();

        drive.followTrajectory(trajectory);
    }
}
