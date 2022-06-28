package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="two", group = "RegularOpMode")
public class TwoWheelRegularOpMode extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;


    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_motor");
        rightMotor = hardwareMap.dcMotor.get("right_motor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        System.out.println(getRuntime());
        leftMotor.setPower(-1);
        rightMotor.setPower(-1);
    }
}
