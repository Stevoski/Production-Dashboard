/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author Stevoski
 */
public class Preeve extends JWindow {

	public Preeve(int duration) {
		JPanel content = (JPanel) getContentPane();
		JLabel label6 = new JLabel();
		int width = 406;
		int height = 220;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		JLabel copyrt = new JLabel("Costing System", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.ITALIC, 35));
		JLabel label2 = new JLabel(new ImageIcon(new ImageIcon("favicon.ico").getImage().getScaledInstance(406, 168, java.awt.Image.SCALE_SMOOTH)));
//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mtn.png")));
		content.add(copyrt, BorderLayout.PAGE_START);
		content.add(label2, BorderLayout.CENTER);

		setBackground(new Color(0, 255, 0, 0));
		setVisible(true);
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			this.dispose();
		}
		this.dispose();
	}
}