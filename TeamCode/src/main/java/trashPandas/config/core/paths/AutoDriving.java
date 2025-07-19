package trashPandas.config.core.paths;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.Point;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoDriving {
    private Follower f;
    private Telemetry telemetry;
    private boolean autoDrive;
    public AutoDriving(Follower f, Telemetry t) {
        this.f = f;
        telemetry = t;
        autoDrive = false;
    }
    //Define Points
    Point bucket = new Point(10, 16);







    //Run Paths
    public void toBucket() {
        Path toBucket = new Path(new BezierLine(
                new Point(f.getPose().getX(), f.getPose().getY()),
                bucket
        ));
        toBucket.setConstantHeadingInterpolation(Math.toRadians(-45));
        f.followPath(toBucket);
    }




    public void off() {
        autoDrive = false;
        f.startTeleopDrive();
    }

    public void update() {
        if (!f.isBusy() && autoDrive) {
            off();
        }
        telemetry();
    }

    public void telemetry() {
        telemetry.addData("Auto Drive", autoDrive ? "ON" : "OFF");
    }

}
