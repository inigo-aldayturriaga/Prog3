package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelCoche extends JLabel {
	
	public LabelCoche() {
		ImageIcon im = new ImageIcon("C:\\Users\\msald\\Desktop\\workspace-eclipse\\PROG II\\Practica0\\src\\coche.png");
		this.setIcon(im);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			final BufferedImage dimg = ImageIO
					.read(new File("C:\\Users\\msald\\Desktop\\workspace-eclipse\\PROG II\\Practica0\\src\\coche.png"));
			final java.awt.Image img = dimg.getScaledInstance(100,100,1);
			
			
			this.setIcon(new ImageIcon(img));
		}catch (final IOException E) {
			E.printStackTrace();
		}
	}

}
