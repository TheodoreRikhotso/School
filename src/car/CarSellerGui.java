

package car;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
  @author Giovanni Caire - TILAB
 */
class CarSellerGui extends JFrame {	
	private static final long serialVersionUID = 1L;

	private CarSellerAgent myAgent;
	
	private JTextField carNameField;
	
	CarSellerGui(CarSellerAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
            
                
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Car Name:"));
		carNameField = new JTextField(15);
		p.add(carNameField);
		
		getContentPane().add(p, BorderLayout.CENTER);
                
                
		
		JButton addButton = new JButton("View All Cars");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
//					
					myAgent.ViewAllCars();
//					titleField.setText("");
//					priceField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(CarSellerGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
			
                                }
			}
		} );
		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
                
                JButton searchButton = new JButton("Search Cars");
		searchButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String title = carNameField.getText().trim();
//					String price = priceField.getText().trim();
					myAgent.SearchCars(title);
					carNameField.setText("");
//					priceField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(CarSellerGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
			
                                }
			}
		} );
		p = new JPanel();
		p.add(searchButton);
                getContentPane().add(p, BorderLayout.LINE_END);
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}
