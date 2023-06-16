package dismtools;



import java.io.*;
import javax.swing.*;

import dismtools.main.ApplyFrame;
import dismtools.main.CheckInfoFrame;
import dismtools.main.CommitFrame;
import dismtools.main.MountFrame;
import dismtools.main.RepairFrame;
import dismtools.main.UnmountFrame;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setResizable(false);
		setTitle("DISM\u5C0F\u7A0B\u5E8F(Java)");
		getContentPane().setLayout(null);
		
		JButton MountButton = new JButton("\u6302\u8F7D\u6620\u50CF");
		MountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MountFrame Mount=new MountFrame();
				Mount.setVisible(true);//�򿪡�����ӳ�񡱴���
			}
		});
		MountButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		MountButton.setBounds(39, 30, 131, 70);
		getContentPane().add(MountButton);
		
		JButton UnmountButton = new JButton("\u5378\u8F7D\u6620\u50CF");
		UnmountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnmountFrame Unmount=new UnmountFrame();
				Unmount.setVisible(true);//�򿪡�ж��ӳ�񡱴���
			}
			
		});
		UnmountButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		UnmountButton.setBounds(224, 30, 131, 70);
		getContentPane().add(UnmountButton);
		
		JButton CommitButton = new JButton("\u4FDD\u5B58\u6620\u50CF");
		CommitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommitFrame Commit=new CommitFrame();
				Commit.setVisible(true);//�򿪡�����ӳ�񡱴���
			}
		});
		CommitButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		CommitButton.setBounds(39, 142, 131, 70);
		getContentPane().add(CommitButton);
		
		JButton ApplyButton = new JButton("\u91CA\u653E\u6620\u50CF");
		ApplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyFrame Apply=new ApplyFrame();
				Apply.setVisible(true);//�򿪡��ͷ�ӳ�񡱴���
			}
		});
		ApplyButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		ApplyButton.setBounds(224, 142, 131, 70);
		getContentPane().add(ApplyButton);
		
		JButton CheckInfoButton = new JButton("\u67E5\u770B\u6620\u50CF\u4FE1\u606F");
		CheckInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckInfoFrame CheckInfo=new CheckInfoFrame ();
				CheckInfo.setVisible(true);//�򿪡��鿴ӳ����Ϣ������
			}
		});
		CheckInfoButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		CheckInfoButton.setBounds(39, 259, 131, 70);
		getContentPane().add(CheckInfoButton);
		
		JButton RepairButton = new JButton("\u7B80\u5355\u4FEE\u590D");
		RepairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepairFrame Repair=new RepairFrame();
				Repair.setVisible(true);//�򿪡����޸�������
			}
		});
		RepairButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		RepairButton.setBounds(224, 259, 131, 70);
		getContentPane().add(RepairButton);
		setBounds(100, 100, 428, 395);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

	}
}
