package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "SampleMecDistanceSensor", group = "Sample")
public class SampleMecDistanceSensor extends LinearOpMode {

    DcMotor front_left_motor;
    DcMotor front_right_motor;
    DcMotor back_left_motor;
    DcMotor back_right_motor;

    // called when init button is  pressed.

    //    back_right_motor
//            front_right_motor
//    front_left_motor
//            back_left_motor
    @Override
    public void runOpMode() throws InterruptedException
    {
        front_left_motor = hardwareMap.dcMotor.get("front_left_motor");
        back_left_motor = hardwareMap.dcMotor.get("back_left_motor");
        front_right_motor = hardwareMap.dcMotor.get("front_right_motor");
        back_right_motor = hardwareMap.dcMotor.get("back_right_motor");


        DistanceSensor frontDistance = hardwareMap.get(DistanceSensor.class, "front_distance");
        DistanceSensor leftDistance = hardwareMap.get(DistanceSensor.class, "left_distance");
        DistanceSensor rightDistance = hardwareMap.get(DistanceSensor.class, "right_distance");
        DistanceSensor backDistance = hardwareMap.get(DistanceSensor.class, "back_distance");

        front_left_motor.setDirection(DcMotor.Direction.REVERSE);
        back_left_motor.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

        sleep(500);        // wait so that above telemetry is visible.

        // each iteration of this for loop will drive one side of the square.

        front_left_motor.setPower(0.5);
        front_right_motor.setPower(0.5);
        back_left_motor.setPower(0.6);
        back_right_motor.setPower(0.1);

        sleep(3000); // drive straight for 1 second.


        telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

        front_left_motor.setPower(0.1);
        front_right_motor.setPower(0.4);
        back_left_motor.setPower(0);
        back_right_motor.setPower(0);

        sleep(3000); // drive straight for 1 second.

        front_left_motor.setPower(0.25);
        front_right_motor.setPower(-0.25);
        back_left_motor.setPower(-0.25);
        back_right_motor.setPower(.25);

        telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

        sleep(3000);

        front_left_motor.setPower(0.0);
        front_right_motor.setPower(0.0);
        back_left_motor.setPower(0);
        back_right_motor.setPower(0);

        telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

        sleep(3000); // drive straight for 1 second.

        front_left_motor.setPower(-0.25);
        front_right_motor.setPower(-0.25);
        back_left_motor.setPower(-0.25);
        back_right_motor.setPower(-.25);

        telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

        sleep(3000);

        telemetry.addData("Front Distance", " %.1f", frontDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Left Distance", " %.1f", leftDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Right Distance", " %.1f", rightDistance.getDistance(DistanceUnit.CM));
        telemetry.addData("Back Distance", " %.1f", backDistance.getDistance(DistanceUnit.CM));
        telemetry.update();

        front_left_motor.setPower(0.0);
        front_right_motor.setPower(0.0);
        back_left_motor.setPower(0);
        back_right_motor.setPower(0);

        sleep(3000); // drive straight for 1 second.

        front_left_motor.setPower(-0.25);
        front_right_motor.setPower(0.25);
        back_left_motor.setPower(0.25);
        back_right_motor.setPower(-.25);

        sleep(3000);

        // make sure the motors are off.

        front_right_motor.setPower(0);
        back_left_motor.setPower(0);
        front_left_motor.setPower(0);
        back_right_motor.setPower(0);
    }
}
