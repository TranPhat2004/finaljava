package view;

import java.awt.EventQueue;
import view.NhanVien;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.NhanVien;
import view.DuAn;
import view.tienluong;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBounds(23, 11, 295, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(73, 11, 158, 250);
		panel.add(panel_1);
		panel_1.setBorder(new LineBorder(Color.BLACK));
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm Nhân Viên");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv = new NhanVien();
				nv.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 138, 58);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thêm Dự Án");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DuAn da = new DuAn();
				da.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 80, 138, 58);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thêm Tiền Lương");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tienluong money = new tienluong();
				money.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 149, 138, 58);
		panel_1.add(btnNewButton_2);
	}
}
