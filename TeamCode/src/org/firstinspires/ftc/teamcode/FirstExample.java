package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name="FirstExample", group="LinearOpMode")
public class FirstExample extends LinearOpMode {

    // Initialize your hardware
    DcMotor leftMotor;
    DcMotor rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("left_motor");
        rightMotor = hardwareMap.dcMotor.get("right_motor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        SampleMecanumDrive SampleMecanumDrive = new SampleMecanumDrive();
//        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
//                .strafeRight(10)
//                .forward(5)
//                .build();

        waitForStart();
        while (opModeIsActive()) {
            leftMotor.setPower(1);
            rightMotor.setPower(1);
        }
    }
}
