package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHelper {
	public static Image resize(Image originalImage, int targetWidth, int targetHeight) {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		return resultingImage;
	}
	
	public static byte[] toByteArray(Image img, String type) throws IOException {
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bimage.createGraphics();
		g.drawImage(img, 0, 0,null);
		g.dispose();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bimage, type, baos);
		byte[] imageInByte= baos.toByteArray();
		return imageInByte;
	}
	
	public static Image createImageFromByteArray(byte[] data, String type) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		BufferedImage bimage2 = ImageIO.read(bis);
		Image img = bimage2.getScaledInstance(bimage2.getWidth(), bimage2.getHeight(), Image.SCALE_SMOOTH);
		return img;
	}
	
}
