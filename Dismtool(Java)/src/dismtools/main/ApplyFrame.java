package dismtools.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dismtools.extend.BootAddFrame;
import dismtools.extend.CmdPrint;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ApplyFrame extends JFrame {
	private String ImageFile,ApplyDir,Index;
	private JPanel contentPane;
	private JTextField ImageFileText;
	private JTextField ApplyDirText;
	private JTextField IndexText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyFrame frame = new ApplyFrame();
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
	public ApplyFrame() {
		setResizable(false);
		setTitle("\u91CA\u653E\u6620\u50CF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
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
		ImageFileSetBotton.setBounds(25, 51, 138, 71);
		getContentPane().add(ImageFileSetBotton);
		
		ImageFileText = new JTextField();
		ImageFileText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		ImageFileText.setEditable(false);
		ImageFileText.setColumns(10);
		ImageFileText.setBounds(173, 51, 544, 71);
		getContentPane().add(ImageFileText);
		
		JButton MountDirSetBotton = new JButton("\u8BBE\u7F6E\u91CA\u653E\u8DEF\u5F84");
		MountDirSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser ApplyDirChooser=new JFileChooser(".");
				ApplyDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				ApplyDirChooser.showDialog(new JLabel(), "选择释放路径");
				ApplyDir=ApplyDirChooser.getSelectedFile().getPath();
				ApplyDirText.setText(ApplyDir);		
			}
		});
		MountDirSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		MountDirSetBotton.setBounds(25, 163, 138, 71);
		getContentPane().add(MountDirSetBotton);
		
		ApplyDirText = new JTextField();
		ApplyDirText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		ApplyDirText.setEditable(false);
		ApplyDirText.setColumns(10);
		ApplyDirText.setBounds(173, 165, 544, 71);
		getContentPane().add(ApplyDirText);
		
		JButton IndexSetBotton = new JButton("\u8BBE\u7F6E\u6620\u50CF\u5E8F\u53F7");
		IndexSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index=IndexText.getText();
				IndexText.setEditable(!IndexText.isEditable());
			}
		});
		IndexSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		IndexSetBotton.setBounds(25, 278, 138, 71);
		getContentPane().add(IndexSetBotton);
		
		IndexText = new JTextField();
		IndexText.setHorizontalAlignment(SwingConstants.CENTER);
		IndexText.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		IndexText.setColumns(1);
		IndexText.setBounds(173, 278, 66, 71);
		getContentPane().add(IndexText);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Dismshell="cmd /c dism.exe /apply-image"
						+" /imagefile:" + "\"" +ImageFile + "\""
						+" /index:" + Index
						+" /applydir:" +ApplyDir ;				
						System.out.println(Dismshell);
						System.out.println(CmdPrint.execCommand(Dismshell));
			}
			
		});
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(473, 436, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.setSize(138, 71);
		BackBotton.setLocation(621, 436);
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		setBounds(100, 100, 783, 566);
		getContentPane().add(BackBotton);
		
		JButton DiskpartBotton = new JButton("\u542F\u52A8diskpart");
		DiskpartBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd /k start diskpart.exe");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		DiskpartBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		DiskpartBotton.setBounds(579, 278, 138, 71);
		getContentPane().add(DiskpartBotton);
		
		JButton BootAddBotton = new JButton("\u6DFB\u52A0\u5F15\u5BFC\u8BB0\u5F55");
		BootAddBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BootAddFrame BootAdd=new BootAddFrame();
				BootAdd.setVisible(true);
			}
		});
		BootAddBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BootAddBotton.setBounds(321, 278, 138, 71);
		getContentPane().add(BootAddBotton);
	}

}
