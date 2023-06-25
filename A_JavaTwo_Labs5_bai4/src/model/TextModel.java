package model;

import java.util.Objects;

public class TextModel {
	private String fileName;
	private String content;

	public TextModel() {
		this.fileName = "";
		this.content = "";
	}

	public TextModel(String fileName, String content) {
		super();
		this.fileName = fileName;
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, fileName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextModel other = (TextModel) obj;
		return Objects.equals(content, other.content) && Objects.equals(fileName, other.fileName);
	}

	@Override
	public String toString() {
		return "TextModel [fileName=" + fileName + ", content=" + content + "]";
	}

}
