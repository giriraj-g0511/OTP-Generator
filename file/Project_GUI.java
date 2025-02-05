package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Project_GUI extends JFrame {

	GridBagConstraints gbc;

	public Project_GUI() {
		setFrame();
		addLabels();
		addDisplayField();
		addButton();
	}

	private void setFrame() {
		setTitle("OTP Generator");
		setSize(500, 300);
		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		setVisible(true);
	}

	JLabel title;

	private void addLabels() {
		title = new JLabel("Welcome to OTP Generator", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 35));
		title.setForeground(Color.DARK_GRAY);
		gbc.gridy = 0;
		add(title, gbc);
	}

	JTextField display;

	private void addDisplayField() {
		display = new JTextField("OTP", 10);
		display.setBounds(100, 100, 50, 27);
		display.setFont(new Font("Arial", Font.BOLD, 25));
		display.setForeground(Color.BLACK);
		display.setBackground(Color.WHITE);
		display.setHorizontalAlignment(JTextField.CENTER);
		display.setEditable(false);
		gbc.gridy = 1;
		add(display, gbc);
	}

	JButton generate;

	private void addButton() {
		generate = new JButton("Generate OTP");
		generate.setFont(new Font("Arial", Font.BOLD, 20));
		generate.setBackground(new Color(0x03AC13));
		generate.setForeground(Color.white);
		generate.setFocusPainted(false);
		gbc.gridy = 2;
		add(generate, gbc);
		generate.addActionListener(generateOTP());
	}

	private ActionListener generateOTP() {
		return (ActionEvent e) -> {
			String otp = display.getText();
			long otpValue = new Random().nextInt(999999);
			otp = "" + otpValue;

			while (otp.length() <= 5) {
				otp = otp + "0";
			}
			display.setText(otp);
			
			
		};
	}

	public static void main(String[] args) {
		new Project_GUI();
	}

}
