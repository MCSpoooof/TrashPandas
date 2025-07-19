package trashPandas.config.core.paths.autonomous;

import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;

public class FiveSpec {
    public static final Pose startPose = new Pose(0, 0, Math.toRadians(0));

    private static final Pose scorePreloadPose = new Pose(22, 0, Math.toRadians(0));

    private static final Pose moveRightPose = new Pose(20, -20, Math.toRadians(0));

    private static final Pose moveForwardPose = new Pose(28, 0, Math.toRadians(0));

    private static final Pose pushPositionPose1 = new Pose(51, -39, Math.toRadians(0));

    private static final Pose pushPositionPose2 = new Pose(48, -45, Math.toRadians(0));

    private static final Pose pushPositionPose3 = new Pose(48, -51, Math.toRadians(0));

    private static final Pose pushPose1 = new Pose(17, -39, Math.toRadians(0));

    private static final Pose pushPose2 = new Pose(17, -51, Math.toRadians(0));

    private static final Pose pushPose3 = new Pose(8, -55, Math.toRadians(0));

    private static final Pose finalPushPose = new Pose(53, -55, Math.toRadians(0));

    private static final Pose strafeGrabPose = new Pose(15, -25, Math.toRadians(0));

    private static final Pose grabPose = new Pose(8.3, -30, Math.toRadians(0));

    private static final Pose hangPose1 = new Pose(25, -1, Math.toRadians(0)); //28

    private static final Pose hangPose2 = new Pose(25, 2, Math.toRadians(0)); //28

    private static final Pose hangPose3 = new Pose(25, 5, Math.toRadians(0)); //28

    private static final Pose hangPose4 = new Pose(25, 8, Math.toRadians(0)); //28

    public static PathChain hangPreload() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(startPose), new Point(scorePreloadPose)))
                .setLinearHeadingInterpolation(startPose.getHeading(), scorePreloadPose.getHeading())
                .build();
    }
    public static PathChain moveForward() {
        return new PathBuilder()
                .addPath(new BezierCurve(new Point(scorePreloadPose), new Point(moveForwardPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain moveRight() {
        return new PathBuilder()
                .addPath(new BezierCurve(new Point(moveForwardPose), new Point(moveRightPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setZeroPowerAccelerationMultiplier(5)
                .build();
    }
    public static PathChain pushPosition1() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(moveRightPose), new Point(pushPositionPose1)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setPathEndTimeoutConstraint(0)
                .setZeroPowerAccelerationMultiplier(5)
                .build();
    }
    public static PathChain pushPosition2() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(pushPose1), new Point(pushPositionPose2)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setPathEndTimeoutConstraint(0)
                .setZeroPowerAccelerationMultiplier(5)
                .build();
    }
    public static PathChain pushPosition3() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(pushPose2), new Point(pushPositionPose3)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setPathEndTimeoutConstraint(0)
                .setZeroPowerAccelerationMultiplier(5)
                .build();
    }
    public static PathChain push1() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(pushPositionPose1), new Point(pushPose1)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setPathEndTimeoutConstraint(0)
                .setZeroPowerAccelerationMultiplier(5)
                .build();
    }
    public static PathChain push2() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(pushPositionPose2), new Point(pushPose2)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setPathEndTimeoutConstraint(0)
                .setZeroPowerAccelerationMultiplier(5)
                .build();
    }
    public static PathChain push3() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(finalPushPose), new Point(pushPose3)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .setPathEndTimeoutConstraint(0)
                .setZeroPowerAccelerationMultiplier(3)
                .build();
    }
    public static PathChain finalPush() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(pushPositionPose3), new Point(finalPushPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain hang1() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(pushPose3), new Point(hangPose1)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain strafeGrab2() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(hangPose1), new Point(strafeGrabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain grab2() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(strafeGrabPose), new Point(grabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain hang2() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(grabPose), new Point(hangPose2)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain strafeGrab3() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(hangPose2), new Point(strafeGrabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain grab3() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(strafeGrabPose), new Point(grabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain hang3() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(grabPose), new Point(hangPose3)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain strafeGrab4() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(hangPose3), new Point(strafeGrabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain grab4() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(strafeGrabPose), new Point(grabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain hang4() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(grabPose), new Point(hangPose4)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain grab5() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(hangPose4), new Point(grabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
    public static PathChain parkAtEnd() {
        return new PathBuilder()
                .addPath(new BezierLine(new Point(hangPose4), new Point(grabPose)))
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .build();
    }
}
