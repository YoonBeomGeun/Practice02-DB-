package 상정;

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

import 상품정보UI.ProductDAO;
import 상품정보UI.ProductVO;

public class productUI {

	public static void main(String[] args) {
		//JFrame, FlowLayout, Font, JLabel, JTextField, JButton
		JFrame f = new JFrame();
		f.setTitle("나의 회원정보 UI");
		f.setSize(300, 750);
		f.getContentPane().setBackground(Color.green);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		JLabel l1 = new JLabel("상품입니다~~");
		JLabel l2 = new JLabel("아이디 =>");
		JLabel l3 = new JLabel("이름 =>");
		JLabel l4 = new JLabel("내용 =>");
		JLabel l5 = new JLabel("가격 =>");
		JLabel l6 = new JLabel("회사 =>");
		JLabel l7 = new JLabel("이미지 =>");
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		JTextField t5 = new JTextField(10);
		JTextField t6 = new JTextField(10);
		
		t1.setBackground(Color.pink);
		t1.setForeground(Color.white);
		t2.setBackground(Color.pink);
		t2.setForeground(Color.white);
		t3.setBackground(Color.pink);
		t3.setForeground(Color.white);
		t4.setBackground(Color.pink);
		t4.setForeground(Color.white);
		t5.setBackground(Color.pink);
		t5.setForeground(Color.white);
		t6.setBackground(Color.pink);
		t6.setForeground(Color.white);
		
		JButton b1 = new JButton("상품 등록 요청");
		JButton b2 = new JButton("상품 삭제 요청");
		JButton b3 = new JButton("상품 수정 요청");
		JButton b4 = new JButton("상품 검색 요청");
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
		l6.setFont(font);
		l7.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		t5.setFont(font);
		t6.setFont(font);
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
		f.add(l6);
		f.add(t5);
		f.add(l7);
		f.add(t6);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		// 버튼 클릭 시 동작------------------------------
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String name = t2.getText();
				String content = t3.getText();
				int price = Integer.parseInt(t4.getText());
				String company = t5.getText();
				String img = t6.getText();
				
				상정.ProductDAO dao = new 상정.ProductDAO();
				ProductDTO bag = new ProductDTO();
				bag.setId(id);
				bag.setName(name);
				bag.setContent(content);
				bag.setPrice(price);
				bag.setCompany(company);
				bag.setImg(img);
				
				int result = dao.insert(bag);
				if(result == 1) {
					JOptionPane.showMessageDialog(f, "상품 등록 성공!");
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				
				상정.ProductDAO dao = new 상정.ProductDAO();
				ProductDTO bag = new ProductDTO();
				bag.setId(id);
				int result = dao.delete(bag);
				if(result == 1) {
					JOptionPane.showMessageDialog(f, "상품 삭제 성공!");
				}
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				
				상정.ProductDAO dao = new 상정.ProductDAO();
				ProductDTO bag = new ProductDTO();
				bag.setId(id);
				int result = dao.update(bag);
				if(result==1) {
					JOptionPane.showMessageDialog(f, "상품 수정 성공!");
				}
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				상정.ProductDAO dao = new 상정.ProductDAO();
				ProductDTO bag = dao.select(id);
				JOptionPane.showMessageDialog(f, bag);
			}
		});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
