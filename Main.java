import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//Размещение с использованием связанного списка
public class Main {
	private JFrame frame;
	static JTextField textId;
	private static JPanel panel;
	public static JTextArea textAreaWindow;
	private DataManager dataManager= new DataManager();;
	private BlockMemory Memory = new BlockMemory();
	private JTextField textFieldSize;
	private JTextField textFieldName;
	Graphics g;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 996, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new Manager(Memory);
		panel.setBounds(10, 11, 480, 184);
		frame.getContentPane().add(panel);

		JLabel labelWrite = new JLabel("Id");
		labelWrite.setBounds(789, 11, 26, 14);
		frame.getContentPane().add(labelWrite);
		textId = new JTextField();
		textId.setBounds(838, 11, 32, 20);
		textId.setColumns(10);
		frame.getContentPane().add(textId);
		
		JLabel lblSize = new JLabel("Размер файла");
		lblSize.setBounds(789, 45, 106, 14);
		frame.getContentPane().add(lblSize);
		textFieldSize = new JTextField();
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(898, 45, 42, 20);
		frame.getContentPane().add(textFieldSize);
		
		JLabel lblName = new JLabel("Имя файла");
		lblName.setBounds(789, 79, 66, 14);
		frame.getContentPane().add(lblName);
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(898, 79, 42, 20);
		frame.getContentPane().add(textFieldName);

		JLabel labelCMD = new JLabel("Вывод");
		labelCMD.setBounds(513, 11, 126, 14);
		frame.getContentPane().add(labelCMD);

		textAreaWindow = new JTextArea();
		textAreaWindow.setEnabled(false);
		textAreaWindow.setBounds(502, 38, 264, 363);
		frame.getContentPane().add(textAreaWindow);

		JButton buttonCreate = new JButton("Добавить файл");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldSize.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Заполните поле Размер");
					return;
				}
				if (textFieldName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Заполните поле Имя");
					return;
				}
				dataManager.CreateFile(Integer.parseInt(textFieldSize.getText()), textFieldName.getText());
				dataManager.cancelChoiceFile();
				panel.repaint();

			}
		});
		buttonCreate.setBounds(789, 113, 126, 23);
		frame.getContentPane().add(buttonCreate);

		JButton buttonDel = new JButton("Удалить файл");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Заполните поле id");
					return;
				}
				dataManager.DeleteFile(Integer.parseInt(textId.getText()));
				dataManager.cancelChoiceFile();
				panel.repaint();

			}
		});
		buttonDel.setBounds(789, 147, 126, 23);
		frame.getContentPane().add(buttonDel);

		JButton buttonChoose = new JButton("Выбрать файл");
		buttonChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Заполните поле id");
					return;
				}
				dataManager.ChoiceFile(Integer.parseInt(textId.getText()));
				panel.repaint();
			}
		});
		buttonChoose.setBounds(789, 181, 126, 23);
		frame.getContentPane().add(buttonChoose);
	}
}
