import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.*;

public class Surface extends JPanel{
	public static double aspectRatio = 1.5625;
	public Surface(){
		System.out.println("New Background created");
	}
	private String imageSrc = "src/images/BackGround.png";
	private BufferedImage bi;
	int cw, ch, winW, winH;
	double w, h;
    private void doDrawing(Graphics g) {
    	try {
            bi = ImageIO.read(new File(imageSrc));
            w = this.getWidth();
            h = this.getHeight();
        } catch (IOException e) {
        	System.out.println(System.getProperty("user.dir"));
            System.out.println("Image could not be read");
        }
    	
    	//Handles image scaling vertical and horizontal
    	if(w > h*aspectRatio){
    		w = h*aspectRatio;
    	}else{
    		h = w/aspectRatio;
    	}
        Graphics2D g2d = (Graphics2D) g;
        System.out.println((double)this.getWidth()/(double)this.getHeight());
        g2d.drawImage(bi, 0, 0, (int)w, (int)h, null);
    }

    @Override
    public void paintComponent(Graphics g) {
    	System.out.println("Painting components");
        super.paintComponent(g);
        doDrawing(g);
    }
}