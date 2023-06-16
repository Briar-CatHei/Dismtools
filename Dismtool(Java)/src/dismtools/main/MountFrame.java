package dismtools.main;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;

import dismtools.extend.CmdPrint;

import javax.swing.event.ChangeEvent;

public class MountFrame extends JFrame {
	private String ImageFile,MountDir,Index,ReadOnlyOrNot;
	private Boolean ReadOnlyFlag;
	private JTextField ImageFileText;
	private JTextField MountDirText;
	private JTextField IndexText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MountFrame frame = new MountFrame();
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
	public MountFrame() {
		setResizable(false);
		setTitle("\u6302\u8F7D\u6620\u50CF");
		getContentPane().setLayout(null);
		
		JButton ImageFileSetBotton = new JButton("\u8BBE\u7F6E\u6620\u50CF\u6587\u4EF6");
		ImageFileSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser ImageFileChooser=new JFileChooser(".");
				ImageFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				ImageFileChooser.showDialog(new JLabel(), "选择映像文件");
			    ImageFile=ImageFileChooser.getSelectedFile().getPath();
			    ImageFileText.setText(ImageFile);			    
			}
		});
		ImageFileSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		ImageFileSetBotton.setBounds(33, 64, 138, 71);
		getContentPane().add(ImageFileSetBotton);
		
		ImageFileText = new JTextField();
		ImageFileText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		ImageFileText.setEditable(false);
		ImageFileText.setBounds(181, 64, 544, 71);
		getContentPane().add(ImageFileText);
		ImageFileText.setColumns(10);
		
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
		MountDirSetBotton.setBounds(33, 176, 138, 71);
		getContentPane().add(MountDirSetBotton);
		
		MountDirText = new JTextField();
		MountDirText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		MountDirText.setEditable(false);
		MountDirText.setColumns(10);
		MountDirText.setBounds(181, 178, 544, 71);
		getContentPane().add(MountDirText);
		
		JButton IndexSetBotton = new JButton("\u8BBE\u7F6E\u6620\u50CF\u5E8F\u53F7");
		IndexSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index=IndexText.getText();
				IndexText.setEditable(!IndexText.isEditable());
			}
		});
		IndexSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		IndexSetBotton.setBounds(33, 291, 138, 71);
		getContentPane().add(IndexSetBotton);
		
		IndexText = new JTextField();
		IndexText.setHorizontalAlignment(SwingConstants.CENTER);
		IndexText.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		IndexText.setColumns(1);
		IndexText.setBounds(181, 291, 66, 71);
		getContentPane().add(IndexText);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ReadOnlyFlag) ReadOnlyOrNot=" /readonly"; else ReadOnlyOrNot=" ";	
				String Dismshell="cmd /c dism.exe /mount-image"
				+" /imagefile:" + "\"" +ImageFile + "\""
				+" /mountdir:"+"\"" + MountDir + "\""
				+" /index:" + Index
				+ReadOnlyOrNot;
				System.out.println(Dismshell);
				System.out.println(CmdPrint.execCommand(Dismshell));
			}
		});
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(473, 448, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(621, 448, 138, 71);
		getContentPane().add(BackBotton);
		
		JCheckBox ReadonlyCheckBox = new JCheckBox("\u53EA\u8BFB");
		ReadonlyCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ReadOnlyFlag=ReadonlyCheckBox.isSelected();
			}
		});//指定“是否只读”参数
		ReadonlyCheckBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		ReadonlyCheckBox.setBounds(370, 291, 175, 81);
		getContentPane().add(ReadonlyCheckBox);
		setBounds(100, 100, 783, 566);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
}
