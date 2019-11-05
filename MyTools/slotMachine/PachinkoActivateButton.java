package slotMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PachinkoActivateButton extends JButton implements PachinkoActivator{

	// Attributes
	private boolean activated;
	
	// Constructor
	public PachinkoActivateButton() {
		this.activated = false;
		this.addActionListener(new ActionHandler());
	}
	
	@Override public boolean isActivated() {return this.activated;}
	@Override public void disactivate() {this.activated = false;}
	
	private class ActionHandler implements ActionListener{
		@Override public void actionPerformed(ActionEvent e) {activated = true;}
	}
	
	// No Use
	@Override public void init() {}
	@Override public void finish() {}
}
