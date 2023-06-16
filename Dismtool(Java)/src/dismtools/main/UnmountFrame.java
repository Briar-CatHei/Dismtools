package dismtools.main;

import java.awt.EventQueue;




import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;

import dismtools.extend.CmdPrint;

import javax.swing.event.ChangeEvent;

public class UnmountFrame extends JFrame {
	private String MountDir,CommitOrNot;
	private boolean CommitFlag;
	private JTextField MountDirText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnmountFrame frame = new UnmountFrame();
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
	public UnmountFrame() {
		setResizable(false);
		setTitle("\u5378\u8F7D\u6620\u50CF");
		getContentPane().setLayout(null);
		
		JButton MountDirSetBotton = new JButton("\u8BBE\u7F6E\u6302\u8F7D\u8DEF\u5F84");
		MountDirSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser MountDirChooser=new JFileChooser(".");
				MountDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				MountDirChooser.showDialog(new JLabel(), "选择挂载路径");
			    MountDir=MountDirChooser.getSelectedFile().getPath();
			    MountDirText.setText(MountDir);			    
			}
		});
		MountDirSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		MountDirSetBotton.setBounds(33, 87, 138, 71);
		getContentPane().add(MountDirSetBotton);
		
		MountDirText = new JTextField();
		MountDirText.setEditable(false);
		MountDirText.setColumns(10);
		MountDirText.setBounds(181, 89, 544, 71);
		getContentPane().add(MountDirText);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CommitFlag) CommitOrNot=" /commit" ; else CommitOrNot=" /discard";
				String Dismshell="cmd /c dism /unmount-image"
						+ " /mountdir:"+ MountDir
						+ CommitOrNot;
				System.out.println(Dismshell);
				System.out.println(CmdPrint.execCommand(Dismshell));
			}
		});
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(462, 308, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(610, 308, 138, 71);
		getContentPane().add(BackBotton);
		
		JCheckBox CommitCheckBox = new JCheckBox("\u4FDD\u5B58");
		CommitCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			CommitFlag=CommitCheckBox.isSelected();
			}
		});//指定“是否保存”参数
		CommitCheckBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		CommitCheckBox.setBounds(181, 197, 175, 81);
		getContentPane().add(CommitCheckBox);
		setBounds(100, 100, 783, 446);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

