package nan.javalearn.ui;

public class DownloadInfo {
	private int index;
	private String urlStr;
	private String savePath;
	private int startPos;
	private int endPos;
	
	public DownloadInfo(){}

	public DownloadInfo(int index, String urlStr, String savePath, int startPos, int endPos) {
		this.index = index;
		this.urlStr = urlStr;
		this.savePath = savePath;
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getUrlStr() {
		return urlStr;
	}

	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}
	
	
	
}
