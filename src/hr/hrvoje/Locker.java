package hr.hrvoje;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Locker {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.getContentPane().setPreferredSize(new Dimension(100, 50));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		frame.add(panel);
		final JButton button = new JButton("3");
		panel.add(button);
		final Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 3;
				while(i > 0){
					try{
						Thread.sleep(1000);
					} catch (InterruptedException e){
						System.exit(0);
					}
					i--;
					button.setText(""+i);
				}
				try {
					Runtime.getRuntime().exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
			}
		});
	}
}
