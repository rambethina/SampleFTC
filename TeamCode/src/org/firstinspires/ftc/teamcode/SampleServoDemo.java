package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="SampleServoDemo", group ="Wk13")
public class SampleServoDemo extends LinearOpMode {

    double startingArmPosition = 0;
    double MIN_POSITION = 0;
    double MAX_POSITION = 1.0;
    Servo servo;
    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.servo.get("back_servo");

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();

        startingArmPosition = 0.5;

        while(opModeIsActive()) {
            if(gamepad1.a && startingArmPosition > MIN_POSITION) {
                startingArmPosition -= .001;
                // startingArmPosition = startingArmPosition -.001
            }
            if(gamepad1.b && startingArmPosition < MAX_POSITION) {
                startingArmPosition += 0.001;
            }

            servo.setPosition(startingArmPosition);
        }
    }
}
