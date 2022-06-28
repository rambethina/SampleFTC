package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "TwoWheelRegModeSMSwithCase", group = "RegularOpMode")
public class TwoWheelRegModeSMSwithCase extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;

    ElapsedTime elapsedTime;
    State currentState = State.FORWARD;

    enum State {
        FORWARD,
        BACKWARD
    }

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_motor");
        rightMotor = hardwareMap.dcMotor.get("right_motor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void start() {
        this.elapsedTime = new ElapsedTime();
        elapsedTime.reset();
    }

    @Override
    public void loop() {
        double time = elapsedTime.milliseconds();
        System.out.println(time);

//        if(currentState == State.FORWARD) {
//            leftMotor.setPower(1);
//            rightMotor.setPower(1);
//            if(time > 1000) {
//                elapsedTime.reset();
//                currentState = State.BACKWARD;
//            }
//        } else if (currentState == State.BACKWARD) {
//            leftMotor.setPower(-1);
//            rightMotor.setPower(-1);
//            if(time > 1000) {
//                elapsedTime.reset();
//                currentState = State.FORWARD;
//            }
//        }

        switch (currentState) {
            case BACKWARD: {
                leftMotor.setPower(-1);
                rightMotor.setPower(-1);
                if (time > 1000) {
                    elapsedTime.reset();
                    currentState = State.FORWARD;
                }
                break;
            }
            case FORWARD: {
                leftMotor.setPower(1);
                rightMotor.setPower(1);
                if (time > 1000) {
                    elapsedTime.reset();
                    currentState = State.BACKWARD;
                }
            }
        }
    }
}
