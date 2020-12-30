package models;



public class Robot extends Thread
{
	private String name;
	private int size;
	private String state;
	private int time;
	public Robot(String name, int size, String state, int time)
	{
		super(name);
		this.size=size;
		this.state=state;
		this.time=time;
		
	}
	public int getSize() {
		return size;
	}
	public String getRobotState() {
		return state;
	}
	public int getTime() {
		return time;
	}
	public String toString()
	{
		return getId()+""+getName()+" "+this.size+" "+this.state+" "+this.time;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public void run()
	{
		/**
		 * threads playground for now
		 */
	
		//while(true)
		
			try {
				System.out.println(this.toString());
				Thread.sleep(time*100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
	}
}

