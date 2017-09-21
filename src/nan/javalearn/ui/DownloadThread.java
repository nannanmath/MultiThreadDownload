package nan.javalearn.ui;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class DownloadThread extends Thread{
	private DownloadInfo info = null;
	private UI ui = null;
	
	public DownloadThread(DownloadInfo info, UI ui) {
		this.info = info;
		this.ui = ui;
	}

	public void run() {
		try {
			URL url = new URL(info.getUrlStr());
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Range", "bytes=" + info.getStartPos() + "-" + info.getEndPos());
			InputStream is = conn.getInputStream();
			RandomAccessFile raf = new RandomAccessFile(info.getSavePath(), "rw");
			raf.seek(info.getStartPos());
			byte[] buf = new byte[1024];
			int len;
			while((len = is.read(buf)) !=  -1) {
				raf.write(buf, 0, len);
				ui.updateProgressBar(len);
			}
			is.close();
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
