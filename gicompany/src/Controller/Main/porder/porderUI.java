package Controller.Main.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.porder.implPorder;
import Model.porder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class porderUI extends JFrame {

	private JPanel contentPane;
	private JTextField desk;
	private JTextField A;
	private JTextField B;
	private JTextField C;
	private JTextField uDesk;
	private JTextField ua;
	private JTextField ub;
	private JTextField uc;
	private JTextField id;
	private JTextField idd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					porderUI frame = new porderUI();
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
	public porderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 124, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("點餐系統");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 77, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("桌號");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 60, 35, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("A餐");
		lblNewLabel_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 100, 35, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("B餐");
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 134, 35, 15);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("C餐");
		lblNewLabel_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 170, 35, 15);
		panel.add(lblNewLabel_1_1_1_1);
		
		JButton add = new JButton("新增");
		add.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		add.setBounds(15, 208, 77, 23);
		panel.add(add);
		
		desk = new JTextField();
		desk.setHorizontalAlignment(SwingConstants.CENTER);
		desk.setText("桌");
		desk.setColumns(10);
		desk.setBounds(47, 60, 50, 21);
		panel.add(desk);
		
		A = new JTextField();
		A.setHorizontalAlignment(SwingConstants.CENTER);
		A.setColumns(10);
		A.setBounds(47, 100, 50, 21);
		panel.add(A);
		
		B = new JTextField();
		B.setHorizontalAlignment(SwingConstants.CENTER);
		B.setColumns(10);
		B.setBounds(47, 134, 50, 21);
		panel.add(B);
		
		C = new JTextField();
		C.setHorizontalAlignment(SwingConstants.CENTER);
		C.setColumns(10);
		C.setBounds(47, 164, 50, 21);
		panel.add(C);
		
		JButton add_1 = new JButton("查詢");
		add_1.setForeground(new Color(192, 192, 192));
		add_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		add_1.setBounds(15, 246, 77, 23);
		panel.add(add_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(144, 10, 430, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton selectAll = new JButton("查詢全部");
		selectAll.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		selectAll.setBounds(0, 0, 85, 23);
		panel_1.add(selectAll);
		
		JButton update = new JButton("修改");
		update.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		update.setBounds(0, 33, 85, 23);
		panel_1.add(update);
		
		JButton delete = new JButton("刪除");
		delete.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		delete.setBounds(215, 0, 85, 23);
		panel_1.add(delete);
		
		JLabel lblNewLabel_2 = new JLabel("桌號");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_2.setBounds(187, 36, 35, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("A餐");
		lblNewLabel_2_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(105, 67, 30, 15);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("B餐");
		lblNewLabel_2_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(187, 67, 30, 15);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel cUpadate = new JLabel("C餐");
		cUpadate.setHorizontalAlignment(SwingConstants.CENTER);
		cUpadate.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		cUpadate.setBounds(267, 67, 30, 15);
		panel_1.add(cUpadate);
		
		uDesk = new JTextField();
		uDesk.setHorizontalAlignment(SwingConstants.CENTER);
		uDesk.setText("桌");
		uDesk.setColumns(10);
		uDesk.setBounds(222, 33, 40, 21);
		panel_1.add(uDesk);
		
		ua = new JTextField();
		ua.setHorizontalAlignment(SwingConstants.CENTER);
		ua.setColumns(10);
		ua.setBounds(137, 67, 40, 21);
		panel_1.add(ua);
		
		ub = new JTextField();
		ub.setHorizontalAlignment(SwingConstants.CENTER);
		ub.setColumns(10);
		ub.setBounds(217, 64, 40, 21);
		panel_1.add(ub);
		
		uc = new JTextField();
		uc.setColumns(10);
		uc.setBounds(297, 64, 40, 21);
		panel_1.add(uc);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID");
		lblNewLabel_2_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(105, 36, 35, 15);
		panel_1.add(lblNewLabel_2_2);
		
		id = new JTextField();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setColumns(10);
		id.setBounds(135, 36, 40, 21);
		panel_1.add(id);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 410, 183);
		panel_1.add(scrollPane);
		
		JTextArea showAll = new JTextArea();
		scrollPane.setViewportView(showAll);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("ID");
		lblNewLabel_2_2_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(310, 3, 35, 15);
		panel_1.add(lblNewLabel_2_2_1);
		
		idd = new JTextField();
		idd.setHorizontalAlignment(SwingConstants.CENTER);
		idd.setColumns(10);
		idd.setBounds(345, 0, 40, 21);
		panel_1.add(idd);
	
		//add
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取UI--->getText
				 * 2.A,B,C--->轉型--->int
				 * 3.new porder
				 * 2.add(p)
				 */
				
				String DESK=desk.getText();
				int a=Integer.parseInt(A.getText());
				int b=Integer.parseInt(B.getText());
				int c=Integer.parseInt(C.getText());
				porder p=new porder(DESK,a,b,c);
				new implPorder().add(p);
				
			}
		});
		
		//selestAll
		selectAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.List<porder> l--->selsetAll90
				 * 2.String--->for-each--->顯示
				 * 3.List--->轉陣列--->toArray-->多用於顯示、統計分析
				 */
				
				/*String show="";
				for(porder p:l)
				{
					show=show+"id"+p.getId()
					+"\t桌號:"+p.getDesk()
					+"\tA:"+p.getA()
					+"\tB:"+p.getB()
					+"\tC:"+p.getC()+"\n";
				}
				showAll.setText(show);*/
				
				//3.List--->轉陣列--->toArray-->多用於顯示、統計分析
				List<porder> l=new implPorder().selectAll();//搜尋擷取資料庫全部內容
				
				/* toArray Object[]類型
				 * Object[] o=l.toArray();
				 * System.out.println(((porder)o[0]).getA()); //o是Object，所以精靈只會找有object的method--->要把(porder)o[0] boxing成((porder)o[0])精靈才能找到getA
				 */
				
				//toArray <T>泛型 (首選使用)
				porder[] p=l.toArray(new porder[l.size()]); //這句= porder[] p=new porder[3]; 在p底下創l(l=資料庫內容))數量的陣列(Ex:資料庫的全部列的資料)
				//System.out.println(p[0].getId()+"\t"+p[0].getDesk());//印出資料庫地0列的id,和第0列的桌號
				
				String show=" ";
				int sum=0;
				for(porder P:p)
				{
					show=show+"id:"+P.getId()+"\t桌號:"+P.getDesk()+
							"\tA:"+P.getA()+
							"\tB:"+P.getB()+
							"\tC:"+P.getC()+"\n";
				}
				
				//針對單一列或單一項目做顯示或統計 Ex:針對資料庫內，所有訂單的A餐做總數統計
				for(int i=0;i<p.length;i++)
				{
					sum=sum+p[i].getA();
				}
				showAll.setText(show+"\nA總共:"+sum);
			}
		});

		//update
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			/*
			 * 1.擷取--->所有getText
			 * 2.ua,ub,uc,id--->String--->int
			 * 3.selectId--->id
			 * 4.porder--->set修改
			 * 5.update
			 */
			
			String Desk=uDesk.getText();
			int A=Integer.parseInt(ua.getText());
			int B=Integer.parseInt(ub.getText());
			int C=Integer.parseInt(uc.getText());
			int ID=Integer.parseInt(id.getText());
			
			porder p=new implPorder().selectId(ID);//在資料庫內搜尋指定id
			p.setDesk(Desk);//修改指定id的桌號欄內容
			p.setA(A);
			p.setB(B);
			p.setC(C);
			
			new implPorder().update(p);
			}
		});
		
		//delete
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取--->id--->轉型int
				 * 2.delete
				 */
				int Id=Integer.parseInt(idd.getText());
				new implPorder().delete(Id);
			}
		});
	}
}
