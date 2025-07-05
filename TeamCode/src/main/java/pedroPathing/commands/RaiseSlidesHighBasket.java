package pedroPathing.commands;

import static pedroPathing.robot.RobotConstants.slideHighBasket;

import com.arcrobotics.ftclib.command.CommandBase;

import pedroPathing.subsystem.Claw;
import pedroPathing.subsystem.Lift;
import pedroPathing.subsystem.Robot;
import pedroPathing.util.Timer;

public class RaiseSlidesHighBasket extends CommandBase {
    private final Lift lift;
    private final Claw claw;

    private int state = 0;
    private Timer wait = new Timer();

    public RaiseSlidesHighBasket(Lift lift, Claw claw) {
        this.lift = lift;
        this.claw = claw;
        addRequirements(lift, claw);
    }

    @Override
    public void initialize() {
        state = 1;
    }

    @Override
    public void execute() {
        switch(state) {
            case 1:
                Robot.set(Robot.RobotState.HIGH_BASKET_DEPOSIT);
                lift.toScoreHighBucket();
                if (Math.abs(lift.getPos() - slideHighBasket) < 10) {
                    state = 2;
                }
                break;

            case 2:
                claw.setV4BState(Claw.V4BState.DEPOSIT_V4B);
                claw.setPitchState(Claw.PitchState.DEPOSIT);
                claw.setRollState(Claw.RollState.NINETY);
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return state == 2;
    }
}
