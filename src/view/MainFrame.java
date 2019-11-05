package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	// Attributes
	private int width = 800, height = 800;
	
	// Component
	private MainPanel mainPanel;
	
	// Constructor
	public MainFrame() {
		// Set Attributes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(this.width, this.height);
		this.setLocationRelativeTo(null);
		
		// Create Component
		this.mainPanel = new MainPanel();
		this.add(this.mainPanel);
	}
	
	public void initialize() {
		this.mainPanel.initialize();
		this.setVisible(true);
	}
}
