package slotMachine;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import paint.PaintTool;

public class PachinkoContent {

	// Attributes
	private enum ContentType {eImg, eText}
	private ContentType type;
	private BufferedImage img;
	private String text;
	private Font font;
	
	// Constructor
	public PachinkoContent(String text, Font font) {this.text = text; this.type = ContentType.eText; this.setFont(font);}
	public PachinkoContent(String fileName) {
		try {this.img = ImageIO.read(new File(fileName));} catch (IOException e) {e.printStackTrace();}
		this.type = ContentType.eImg;
	}
	
	public void draw(Graphics2D g, Rectangle2D screenBounds) {
		switch(this.type){
		case eImg : imgDraw(g, screenBounds); break;
		case eText : textDraw(g, screenBounds); break;
		}
	}
	
	private void imgDraw(Graphics2D g, Rectangle2D screenBounds) {PaintTool.paintImage(g, this.img, screenBounds, true);}
	private void textDraw(Graphics2D g, Rectangle2D screenBounds) {PaintTool.paintText(g, this.text, this.font, screenBounds);}
	
	// Getter & Setter
	public void setFont(Font font) {this.font=font;}
	public void setFont(String fontName, int style, int size) {this.font=new Font(fontName, style, size);}
}
