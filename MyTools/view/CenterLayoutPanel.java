package view;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CenterLayoutPanel extends JPanel{

	// Associate
	private JPanel innerPanel;
	
	// Constructor 1
	public CenterLayoutPanel() {createTask();}
	
	// Constructor 2
	public CenterLayoutPanel(JPanel innerPanel) {
		createTask();
		this.setInnerPanel(innerPanel);
	}
	
	private void createTask() {
		this.addComponentListener(new ResizeHandler());
		this.setLayout(null);
	}

	private void arrangement() {
		int innerPanelWidth = this.innerPanel.getWidth(), innerPanelHeight = this.innerPanel.getHeight();
		int thisPanelWidth = this.getWidth(), thisPanelHeight = this.getHeight();
		int innerX = thisPanelWidth / 2 - innerPanelWidth / 2;
		int innerY = thisPanelHeight / 2 - innerPanelHeight / 2;
		this.innerPanel.setLocation(innerX, innerY);
	}
	
	// Getter & Setter
	public void setInnerPanel(JPanel innerPanel) {// InnerPanel Must Have Size
		this.innerPanel=innerPanel;
		this.add(this.innerPanel);
		this.arrangement();
	}
	
	// Inner Class
	private class ResizeHandler extends ComponentAdapter {
		public void componentResized(ComponentEvent e) {arrangement();}
	}
}
