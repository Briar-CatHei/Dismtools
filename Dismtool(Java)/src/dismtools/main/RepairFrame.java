package dismtools.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import dismtools.extend.CmdPrint;

import javax.swing.event.ChangeEvent;

public class RepairFrame extends JFrame {
	private String MountDir,OnlineOrNot,HealthCheckOrNot;
	private boolean OnlineFlag,HealthCheckFlag;
	private JPanel contentPane;
	private JTextField MountDirText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepairFrame frame = new RepairFrame();
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
	public RepairFrame() {
		setResizable(false);
		setTitle("\u7B80\u5355\u4FEE\u590D");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 833, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(null);
		
		MountDirText = new JTextField();
		MountDirText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		MountDirText.setEditable(false);
		MountDirText.setColumns(10);
		MountDirText.setBounds(198, 83, 544, 71);
		getContentPane().add(MountDirText);
		
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
		MountDirSetBotton.setBounds(50, 81, 138, 71);
		getContentPane().add(MountDirSetBotton);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OnlineFlag) OnlineOrNot=" /online" ; else OnlineOrNot=" /image:"+MountDir;
				String Dismshell1="dism "+OnlineOrNot+" /cleanup-image"+" /scanhealth";
				String Dismshell2="dism "+OnlineOrNot+" /cleanup-image"+" /restorehealth";
				if(HealthCheckFlag) {
					System.out.println(Dismshell1+" && "+Dismshell2);
					System.out.println(CmdPrint.execCommand("cmd /c "+Dismshell1+" && "+Dismshell2));
				}else {
					System.out.println(CmdPrint.execCommand("cmd /c "+Dismshell1));
				}
			}
		});
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(523, 376, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(671, 376, 138, 71);
		getContentPane().add(BackBotton);
		
		JCheckBox OnlineCheckBox = new JCheckBox("\u8054\u673A\u6620\u50CF");
		OnlineCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				MountDirSetBotton.setEnabled(!OnlineCheckBox.isSelected());
				MountDirText.setEnabled(!OnlineCheckBox.isSelected());
				OnlineFlag=OnlineCheckBox.isSelected();
			}
		});//指定是否联机修复
		OnlineCheckBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		OnlineCheckBox.setBounds(50, 196, 138, 81);
		getContentPane().add(OnlineCheckBox);
		
		JCheckBox HealthCheckBox = new JCheckBox("\u68C0\u67E5\u6620\u50CF\u5065\u5EB7");
		HealthCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				HealthCheckFlag=HealthCheckBox.isSelected();
			}
		});
		HealthCheckBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		HealthCheckBox.setBounds(198, 196, 138, 81);
		getContentPane().add(HealthCheckBox);
		
		JButton RepairBotton = new JButton("\u4FEE\u590D\u5F53\u524D\u7CFB\u7EDF");
		RepairBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(CmdPrint.execCommand("cmd /c start sfc /scannow"));
			}
		});
		RepairBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		RepairBotton.setBounds(456, 202, 138, 71);
		getContentPane().add(RepairBotton);
		
	}

}
