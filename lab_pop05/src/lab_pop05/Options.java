package lab_pop05;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Options extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JLabel serviceLabel ;
	
	private JTextField rechargeTextField;
	private JTextField robotTextField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options option= new Options();
					option.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Options() 
	{
		
		setBounds(100, 100, 239, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			serviceLabel = new JLabel("Ilo\u015B\u0107 stanowisk \u0142aduj\u0105cych");
			contentPanel.add(serviceLabel);
		}
		{
			rechargeTextField = new JTextField();
			contentPanel.add(rechargeTextField);
			rechargeTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Ile ma by\u0107 robot\u00F3w");
			contentPanel.add(lblNewLabel);
		}
		{
			robotTextField = new JTextField();
			contentPanel.add(robotTextField);
			robotTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int robots=Integer.parseInt( robotTextField.getText());
						int fields=Integer.parseInt(rechargeTextField.getText());
						SimulationFrame frame= new SimulationFrame(fields, robots);
						frame.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
