package nan.javalearn.ui;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class DownloadeManager {
	private String urlStr;
	private String savePath;
	private int thrdCount;
	
	private int totalContentLength;

	
	private List<DownloadInfo> infos = new ArrayList<DownloadInfo>();
	
	public DownloadeManager(){}

	public DownloadeManager(String urlStr, String savePath, int thrdCount) {
		this.urlStr = urlStr;
		this.savePath = savePath;
		this.thrdCount = thrdCount;
		
		prepareDownload();
	}

	private void prepareDownload() {
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			totalContentLength = conn.getContentLength();
			
			int blockContent = totalContentLength / thrdCount;
			int startPos = 0;
			int endPos = 0;
			for (int i = 0; i < thrdCount; ++i) {
				if(i != (thrdCount -1)){ // Not the last thread.
					 startPos = i * blockContent;
					 endPos = (i + 1) * blockContent - 1;
				} else { // The last thread.
					startPos = i * blockContent;
					endPos = totalContentLength - 1;
				}
				
				DownloadInfo info = new DownloadInfo();
				info.setUrlStr(urlStr);
				info.setSavePath(savePath);
				info.setStartPos(startPos);
				info.setEndPos(endPos);
				
				infos.add(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startDownload() {
		
	}
	
	
	
	
}
