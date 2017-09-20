package nan.javalearn.ui;

public class DownloadInfo {
	private String urlStr;
	private String savePath;
	private int startPos;
	private int endPos;
	
	public DownloadInfo(){}

	public DownloadInfo(String urlStr, String savePath, int startPos, int endPos) {
		super();
		this.urlStr = urlStr;
		this.savePath = savePath;
		this.startPos = startPos;
		this.endPos = endPos;
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
