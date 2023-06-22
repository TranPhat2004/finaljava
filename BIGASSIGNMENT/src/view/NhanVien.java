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

import controler.employeecontroler;
import model.EmployeeModel;

public class NhanVien extends JFrame {



	private JPanel contentPane;
	private static JTable table;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtAddress;
	private JTextPane txtpnTn;
	private JTextPane txtpnNgySinh;
	private JTextPane txtpnaCh;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
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
	public NhanVien () {
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
				txtAddress.setText("");
				txtDate.setText("");
			}
		});
		nhaplai.setBounds(243, 259, 104, 23);
		contentPane.add(nhaplai);
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeModel nv = new EmployeeModel();
				nv.setMa_NV(Integer.parseInt(txtId.getText()));
				nv.setTen(txtName.getText());
				nv.setNgaySinh(txtDate.getText());
				nv.setDiaChi(txtAddress.getText());
				(new employeecontroler()).insert(nv);
				JOptionPane.showMessageDialog(null, "Nhập vào thành công");
				showData((new employeecontroler()).findAll());
			}
		});
		btnNewButton_1.setBounds(42, 319, 113, 61);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeModel nv = new EmployeeModel();
				nv.setMa_NV(Integer.parseInt(txtId.getText()));
				(new employeecontroler()).delete(nv);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				showData((new employeecontroler()).findAll());
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
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},

			},
			new String[] {
				"Ma_NV", "Ten", "NgaySinh", "DiaChi"
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
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(100, 164, 189, 23);
		contentPane.add(txtDate);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(100, 211, 189, 23);
		contentPane.add(txtAddress);
		
		JTextPane txtpnMNhnVin = new JTextPane();
		txtpnMNhnVin.setText("Mã Nhân Viên");
		txtpnMNhnVin.setBounds(10, 65, 85, 23);
		contentPane.add(txtpnMNhnVin);
		
		txtpnTn = new JTextPane();
		txtpnTn.setText("Tên");
		txtpnTn.setBounds(10, 115, 85, 23);
		contentPane.add(txtpnTn);
		
		txtpnNgySinh = new JTextPane();
		txtpnNgySinh.setText("Ngày Sinh");
		txtpnNgySinh.setBounds(10, 164, 85, 23);
		contentPane.add(txtpnNgySinh);
		
		txtpnaCh = new JTextPane();
		txtpnaCh.setText("Địa Chỉ");
		txtpnaCh.setBounds(10, 211, 85, 23);
		contentPane.add(txtpnaCh);
		
		JButton btnNewButton = new JButton("Hướng dẫn sử dụng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "HƯỚNG DẪN SỬ DỤNG."
						+ "\n Thêm: Nhập đầy đủ thông tin để thêm vào cơ sở dữ liệu"
						+ "\n Xóa: Nhập mã nhân viên của người cần xóa sau đó nhấn xóa để xóa khỏi cơ sở dữ liệu "
						+ "\n Thay đổi: Nhập mã nhân viên cần thay đổi vào ô mã nhân viên sau đó thay đổi dữ liệu"
						+ "\n LƯU Ý: Trường ngày sinh nên nhập vào với định dạng yyyy-mm-dd"); 
			}
		});
		btnNewButton.setBounds(592, 319, 150, 61);
		contentPane.add(btnNewButton);
		
		btnNewButton_3 = new JButton("Thay đổi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeModel nv = new EmployeeModel();
				nv.setMa_NV(Integer.parseInt(txtId.getText()));
				nv.setTen(txtName.getText());
				nv.setNgaySinh(txtDate.getText());
				nv.setDiaChi(txtAddress.getText());
				(new employeecontroler()).update(nv);
				JOptionPane.showMessageDialog(null, "Thay đổi thành công");
				showData((new employeecontroler()).findAll());
			}
			
		});
		btnNewButton_3.setBounds(357, 319, 113, 61);
		contentPane.add(btnNewButton_3);
		showData((new employeecontroler()).findAll());
	}
	public void showData(List<EmployeeModel>listnhanvien) {
		List<EmployeeModel> listEmployeeModel = new ArrayList<>();
		listEmployeeModel=listnhanvien;
		DefaultTableModel tableModel;	
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listnhanvien.forEach((NhanVien)->{
			tableModel.addRow(new Object[] {
				NhanVien.getMa_NV(),NhanVien.getTen(),NhanVien.getNgaySinh(),NhanVien.getDiaChi() 	
			});
		});
		
	}
}