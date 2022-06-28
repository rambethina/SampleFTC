package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.rr_quickstart_examples.drive.SampleMecanumDrive;

@Autonomous(name = "RoadRunnerSampleExamples", group = "road-runner")
public class RoadRunnerSampleExamples extends LinearOpMode {

    SampleMecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new SampleMecanumDrive(hardwareMap);

        // Basic Example

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
          .strafeRight(10)
//          .forward(5)
          .build();


        // Path Continuity Example - Will throw an error
        /*
        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
          .strafeRight(10)
          .forward(5)
          .build();
        */

        //Multiple trajectories
        /*
        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(10)
                .build();

        //Note call to traj1.end()
        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                .forward(5)
                .build();

        drive.followTrajectory(traj1);
        drive.followTrajectory(traj2);
         */

        //Example to explain chaining operators & spline
        /*

        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
                .splineTo(new Vector2d(36, 36), Math.toRadians(0))
                .splineTo(new Vector2d(72, 0), Math.toRadians(0))
                .build();
        waitForStart();

         */

        drive.followTrajectory(myTrajectory);
    }
}
