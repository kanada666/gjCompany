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

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(72, 67, 55, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(72, 131, 55, 28);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(137, 67, 100, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(137, 129, 100, 30);
		contentPane.add(password);
		
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.帳號密碼 getText()
				 * 2.queryUser(帳號,密碼):member
				 * 3.!=null--->loginSuccess
				 * 4.null-->loginError
				 */
				String Username=username.getText();
				String Password=password.getText();
				member m=new implMember().queryMember(Username,Password);
				
				if(m!=null)
				{
					loginSuccess l= new loginSuccess();
					l.show();
					dispose();
				}
				else
				{
					loginError l= new loginError();
					l.show();
					dispose();
				}
			}
		});
		login.setFont(new Font("微软雅黑", Font.BOLD, 24));
		login.setBounds(282, 81, 87, 55);
		contentPane.add(login);
	}
}
