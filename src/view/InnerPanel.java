package view;

import java.awt.Color;

import javax.swing.JPanel;

import constants.PachinkoScreens;
import slotMachine.PachinkoActivateButton;
import slotMachine.PachinkoCore;

@SuppressWarnings("serial")
public class InnerPanel extends JPanel{

	// Attributes
	private Color backgroundColor = Color.CYAN;
	private int width = 400, height = 400;
	
	// Components
	private PachinkoCore pachinkoCore;
	private PachinkoActivateButton btn;
	
	// Constructor
	public InnerPanel() {
		// Set Attributes
		this.setBackground(this.backgroundColor);
		this.setSize(this.width, this.height);
		this.setLayout(null);
		
		// Create Components
		this.pachinkoCore = new PachinkoCore();
		
		for(PachinkoScreens screen : PachinkoScreens.values()) {
			this.pachinkoCore.connectScreen(screen.getScreen());
			this.add(screen.getScreen());
		}
		
		this.btn = new PachinkoActivateButton();
		this.btn.setBounds(100, 300, 100, 50);
		this.pachinkoCore.connectActivator(this.btn);
		this.add(this.btn);
	}
	
	public void initialize() {
		this.pachinkoCore.init();
	}
}
