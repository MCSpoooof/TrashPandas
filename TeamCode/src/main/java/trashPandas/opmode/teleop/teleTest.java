package trashPandas.opmode.teleop;

import static trashPandas.config.core.Robot.autoEndPose;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import trashPandas.config.core.Robot;
import trashPandas.config.core.util.Alliance;
import trashPandas.config.subsystems.Claw;

public class teleTest extends LinearOpMode {
    private Robot robot;
    private GamepadEx g1;
    private GamepadEx g2;
    @Override
    public void runOpMode() throws InterruptedException {
        //Initialize Hardware
        robot = new Robot(hardwareMap, telemetry, Alliance.BLUE, autoEndPose, Robot.ScoringMode.SAMPLE);
        robot.init();

        //Initialize Gamepads
        g1 = new GamepadEx(gamepad1);
        g2 = new GamepadEx(gamepad2);

        waitForStart();
        robot.tStart();
        robot.dualControls(g1, g2);


        while (opModeIsActive()) {
            //Update everything
            robot.tPeriodic();

            //Runs all gamepad triggers
            CommandScheduler.getInstance().run();

            //Driving (driver 1)
            robot.getFollower().setTeleOpMovementVectors(-gamepad1.left_stick_y * robot.getSpeed(), -gamepad1.left_stick_x * robot.getSpeed(), -gamepad1.right_stick_x * robot.getSpeed() * 0.5);

        }
    }
}
