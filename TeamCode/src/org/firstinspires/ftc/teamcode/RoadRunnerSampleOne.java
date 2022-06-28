package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.simple_rr_example.MecBot;

public class RoadRunnerSampleOne extends OpMode {

    MecBot bot;
    Trajectory traj;

    @Override
    public void init() {
        bot = new MecBot(hardwareMap);
    }

    @Override
    public void loop() {

    }
}
