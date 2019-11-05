package slotMachine;

public class PachinkoCore extends Thread{
	
	// Attribute
	private int checkInterval = 10;// ms
	
	// Working Variable
	private boolean on, waitForResult = false;
	
	// Component
	private PachinkoSpinManager spinManager;
	private PachinkoActivator activator;
	
	// Constructor
	public PachinkoCore() {this.spinManager = new PachinkoSpinManager();}
	
	public void init() {
		this.on = true;
		this.spinManager.init();
		this.activator.init();
		this.start();
	}

	public void finish() {
		this.on = false;
		try {this.join();} catch (InterruptedException e) {e.printStackTrace();}
		this.spinManager.finish();
		this.activator.finish();
	}
	
	@Override 
	public void run() {
		while(this.on) {
			if(this.activator.isActivated()) {this.spinManager.activate(); this.waitForResult = true; this.activator.disactivate();}
			if(this.waitForResult && !this.spinManager.isSpinning()) {this.processResult(); this.waitForResult = false;}//Process Result Here
			this.sleep(this.checkInterval);
		}
	}
	
	private void processResult() {
		System.out.println("process");
	}

	public void connectScreen(PachinkoScreen...screens) {this.spinManager.addScreen(screens);}
	public void connectActivator(PachinkoActivator activator) {this.activator = activator;}
	private void sleep(int ms) {try {Thread.sleep(ms);} catch (InterruptedException e) {e.printStackTrace();}}
}
