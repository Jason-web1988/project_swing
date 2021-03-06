package project_swing.TableTotal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

public class TableTotalFrame extends JFrame {

	private JPanel contentPane;
	private TableTotalPanel panel;
	private TableManagement panel_1;



	public TableTotalFrame() {
		initComponents();
	}

	private void initComponents() {
		setMinimumSize(new Dimension(800, 700));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 689, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new TableTotalPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		panel_1 = new TableManagement();
		contentPane.add(panel_1, BorderLayout.CENTER);
	}

}
