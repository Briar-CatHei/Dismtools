package dismtools.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dismtools.extend.CmdPrint;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommitFrame extends JFrame {
	private String MountDir;
	private JPanel contentPane;
	private JTextField MountDirText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommitFrame frame = new CommitFrame();
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
	public CommitFrame() {
		
		setTitle("\u4FDD\u5B58\u6620\u50CF");
		getContentPane().setLayout(null);
		
		JButton MountDirSetBotton = new JButton("\u8BBE\u7F6E\u6302\u8F7D\u8DEF\u5F84");
		MountDirSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser MountDirChooser=new JFileChooser(".");
				MountDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				MountDirChooser.showDialog(new JLabel(), "—°‘Òπ“‘ÿ¬∑æ∂");
			    MountDir=MountDirChooser.getSelectedFile().getPath();
			    MountDirText.setText(MountDir);	
			}
		});
		MountDirSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		MountDirSetBotton.setBounds(32, 36, 138, 71);
		getContentPane().add(MountDirSetBotton);
		
		MountDirText = new JTextField();
		MountDirText.setEditable(false);
		MountDirText.setColumns(10);
		MountDirText.setBounds(180, 38, 544, 71);
		getContentPane().add(MountDirText);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Dismshell="cmd /c dism /commit-image"
						+ " /mountdir:"+ MountDir;
				System.out.println(Dismshell);
				System.out.println(CmdPrint.execCommand(Dismshell));
			}
			
		});
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(180, 181, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(442, 181, 138, 71);
		getContentPane().add(BackBotton);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

	}
}
