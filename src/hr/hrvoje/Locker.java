package hr.hrvoje;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Locker {
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		final JPanel panel = new JPanel();
		frame.getContentPane().setPreferredSize(new ScreenSize().getDimension());
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0, 1));
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
				button.setVisible(false);
				panel.revalidate();
				frame.revalidate();
				panel.repaint();
				frame.repaint();
				panel.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						lock();
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						lock();
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						lock();
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						lock();
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						lock();
						
					}
				});
				
				frame.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						lock();
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						lock();
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						lock();
						
					}
				});
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
	
	private static void lock(){
		try {
			Runtime.getRuntime().exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
