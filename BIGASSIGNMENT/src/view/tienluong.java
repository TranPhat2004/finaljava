package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controler.participationcontroler;

import model.ParticipationModel;


public class tienluong extends JFrame {



	private JPanel contentPane;
	private static JTable table;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtmoney;
	private JTextPane txtpnTn;
	private JTextPane txtpnNgySinh;
	private JButton btnNewButton_2_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tienluong frame = new tienluong();
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
	public tienluong () {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 822, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton nhaplai = new JButton("Nhập lại");
		nhaplai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtId.setText("");
				txtmoney.setText("");
			}
		});
		nhaplai.setBounds(243, 259, 104, 23);
		contentPane.add(nhaplai);
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipationModel money = new ParticipationModel();
				money.setMa_DA(Integer.parseInt(txtId.getText()));
				money.setMa_NV(Integer.parseInt(txtName.getText()));
				money.setTien_Luong(Integer.parseInt(txtmoney.getText()));
				(new participationcontroler()).insert(money);
				JOptionPane.showMessageDialog(null, "Nhập vào thành công");
				showData((new participationcontroler()).findAll());
			}
		});
		btnNewButton_1.setBounds(42, 319, 113, 61);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipationModel money = new ParticipationModel();
				money.setMa_DA(Integer.parseInt(txtId.getText()));
				money.setMa_NV(Integer.parseInt(txtName.getText()));
				(new participationcontroler()).delete(money);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				showData((new participationcontroler()).findAll());
			}
		});
		btnNewButton_2.setBounds(201, 319, 113, 61);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 37, 427, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Ma_DA", "Ma_NV", "Tien Luong"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
		txtId = new JTextField();
		txtId.setBounds(100, 65, 189, 23);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(100, 115, 189, 23);
		contentPane.add(txtName);
		
		txtmoney = new JTextField();
		txtmoney.setColumns(10);
		txtmoney.setBounds(100, 164, 189, 23);
		contentPane.add(txtmoney);
		
		txtpnTn = new JTextPane();
		txtpnTn.setText("Mã Dự Án");
		txtpnTn.setBounds(10, 65, 85, 23);
		contentPane.add(txtpnTn);
		
		JTextPane txtpnMNhnVin = new JTextPane();
		txtpnMNhnVin.setText("Mã Nhân Viên");
		txtpnMNhnVin.setBounds(10, 115, 85, 23);
		contentPane.add(txtpnMNhnVin);
		
		txtpnNgySinh = new JTextPane();
		txtpnNgySinh.setText("Lương");
		txtpnNgySinh.setBounds(10, 164, 85, 23);
		contentPane.add(txtpnNgySinh);
		
		JButton btnNewButton_2_1 = new JButton("Thay đổi");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipationModel money = new ParticipationModel();
				money.setMa_DA(Integer.parseInt(txtId.getText()));
				money.setMa_NV(Integer.parseInt(txtName.getText()));
				money.setTien_Luong(Integer.parseInt(txtmoney.getText()));
				(new participationcontroler()).update(money);
				JOptionPane.showMessageDialog(null, "Thay đổi thành công");
				showData((new participationcontroler()).findAll());
			}
		});
		btnNewButton_2_1.setBounds(357, 319, 113, 61);
		contentPane.add(btnNewButton_2_1);
		
		btnNewButton_2_2 = new JButton("Hướng dẫn sử dụng");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "HƯỚNG DẪN SỬ DỤNG:"
						+ "\n Nhập các giá trị tương ứng vào các ô để nhập vào cơ sở dữ liệu sau đó nhấn nút thêm"
						+ "\n Để xóa thì nhập Mã nhân viên tương ứng để xóa dữ liệu khỏi cơ sở dữ liệu"
						+ "\n Để thay đổi tiền lương thì nhập Mã Nhân viên và Mã dự án tương ứng sau đó thay đổi tiền lương tương ứng");
			}
		});
		btnNewButton_2_2.setBounds(592, 319, 150, 61);
		contentPane.add(btnNewButton_2_2);
		showData((new participationcontroler()).findAll());
	}
	public void showData(List<ParticipationModel>listduan) {
		List<ParticipationModel> listProjectModel = new ArrayList<>();
		listProjectModel=listduan;
		DefaultTableModel tableModel;	
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listduan.forEach((money)->{
			tableModel.addRow(new Object[] {
				money.getMa_DA(),money.getMa_NV(),money.getTien_Luong()	
			});
		});
		
	}
}