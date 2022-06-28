package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.ai.AStar;
import com.ai.Node;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.rr_quickstart_examples.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.simple_rr_example.MecBot;

import java.util.List;

@Autonomous(name = "RoadRunnerSampleTwo1", group = "road-runner")
public class RoadRunnerSampleTwo extends LinearOpMode {

//    MecBot bot;
    SampleMecanumDrive drive;

    Node initialNode = new Node(2, 1);
    Node finalNode = new Node(40, 50);
    int rows = 60;
    int cols = 70;
    AStar aStar = new AStar(rows, cols, initialNode, finalNode);
    int[][] blocksArray = new int[][]{{1, 30}, {2, 30}, {3, 30}};



    @Override
    public void runOpMode() throws InterruptedException {
        aStar.setBlocks(blocksArray);
        drive = new SampleMecanumDrive(hardwareMap);

        List<Node> path = aStar.findPath();

//                Trajectory traj1 = drive.trajectoryBuilder(new Pose2d()).splineTo().
//                .splineTo(new Vector2d(20, 9), Math.toRadians(45))
//                .build();

        // We want to start the bot at x: 10, y: -8, heading: 90 degrees
//        Pose2d startPose = new Pose2d(10, -8, Math.toRadians(90));
//
//        drive.setPoseEstimate(startPose);
//
//        Trajectory traj1 = drive.trajectoryBuilder(startPose)
//                .splineTo(new Vector2d(20, 9), Math.toRadians(45))
//                .build();
//
//        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
//                .splineTo(new Vector2d(20, 9), Math.toRadians(45))
//                .build();
//
//        drive.followTrajectory(traj1);
//        drive.followTrajectory(traj2);

        /*
        Trajectory myTrajectory = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(10)
//                .forward(5)
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(myTrajectory);

         */

        /*
        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(10)
                .build();

        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                .forward(5)
                .build();

        drive.followTrajectory(traj1);
        drive.followTrajectory(traj2);
        */

//        Trajectory traj = drive.trajectoryBuilder(new Pose2d())
//                .splineTo(new Vector2d(0, 0), 0)
////                .splineTo(new Vector2d(2, 4), 0)
////                .splineTo(new Vector2d(4, 1), 0)
////                .splineTo(new Vector2d(1, 3), 0)
//                .build();

        /*
        System.out.println("first");
        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                .strafeRight(10)
                .build();


        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                .splineTo(new Vector2d(5, 6), 0)
                .splineTo(new Vector2d(9, -10), 0)
                .build();

        Trajectory traj3 = drive.trajectoryBuilder(traj2.end())
                .splineTo(new Vector2d(5, 6), 0)
                .splineTo(new Vector2d(9, -10), 0)
                .build();

        drive.followTrajectory(traj1);
//        robot.dropServo();
        drive.followTrajectory(traj2);
        drive.followTrajectory(traj3);
//        drive.followTrajectory(traj);

         */
//        Trajectory traj3 = drive.trajectoryBuilder(new Pose2d())
//                .splineTo(new Vector2d(36, 36), Math.toRadians(0))
//                .addDisplacementMarker(() -> {
//                    // Run your action in here!
//                    // Drop servo, start motor, whatever
//                })
//                .splineTo(new Vector2d(72, 0), Math.toRadians(0))
//                .splineTo(new Vector2d(-32, -36), Math.toRadians(0))
//                .splineTo(new Vector2d(0, 0), Math.toRadians(0))
//                .build();

        TrajectoryBuilder trajectoryBuilder = drive.trajectoryBuilder(new Pose2d());

        for (Node node : path) {
            System.out.println(node);
            System.out.println("["+node.getRow()+":"+node.getCol()+"]");
            trajectoryBuilder.splineTo(new Vector2d(node.getRow()*10, node.getCol()*10),  Math.toRadians(0));
        }
        Trajectory traj3 = trajectoryBuilder.build();
        drive.followTrajectory(traj3);
    }
}
