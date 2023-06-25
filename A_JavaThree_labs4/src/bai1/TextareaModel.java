package bai1;

public class TextareaModel {
	private String tenFile;
	private String content;
	
	public TextareaModel() {
		this.tenFile = "";
		this.content = "";
	}

	public TextareaModel(String tenFile, String content) {
		this.tenFile = tenFile;
		this.content = content;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
