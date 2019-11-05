package slotMachine;

import java.util.Vector;

public class PachinkoSpinManager {

	// Attribute
	private boolean spinning = false;
	private int spinSpeed = 50, spinInterval = 10;
	
	// Component
	private Vector<PachinkoScreen> screens;
	private SpinLoop spinLoop;
	
	// Working Variable
	private int stopIndex = 0;
	private int[] result;
	
	// Constructor
	public PachinkoSpinManager() {this.screens = new Vector<PachinkoScreen>();}
	
	public void init() {for(PachinkoScreen screen : this.screens) {screen.init();}}
	public void finish() {for(PachinkoScreen screen : this.screens) {screen.finish();}}
	
	public void activate() {
		if(!this.spinning) {this.spinLoop = new SpinLoop(); this.spinLoop.start(); this.spinning = true;}
		else {this.stopIndex++; if(this.stopIndex == this.screens.size()) {waitUntilThreadStop();}}
	}
	
	public void spinLoop() {
		this.result = new int[this.screens.size()];
		int stopIndexTemp = 0;
		while(true) {
			int nowStopIndex = this.stopIndex;// 중간에 값이 바뀌는걸 막기 위함.
			if(stopIndexTemp != nowStopIndex) {this.stop(stopIndexTemp); stopIndexTemp = nowStopIndex;}
			if(nowStopIndex < this.screens.size()) {
				for(int i = nowStopIndex; i < this.screens.size(); i++) {this.screens.get(i).spin(this.spinSpeed);}
				this.sleep(this.spinInterval);
			}else {break;}
		}
		this.stopIndex = 0;
		this.spinning = false;
	}
	
	private void stop(int index) {
		PachinkoScreen target = this.screens.get(index);
		this.result[index] = (int)(Math.random()*(target.getContentNum()));
		target.show(this.result[index]);
	}

	public int[] getResult() {return this.result;}
	public boolean isSpinning() {return this.spinning;}
	public void addScreen(PachinkoScreen...screens) {for(PachinkoScreen screen : screens) {this.screens.add(screen);}}
	private void waitUntilThreadStop() {try {this.spinLoop.join();} catch (InterruptedException e) {e.printStackTrace();}}
	private void sleep(int ms) {try {Thread.sleep(ms);} catch (InterruptedException e) {e.printStackTrace();}}
	private class SpinLoop extends Thread{@Override public void run() {spinLoop();}}
}
