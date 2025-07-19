package trashPandas.config.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import trashPandas.config.core.Robot;

public class TillTValue extends CommandBase {
    private Robot r;
    private double tValue;
    public TillTValue(Robot r, double tValue) {
        this.r = r;
        this.tValue = tValue;
    }
    public boolean isFinished() {
        return r.getFollower().getCurrentTValue() > tValue;
    }
}
