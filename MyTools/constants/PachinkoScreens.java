package constants;

import slotMachine.PachinkoContent;
import slotMachine.PachinkoScreen;

public enum PachinkoScreens {
	Screen1(50,50,100,160, PachinkoContents.PACHINKO_CONTENTS),
	Screen2(150,50,100,160, PachinkoContents.PACHINKO_CONTENTS),
	Screen3(250,50,100,160, PachinkoContents.PACHINKO_CONTENTS),
	;
	
	private PachinkoScreen screen;
	private PachinkoScreens(int x, int y, int w, int h, PachinkoContent[] contents) {
		this.screen = new PachinkoScreen();
		this.screen.setBounds(x, y, w, h);
		this.screen.addContents(contents);
	}
	public PachinkoScreen getScreen() {return this.screen;}
}
