package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="SampleServo", group = "sample")
public class SampleServo extends LinearOpMode {
    Servo armServo;
    double startingArmPosition;
    double MIN_POSITION = 0;
    double MAX_POSITION = 1.0;
    @Override
    public void runOpMode() throws InterruptedException {

        armServo = hardwareMap.servo.get("back_servo");

        telemetry.addData("Mode", "waiting");
        telemetry.update();



        waitForStart();
        startingArmPosition = 0.5;

        while (opModeIsActive()) {

            // move arm down on A button if not already at lowest position.
            if (gamepad1.a && startingArmPosition > MIN_POSITION) startingArmPosition -= .001;

            // move arm up on B button if not already at the highest position.
            if (gamepad1.b && startingArmPosition < MAX_POSITION) startingArmPosition += .001;

            armServo.setPosition(startingArmPosition);
        }
    }

}
