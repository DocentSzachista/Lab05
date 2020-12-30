package models;

public class RechargeStation 
{
	private boolean busy;
	private String robotSpace;
	private String space;
	public RechargeStation(String space)
	{
		setRobotSpace(" ");
		setBusy(false);
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getRobotSpace() {
		return robotSpace;
	}
	public void setRobotSpace(String robotSpace) {
		this.robotSpace = robotSpace;
	}
}
