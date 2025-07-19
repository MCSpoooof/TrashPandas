package trashPandas.opmode.auto;

import static trashPandas.config.core.paths.autonomous.FiveSpec.*;

import com.arcrobotics.ftclib.command.*;

import trashPandas.config.commands.ScoreSpecimen;
import trashPandas.config.commands.TillTValue;
import trashPandas.config.core.Robot;
import trashPandas.config.core.util.Alliance;
import trashPandas.config.core.util.OpModeCommand;
import trashPandas.config.subsystems.Claw;
import trashPandas.config.subsystems.Rails;


import com.pedropathing.commands.FollowPath;
import com.pedropathing.localization.Pose;


public class FiveSpecAutoTest extends OpModeCommand {
    private Robot robot;

    @Override
    public void initialize() {
        robot = new Robot(hardwareMap, telemetry, Alliance.BLUE, startPose);
        robot.getFollower().setMaxPower(1);


        schedule(
                new RunCommand(robot::aPeriodic),
                new SequentialCommandGroup(
                        new FollowPath(robot.getFollower(), hangPreload(), true).alongWith(
                                new InstantCommand(() -> {robot.getLift().toChamber();})),
                        new ScoreSpecimen(robot).alongWith(
                                new FollowPath(robot.getFollower(), moveForward(), true)
                                ),
                        new WaitCommand(600).andThen(
                                new FollowPath(robot.getFollower(), pushPosition1(), true).alongWith(
                                        new WaitCommand(500).andThen(
                                                new InstantCommand(() -> {robot.getLift().toZero();})
                                        )
                                )
                        ),
                        new FollowPath(robot.getFollower(), push1(), true),
                        new FollowPath(robot.getFollower(), pushPosition2(), true),
                        new FollowPath(robot.getFollower(), push2(), true),
                        new FollowPath(robot.getFollower(), pushPosition3(), true),
                        new FollowPath(robot.getFollower(), push3(), true),
                        new FollowPath(robot.getFollower(), finalPush(), true),
                        new TillTValue(robot, 0.2).andThen(
                                new InstantCommand(() -> {
                                    robot.getClaw().setV4BState(Claw.V4BState.GRAB_SPECIMEN_V4B);
                                    robot.getClaw().setPitchState(Claw.PitchState.SPECIMEN);
                                    robot.getClaw().setRollState(Claw.RollState.ZERO);
                                })
                        )


                )
        );
    }
}
