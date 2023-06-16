package dismtools.extend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BootAddFrame extends JFrame {
	private String SystemDir,EFIDir;
	private JPanel contentPane;
	private JTextField EFIDirText;
	private JTextField SystemDirText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BootAddFrame frame = new BootAddFrame();
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
	public BootAddFrame() {
		setTitle("\u6DFB\u52A0\u5F15\u5BFC\u8BB0\u5F55(\u4EC5\u9650\u4E8EUEFI+GPT)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 833, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(null);
		
		JButton SystemDirSetBotton = new JButton("\u8BBE\u7F6E\u7CFB\u7EDF\u8DEF\u5F84");
		SystemDirSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser SystemDirChooser=new JFileChooser(".");
				SystemDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				SystemDirChooser.showDialog(new JLabel(), "选择系统路径");
				SystemDir=SystemDirChooser.getSelectedFile().getPath();
				SystemDirText.setText(SystemDir);			
			}
		});
		SystemDirSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		SystemDirSetBotton.setBounds(64, 36, 138, 71);
		getContentPane().add(SystemDirSetBotton);
		
		JButton EFIDirSetBotton = new JButton("\u8BBE\u7F6EEFI\u8DEF\u5F84");
		EFIDirSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser EFIDirChooser=new JFileChooser(".");
				EFIDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				EFIDirChooser.showDialog(new JLabel(), "选择EFI路径");
				EFIDir=EFIDirChooser.getSelectedFile().getPath();
				EFIDirText.setText(EFIDir);			
			}
		});
		EFIDirSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		EFIDirSetBotton.setBounds(64, 148, 138, 71);
		getContentPane().add(EFIDirSetBotton);
		
		EFIDirText = new JTextField();
		EFIDirText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		EFIDirText.setEditable(false);
		EFIDirText.setColumns(10);
		EFIDirText.setBounds(212, 150, 544, 71);
		getContentPane().add(EFIDirText);
		
		SystemDirText = new JTextField();
		SystemDirText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		SystemDirText.setEditable(false);
		SystemDirText.setColumns(10);
		SystemDirText.setBounds(212, 36, 544, 71);
		getContentPane().add(SystemDirText);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Shell="cmd /c start bcdboot "+SystemDir+" /s "+EFIDir;
				System.out.println(Shell);
				System.out.println(CmdPrint.execCommand(Shell));
			}
		});//添加引导信息
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(523, 271, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(671, 271, 138, 71);
		getContentPane().add(BackBotton);
	}

}
