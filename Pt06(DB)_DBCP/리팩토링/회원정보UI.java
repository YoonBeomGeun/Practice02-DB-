package 리팩토링;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class 회원정보UI {

	public static void main(String[] args) {
		//JFrame, FlowLayout, Font, JLabel, JTextField, JButton
		JFrame f = new JFrame();
		f.setTitle("나의 회원정보 UI");
		f.setSize(300, 600);
		f.getContentPane().setBackground(Color.green);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		JLabel l1 = new JLabel();
		ImageIcon icon = new ImageIcon("nav1.png");
		l1.setIcon(icon);
		
		JLabel l2 = new JLabel("회원 아이디");
		JLabel l3 = new JLabel("회원 패스워드");
		JLabel l4 = new JLabel("회원이름");
		JLabel l5 = new JLabel("회원TEL");
		
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
		
		JButton b1 = new JButton("회원가입 요청");
		JButton b2 = new JButton("회원탈퇴 요청");
		JButton b3 = new JButton("회원수정 요청");
		JButton b4 = new JButton("회원검색 요청");
		b1.setForeground(Color.blue);
		b2.setForeground(Color.red);
		b3.setForeground(Color.green);
		b4.setForeground(Color.green);
		
		Font font = new Font("굴림", Font.BOLD, 25);
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
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//b1을 클릭했을 때 처리 내용을 넣어줌
				
				//1. 입력한 값을 가져온다.
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				
				//2. db처리하는 부품을 사용한다.
				MemberDAO dao = new MemberDAO();
				//dao에 전달할 데이터를 묶어 전달하기
				//1. 가방 만들기
				//2. 가방에 넣기
				//3. 가방 전달하기
				MemberVO bag = new MemberVO();
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
				//3. db처리하는 부품에  입력한 값을 주면서 db해 달라고 요청
				//dao.insert(id, pw, name, tel);
				int result = dao.insert(bag);
				if(result == 1) {
					JOptionPane.showMessageDialog(f, "회원가입 성공!!");
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//탈퇴할 id 입력받기
				String id = t1.getText();
				
				// DAO이용, id를 전달하여 delete
				MemberDAO dao = new MemberDAO();
				MemberVO bag = new MemberVO();
				bag.setId(id);
				int result = dao.delete(bag);
				if(result==1) {
					JOptionPane.showMessageDialog(f, "회원탈퇴 성공");
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tel = t4.getText();
				String id = t1.getText();
				MemberDAO dao = new MemberDAO();
				MemberVO bag = new MemberVO();
				bag.setTel(tel);
				bag.setId(id);
				int result = dao.update(bag);
				if(result == 1) {
					JOptionPane.showMessageDialog(f, "수정 완료");
				}
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//검색하고 싶은 id 입력받아 저장
				String id = JOptionPane.showInputDialog("id 입력");
				//MemberDAO 사용
				MemberDAO dao = new MemberDAO();
				//one(id) 호출 - row 하나만 선택
				MemberVO bag = dao.one(id);	// bag
				JOptionPane.showMessageDialog(f, bag);
			}
		});
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
