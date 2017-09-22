package nan.javalearn.ui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class UI extends JFrame {
	// URL location.
	private JLabel lblUrl = null;
	private JTextField tfUrl = null;
	// Save path.
	private JLabel lblSave = null;
	private JTextField tfSave = null;
	// Thread count.
	private JLabel lblThrdCnt = null;
	private JTextField tfThrdCnt = null;
	// Button to start download.
	private JButton btnStart = null;
	// Button to pause download.
	private JButton btnPause = null;
	// Progress bar
	private JProgressBar[] pbars = null;
	// Status.
	private JLabel lblStatus = null;

	// Pause flag.
	private boolean flagPause = false;
	
	// Complete thread number.
	private int complete = 0;

	public UI() {
		init();
	}

	/*
	 * Initialize.
	 */
	private void init() {
		this.setLocation(500, 500);
		this.setBounds(0, 0, 600, 500);
		this.setLayout(null);

		// URL.
		lblUrl = new JLabel();
		lblUrl.setBounds(10, 15, 50, 30);
		lblUrl.setText("URL:");
		tfUrl = new JTextField();
		tfUrl.setBounds(65, 15, 500, 30);
		//tfUrl.setText("Please input URL ...");
		tfUrl.setText("http://localhost:8000/test.mp4");
		this.add(lblUrl);
		this.add(tfUrl);

		// Save path.
		lblSave = new JLabel();
		lblSave.setBounds(10, 50, 50, 30);
		lblSave.setText("Save:");
		tfSave = new JTextField();
		tfSave.setBounds(65, 50, 500, 30);
		//tfSave.setText("Please input path to save ...");
		tfSave.setText("E:/TMP/test_cp.mp4");
		this.add(lblSave);
		this.add(tfSave);

		// Thread count.
		lblThrdCnt = new JLabel();
		lblThrdCnt.setBounds(10, 85, 80, 30);
		lblThrdCnt.setText("Thread num:");
		tfThrdCnt = new JTextField();
		tfThrdCnt.setBounds(95, 85, 30, 30);
		tfThrdCnt.setText("3");
		this.add(lblThrdCnt);
		this.add(tfThrdCnt);

		// Button for download.
		btnStart = new JButton();
		btnStart.setBounds(20, 120, 80, 30);
		btnStart.setText("Start");
		this.add(btnStart);
		// Button Event.
		btnStart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String url = tfUrl.getText();
				String savePath = tfSave.getText();
				int thrdNum = Integer.valueOf(tfThrdCnt.getText());
				DownloadManager mgr = new DownloadManager(url, savePath,
						thrdNum, UI.this);
				mgr.startDownload();
			}
		});

		// Button for pause.
		btnPause = new JButton();
		btnPause.setBounds(105, 120, 80, 30);
		btnPause.setText("Pause");
		this.add(btnPause);
		// Button Event.
		btnPause.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				flagPause = !flagPause;
				btnPause.setText(flagPause == true ? "Continue" : "Pause");
				lblStatus.setText(flagPause == true ? "Pause ..."
						: "Downloading ...");
			}
		});

		// Status.
		lblStatus = new JLabel();
		lblStatus.setBounds(50, 155, 200, 30);
		lblStatus.setText("Click 'Start' to download.");
		this.add(lblStatus);

		this.setVisible(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public synchronized void updateProgressBar(int len, int index) {
		int length = pbars[index].getValue() + len;
		pbars[index].setValue(length);
		if (length >= pbars[index].getMaximum()) {
			complete++;
			if (complete == pbars.length) {
				lblStatus.setText("Download Complete!");
				processFinish();
				complete = 0;
			}
		}
	}

	private void processFinish() {
		for(Component comp : pbars) {
			this.remove(comp);
		}
	}

	public boolean isFlagPause() {
		return flagPause;
	}

	public void addProgressBar(List<DownloadInfo> infos) {
		pbars = new JProgressBar[infos.size()];
		for (int i = 0; i < pbars.length; ++i) {
			pbars[i] = new JProgressBar();
			pbars[i].setBounds(50, 155 + i * (20 + 5), 500, 20);
			pbars[i].setMaximum(infos.get(i).getEndPos()
					- infos.get(i).getStartPos() + 1);
			this.add(pbars[i]);
		}

		// Status.
		lblStatus.setBounds(50, 155 + pbars.length * (20 + 5), 200, 30);
		lblStatus.setText("Downloading ...");
		//this.add(lblStatus);

		// Repaint Window.
		this.repaint();
	}
}
