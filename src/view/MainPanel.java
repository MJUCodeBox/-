package view;

import java.awt.Color;

@SuppressWarnings("serial")
public class MainPanel extends CenterLayoutPanel{

	// Attributes
	private Color backgroundColor = Color.GRAY;
	
	// Components
	private InnerPanel innerPanel;
	
	// Constructor
	public MainPanel() {
		// Set Attributes
		this.setBackground(this.backgroundColor);
		
		// Create Components
		this.innerPanel = new InnerPanel();
		this.setInnerPanel(this.innerPanel);
	}

	public void initialize() {
		this.innerPanel.initialize();
	}
}
