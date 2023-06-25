package review;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CTLReview implements ActionListener{
	private ImageReview imageReview;
	
	public CTLReview(ImageReview imageReview) {
		this.imageReview = imageReview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("New")) {
			this.imageReview.disPlayImage();
		}
	}

}
