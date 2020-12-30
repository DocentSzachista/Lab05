package models;

public class SimulationEngine 
{
	private final int stationSize;
	private RechargeStation stations[];
	public SimulationEngine(int stationSize)
	{
		this.stations=new RechargeStation[stationSize*3];
		this.stationSize=stationSize;
		fillStation();
	}
	private void fillStation()
	{
		for(int i=0; i<stationSize*3; i++)
		{
			if(i<stationSize || i>=stationSize*2)
			{
				stations[i]=new RechargeStation(" ");
			}
			else 
			{
				stations[i]=new RechargeStation("POST");
			}
		}
	}
	public synchronized void getTocharge(Robot r)
	{
		int size=r.getSize();
		int temp=0;
		boolean flag=false;
		for(int i=stationSize; i<stationSize*2; i++)
		{
			if(!stations[i].isBusy() && i==stationSize)
			{
				for(temp=0; temp<size; temp++)
				{
					stations[i-temp].setRobotSpace(r.getName());
					stations[i-temp].setBusy(true);
				}
				flag=true;
			}
			else if(!stations[i].isBusy() && temp!=size)
			{
				temp++;
			}
			if(temp==size)
			{
				for(int j=0; j<size; temp++)
				{
					stations[i-j].setRobotSpace(r.getName());
				}
			}
			if(flag)
			{
				r.setState("Charging");
				break;
			}
		}
	}
	public synchronized RechargeStation[] getStation()
	{
		return this.stations;
	}
}
