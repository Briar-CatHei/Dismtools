package dismtools.main;

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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;

import dismtools.extend.CmdPrint;

import javax.swing.event.ChangeEvent;

public class CheckImageInfoFrame extends JFrame {
	private String ImageFile,Index,IndexOrNot;
	private boolean IndexFlag;
	private JPanel contentPane;
	private JTextField ImageFileText;
	private JTextField IndexText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckImageInfoFrame frame = new CheckImageInfoFrame();
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
	public CheckImageInfoFrame() {
		setTitle("\u67E5\u770B\u6620\u50CF\u6587\u4EF6\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		getContentPane().setLayout(null);
		
		JButton ImageFileSetBotton = new JButton("\u8BBE\u7F6E\u6620\u50CF\u6587\u4EF6");
		ImageFileSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser ImageFileChooser=new JFileChooser(".");
				ImageFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				ImageFileChooser.showDialog(new JLabel(), "Ñ¡ÔñÓ³ÏñÎÄ¼þ");
			    ImageFile=ImageFileChooser.getSelectedFile().getPath();
			    ImageFileText.setText(ImageFile);	
			}
		});
		ImageFileSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		ImageFileSetBotton.setBounds(26, 28, 138, 71);
		getContentPane().add(ImageFileSetBotton);
		
		ImageFileText = new JTextField();
		ImageFileText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		ImageFileText.setEditable(false);
		ImageFileText.setColumns(10);
		ImageFileText.setBounds(174, 28, 544, 71);
		getContentPane().add(ImageFileText);
		
		JButton IndexSetBotton = new JButton("\u8BBE\u7F6E\u6620\u50CF\u5E8F\u53F7");
		IndexSetBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index=IndexText.getText();
				IndexText.setEditable(!IndexText.isEditable());
				IndexFlag=true;
			}
		});
		IndexSetBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		IndexSetBotton.setBounds(26, 135, 138, 71);
		getContentPane().add(IndexSetBotton);
		
		IndexText = new JTextField();
		IndexText.setHorizontalAlignment(SwingConstants.CENTER);
		IndexText.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		IndexText.setColumns(1);
		IndexText.setBounds(174, 135, 66, 71);
		getContentPane().add(IndexText);
		
		JButton OKBotton = new JButton("\u786E\u5B9A");
		OKBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IndexFlag) IndexOrNot=" /index:" + Index; else IndexOrNot=" ";
				String Dismshell="cmd /c dism.exe /get-imageinfo"
						+" /imagefile:" + "\"" +ImageFile + "\""
						+IndexOrNot;
				System.out.println(Dismshell);
				System.out.println(CmdPrint.execCommand(Dismshell));
			}
		});
		OKBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		OKBotton.setBounds(174, 246, 138, 71);
		getContentPane().add(OKBotton);
		
		JButton BackBotton = new JButton("\u8FD4\u56DE");
		BackBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BackBotton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		BackBotton.setBounds(436, 246, 138, 71);
		getContentPane().add(BackBotton);
		
		JCheckBox CheckImageAllCheckBox = new JCheckBox("\u67E5\u770B\u5F53\u524D\u6620\u50CF\u6240\u6709\u5E8F\u53F7");
		CheckImageAllCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				IndexSetBotton.setEnabled(!CheckImageAllCheckBox.isSelected());
				IndexText.setEnabled(!CheckImageAllCheckBox.isSelected());
			    IndexFlag=!CheckImageAllCheckBox.isSelected();
			}
		});
		CheckImageAllCheckBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		CheckImageAllCheckBox.setBounds(296, 135, 249, 81);
		getContentPane().add(CheckImageAllCheckBox);
	}
}
