package nan.javalearn.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class UI extends JFrame{
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
	// Progress bar
	private JProgressBar pbar = null;
	
	public UI() {
		init();
	}

	private void init() {
		this.setLocation(500, 500);
		this.setBounds(0, 0, 600, 250);
		this.setLayout(null);
		
		// URL.
		lblUrl = new JLabel();
		lblUrl.setBounds(10, 15, 50, 30);
		lblUrl.setText("URL:");
		tfUrl = new JTextField();
		tfUrl.setBounds(65, 15, 500, 30);
		tfUrl.setText("Please input URL ...");
		this.add(lblUrl);
		this.add(tfUrl);
		
		// Save path.
		lblSave = new JLabel();
		lblSave.setBounds(10, 50, 50, 30);
		lblSave.setText("Save:");
		tfSave = new JTextField();
		tfSave.setBounds(65, 50, 500, 30);
		tfSave.setText("Please input path to save ...");
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
			}
		});
		
		// Progress bar.
		pbar = new JProgressBar();
		pbar.setBounds(50, 155, 500, 20);
		this.add(pbar);
		
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
