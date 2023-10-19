package 게시판정보;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 게시판정보.BbsDAO;
import 회원정보.MemberDAO;

public class 게시판정보UI {

	public static void main(String[] args) {
		//JFrame, FlowLayout, Font, JLabel, JTextField, JButton
		JFrame f = new JFrame();
		f.setTitle("나의 회원정보 UI");
		f.setSize(300, 600);
		f.getContentPane().setBackground(Color.green);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		JLabel l1 = new JLabel("게시판입니다~~");
		JLabel l2 = new JLabel("게시글 번호");
		JLabel l3 = new JLabel("게시글 제목");
		JLabel l4 = new JLabel("게시글 내용");
		JLabel l5 = new JLabel("게시글 작성자");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		
		t1.setBackground(Color.pink);
		t1.setForeground(Color.white);
		t2.setBackground(Color.pink);
		t2.setForeground(Color.white);
		t3.setBackground(Color.pink);
		t3.setForeground(Color.white);
		t4.setBackground(Color.pink);
		t4.setForeground(Color.white);
		
		JButton b1 = new JButton("글쓰기 요청");
		JButton b2 = new JButton("글삭제 요청");
		JButton b3 = new JButton("글수정 요청");
		JButton b4 = new JButton("글검색 요청");
		b1.setForeground(Color.blue);
		b2.setForeground(Color.red);
		b3.setForeground(Color.green);
		b4.setForeground(Color.green);
		
		Font font = new Font("굴림", Font.BOLD, 25);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		
		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(l5);
		f.add(t4);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		// 버튼 클릭 시 동작------------------------------
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//b1을 클릭했을 때 처리 내용을 넣어줌
				
				//1. 입력한 값을 가져온다.
				String title = t2.getText();
				String content = t3.getText();
				String writer = t4.getText();
				
				//2. db처리하는 부품을 사용한다.
				BbsDAO dao = new BbsDAO();
				
				//3. db처리하는 부품에  입력한 값을 주면서 db해 달라고 요청
				dao.insert(title, content, writer);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//삭제할 no 입력받기
				int no = Integer.parseInt(t1.getText());
				
				// DAO이용, no를 전달하여 delete
				BbsDAO dao = new BbsDAO();
				dao.delete(no);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = t2.getText();
				String content = t4.getText();
				int no = Integer.parseInt(t1.getText());
				BbsDAO dao = new BbsDAO();
				dao.update(title, content, no);
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(JOptionPane.showInputDialog("번호를 입력"));
				BbsDAO dao = new BbsDAO();
				BbsVO bag = dao.select(no);
				JOptionPane.showMessageDialog(f, bag);
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
