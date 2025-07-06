package trashPandas.opmode;

import static trashPandas.config.core.Robot.autoEndPose;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import trashPandas.config.core.Robot;
import trashPandas.config.core.util.Alliance;

@TeleOp(name = "Dual Drive")
public class DualDrive extends OpMode {

    Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, telemetry, gamepad1 , gamepad2, Alliance.BLUE, autoEndPose, true);
    }

    @Override
    public void start() {
        robot.tStart();
    }

    @Override
    public void loop() {
        robot.dualControls();
        robot.tPeriodic();
    }
}
