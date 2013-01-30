import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ImageDisplay extends JFrame {

	Image image;

	public ImageDisplay(byte[] img) {
		image = Toolkit.getDefaultToolkit().createImage(img);
		setSize(400, 400);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, 228, 312, null);
	}

}
