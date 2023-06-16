package dismtools.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dismtools.extend.CmdPrint;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckInfoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInfoFrame frame = new CheckInfoFrame();
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
	public CheckInfoFrame() {
		setTitle("\u67E5\u770B\u6620\u50CF\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(null);
		
		JButton CheckMountedImageBotton = new JButton("\u67E5\u770B\u5DF2\u6302\u8F7D\u7684\u6620\u50CF");
		CheckMountedImageBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Dismshell="dism /get-mountedimageinfo";
				System.out.println(Dismshell);
				System.out.println(CmdPrint.execCommand(Dismshell));
			}
		});
		CheckMountedImageBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		CheckMountedImageBotton.setBounds(57, 51, 234, 71);
		getContentPane().add(CheckMountedImageBotton);
		
		JButton CheckImageInfoBotton = new JButton("\u67E5\u770B\u6620\u50CF\u6587\u4EF6\u4FE1\u606F");
		CheckImageInfoBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckImageInfoFrame CheckImageInfo=new CheckImageInfoFrame ();
				CheckImageInfo.setVisible(true);
			}
		});//打开“查看映像信息”窗体
		CheckImageInfoBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		CheckImageInfoBotton.setBounds(57, 175, 234, 71);
		getContentPane().add(CheckImageInfoBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(57, 301, 234, 71);
		getContentPane().add(BackBotton);
	}

}
