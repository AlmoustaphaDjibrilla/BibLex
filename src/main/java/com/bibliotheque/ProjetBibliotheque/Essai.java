package com.bibliotheque.ProjetBibliotheque;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.controle.ControleLivres;

import javax.swing.JScrollBar;
import javax.swing.JTable;

public class Essai extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private ControleLivres controleLivres;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Essai frame = new Essai();
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
	public Essai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		controleLivres= new ControleLivres();
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(36, 47, 727, 358);
		contentPane.add(scrollBar);
		
		table = new JTable();
		table.setBounds(36, 47, 727, 358);
		table.setModel(controleLivres.getModeleLivre());
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		//contentPane.add(table);
		
		scrollBar.add(table);
	}
}
