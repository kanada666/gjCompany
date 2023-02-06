package Controller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.member.implMember;
import Model.member;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMemberUI frame = new addMemberUI();
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
	public addMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("微軟正黑體 Light", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 46, 56, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 20));
		lblNewLabel_1.setBounds(100, 102, 56, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(100, 161, 56, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("地址");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(100, 226, 56, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("手機");
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(100, 336, 56, 24);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("電話");
		lblNewLabel_2_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(100, 394, 56, 24);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		name = new JTextField();
		name.setBounds(176, 46, 120, 25);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(176, 106, 120, 25);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(176, 165, 120, 25);
		contentPane.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(176, 227, 120, 75);
		contentPane.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(176, 337, 120, 25);
		contentPane.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(176, 394, 120, 25);
		contentPane.add(phone);
		
		JButton add = new JButton("註冊會員");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.username-->getText
				 * 2.帳號判斷-->queryusername():boolean
				 * 3.true-->重複-->addError
				 * 4.false-->接收所有資料-->new member-->add()-->addSuccess
				 */
				
				String Username=username.getText();
				if(new implMember().queryUser(Username))
				{
					addError error=new addError();
					error.show();
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Mobile=mobile.getText();
					String Phone=phone.getText();
					
					member m= new member(Name,Username,Password,Address,Mobile,Phone);
					
					new implMember().add(m);
					
					addSuccess success=new addSuccess();
					success.show();
					dispose();
				}
			}
		});
		add.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		add.setBounds(148, 477, 120, 50);
		contentPane.add(add);
	}

}
