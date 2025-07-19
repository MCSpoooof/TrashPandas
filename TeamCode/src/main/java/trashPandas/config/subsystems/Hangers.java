package trashPandas.config.subsystems;

import static trashPandas.config.core.RobotConstants.p;
import static trashPandas.config.core.RobotConstants.slideHighBasket;
import static trashPandas.config.core.RobotConstants.slideHighChamber;
import static trashPandas.config.core.RobotConstants.slidePark;
import static trashPandas.config.core.RobotConstants.slideScoreHighBasket;
import static trashPandas.config.core.RobotConstants.slideZero;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import trashPandas.config.core.RobotConstants;
import trashPandas.config.core.hardware.CachedMotor;
import trashPandas.config.util.PDFLController;

public class Hangers extends SubsystemBase {
    private Telemetry telemetry;
    private double power;
    public CachedMotor hangerL, hangerR;
    public Hangers(HardwareMap hardwareMap, Telemetry telemetry) {

        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        hangerL = new CachedMotor(hardwareMap.get(DcMotor.class, "cm1"));
        hangerR = new CachedMotor(hardwareMap.get(DcMotor.class, "cm0"));

        hangerL.setDirection(DcMotor.Direction.FORWARD);
        hangerR.setDirection(DcMotor.Direction.FORWARD);

        hangerL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        hangerR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        power = 0;

    }

    public void update() {
        hangerR.setPower(power);
        hangerL.setPower(power);
    }
    public void setPower(double p) {
        if (p != power) {
            this.power = p;
            update();
        }
    }

    private void telemetry() {
        telemetry.addData("Hanger Power: ", hangerR.getPower());
    }

    @Override
    public void periodic() {
        telemetry();
    }
}
