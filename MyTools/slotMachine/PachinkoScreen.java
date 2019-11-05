package slotMachine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PachinkoScreen extends JPanel {

	// Attributes
	private int allContentLong, nowTopLong = 0, contentHeight;

	// Components
	private Vector<PachinkoContent> contents;
	private Rectangle2D contentRectangle;
	
	// Constructor
	public PachinkoScreen() {commonConstructor();}
	public PachinkoScreen(PachinkoContent...contents) { commonConstructor(); this.addContents(contents);}
	private void commonConstructor() {this.contents = new Vector<PachinkoContent>();}
	
	public void init() {
		this.contentRectangle = new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight());
		this.contentHeight = this.getHeight();
		this.resetAllContentLong();
	}
	public void finish() {}
	
	public void spin(int move) {this.updateNowTopLong(move); this.repaint();}
	private void drawContent(Graphics2D g, int contentNum, Rectangle2D rect) {this.contents.get(contentNum).draw(g, rect); g.draw(rect);}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int nowContentNum = this.nowTopLong / this.contentHeight, left = this.nowTopLong % this.contentHeight;
		int nextContentNum = (nowContentNum == this.contents.size() - 1) ? 0 : nowContentNum + 1;
		int nowContentY = left, nextContentY = nowContentY - this.contentHeight;
		this.drawContent(g2d, nowContentNum, new Rectangle2D.Double(0,nowContentY,this.getWidth(),this.getHeight()));
		this.drawContent(g2d, nextContentNum, new Rectangle2D.Double(0,nextContentY,this.getWidth(),this.getHeight()));
	}

	// Getter & Setter
	public int getContentNum() {return this.contents.size();}
	public void show(int index) {this.nowTopLong = this.contentHeight * index; repaint();}
	public void updateNowTopLong(int move) {this.nowTopLong = (this.nowTopLong + move) % this.allContentLong;}
	public void setContents(PachinkoContent...contents) {this.contents.clear(); this.addContents(contents);}
	public void setContents(Vector<PachinkoContent> contents) {this.contents=contents; resetAllContentLong();}
	public void addContents(PachinkoContent...contents) {for(PachinkoContent c : contents) {this.contents.add(c);} resetAllContentLong();}
	private void resetAllContentLong() {if(this.contentRectangle!=null) {this.allContentLong = (int) (this.contents.size() * this.contentRectangle.getHeight());}}
}
