package lab_pop05;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.RechargeStation;
import models.Robot;
import models.SimulationEngine;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class SimulationFrame extends JFrame 
{
	private DefaultTableModel tableModelRecharge ;
	private DefaultTableModel tableModelRobot;
	private JPanel contentPane;
	private JTable robotsTable;
	private JTable stationsTable;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SimulationFrame(int stationsAmount, int robotAmount) 
	{
		SimulationEngine engine= new SimulationEngine(stationsAmount);
		Robot robots[]= fillArray(robotAmount, stationsAmount);
		RechargeStation stations[]=engine.getStation();
		
		
		
		
		
		
		tableModelRecharge=new DefaultTableModel();
		Object[] column= {"Stacja", "przestrzeñ dla robota"};//setupujemy kolumny
		
		tableModelRecharge.setColumnIdentifiers(column);
		tableModelRobot=new DefaultTableModel();
		Object[] columnRobot= {"Nazwa", "Rozmiar", "Status", "Czas"};//setupujemy kolumny
		
		tableModelRobot.setColumnIdentifiers(columnRobot);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		stationsTable = new JTable(tableModelRecharge);
		scrollPane.setViewportView(stationsTable);
		for(int i=0; i<stationsAmount*3; i++)
		{
			tableModelRecharge.addRow(new Object[] {stations[i].getSpace(), stations[i].getRobotSpace()});
		}
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		robotsTable = new JTable(tableModelRobot);
		for(int i=0; i<robotAmount; i++)
		{
			tableModelRobot.addRow(new Object[] {robots[i].getName(), robots[i].getSize(), robots[i].getRobotState(), robots[i].getTime()});
		}
		scrollPane_1.setViewportView(robotsTable);
	}
	private Robot[] fillArray(int ammount ,int stations)
	{
		Robot temp[]=new Robot[ammount];
		char x='A';
		for(int i=0; i<ammount; i++)
		{
			temp[i]=new Robot(Character.toString(x++), randomize(stations, 1), "Work", randomize(80, 40));
			
			System.out.println(temp[i]);
		}
		return temp;
		
	}
	private int randomize(int stationsAmount, int minimum)
	{
		int random = (int)(Math.random() * stationsAmount + minimum);
		return random;
	}
	
}
