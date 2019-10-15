import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GameMaster {

	public static void main(String[] args) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("D:\\AllisonData\\Pictures\\AP Computer Science\\Electric Fence.png	"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed");
		}
	}

}
