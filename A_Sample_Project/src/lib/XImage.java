package lib;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.sound.midi.Patch;
import javax.swing.ImageIcon;

import model.NhanVienModel;

public class XImage {
	public static Image resize(Image originalImage, int targetWidth, int targetHeight) {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		return resultingImage;
	}

	public static byte[] toByteArray(Image img, String type) throws IOException {
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bimage.createGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bimage, type, baos);
		byte[] imageInByte = baos.toByteArray();
		return imageInByte;
	}

	public static Image createImageFromByteArray(byte[] data, String type) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		BufferedImage bimage2 = ImageIO.read(bis);
		Image img = bimage2.getScaledInstance(bimage2.getWidth(), bimage2.getHeight(), Image.SCALE_SMOOTH);
		return img;
	}

	public static boolean saveImage(String src) {
		File file = new File("src\\IMG_JPG\\Logos", src);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			Path source = Paths.get(src);
			Path destination = Paths.get(file.getAbsolutePath());                                     
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static ImageIcon readImage(String fileName) {
		File file = new File("src\\IMG_JPG\\Logos", fileName);
		return new ImageIcon(file.getAbsolutePath());
	}
	
}
