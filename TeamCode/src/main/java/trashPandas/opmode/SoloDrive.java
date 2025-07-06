package trashPandas.opmode;

import static trashPandas.config.core.Robot.autoEndPose;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import trashPandas.config.core.Robot;
import trashPandas.config.core.util.Alliance;

@TeleOp(name = "Solo Drive")
public class SoloDrive extends OpMode {

    Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, telemetry, gamepad1 , gamepad2, Alliance.BLUE, autoEndPose, false);
    }

    @Override
    public void start() {
        robot.tStart();
    }

    @Override
    public void loop() {
        robot.soloControls();
        robot.tPeriodic();
    }
}
