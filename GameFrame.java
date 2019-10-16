import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
//	private int scale;
//	private int topInset;
//	private int frameWidth;
//	private int frameHeight;
//	
	private BufferedImage fence;
	


	public GameFrame() {
		setSize(600, 610);		
		try {
			fence = ImageIO.read(new File("D:\\AllisonData\\Pictures\\AP Computer Science\\Electric Fence.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed");
		}
	}
	
	public void paint(Graphics g) {
		int topInset = this.getInsets().top; //Inset value is found in paint method because it is not available during construction.
		int frameWidth = (int) this.getSize().getWidth();
		int frameHeight = (int) this.getSize().getHeight() - topInset;
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, frameWidth,  frameHeight + topInset); //Draws a background to cover previous drawing.
//		g.setColor(Color.BLACK);

		int fenceWidth = fence.getWidth();
		int fenceHeight = fence.getHeight();
		int scale = frameWidth / 13; // Divide by 13 instead of 12 to leave more room.
System.out.println();

		// Translates everything that is drawn next, so that the following drawing operations don't have to compensate for the top inset,
		// and the game board is not pressed up against the side of the window. (The "scale/2" part)
		g.translate(scale/2, topInset + 10); 
		int offset = scale * 11; //11 because there are 12 rows of fence, and the count starts at zero offset.
		System.out.println(offset);
		System.out.println(scale);
		System.out.println(topInset);


		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 12; j++) {
				g.drawImage(fence, 
						scale*j, i*offset, scale*(j+1), i*offset + scale, // Rectangle where it will be drawn after scaling down from original size
						0, 0, fenceWidth, fenceHeight, 		  // Original Size
						null); 
				g.drawImage(fence, 
						i*offset, scale*j, i*offset + scale, scale*(j+1), // Rectangle where it will be drawn after scaling down from original size
						0, 0, fenceWidth, fenceHeight, 		  // Original Size
						null);

			}
		}
		
	}
	
	// Private Methods Below -------------------------------------------------------------------
	
	
	
}
