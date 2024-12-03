package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Clinica ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim = getToolkit().getScreenSize();
		setBounds(100, 100, 450, 300);
		setSize(dim.width, dim.height - 45);
		setLocationRelativeTo(null);


		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 153, 255));
		setJMenuBar(menuBar);
		
		JMenu mnDoctores = new JMenu("Doctor");
		mnDoctores.setForeground(new Color(0, 51, 255));
		mnDoctores.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnDoctores);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar Citas");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCitasXDoctor listCitXDoc = new ListarCitasXDoctor();
				listCitXDoc.setModal(true);
				listCitXDoc.setVisible(true);
			}
		});
		mnDoctores.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar Consultas");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarConsultasXDoctor listConsXDoc = new ListarConsultasXDoctor();
				listConsXDoc.setModal(true);
				listConsXDoc.setVisible(true);
			}
		});
		mnDoctores.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Reportes Por Paciente");
		mnDoctores.add(mntmNewMenuItem_9);
		
		JMenuItem mntmPacEnfermedadesVigilancia = new JMenuItem("Pac. Enfermedades Vigilancia");
		mnDoctores.add(mntmPacEnfermedadesVigilancia);
		
		JMenu mnCitasYConsultas = new JMenu("Servicio");
		mnCitasYConsultas.setForeground(new Color(0, 51, 255));
		mnCitasYConsultas.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnCitasYConsultas);
		
		JMenuItem mntmHacerCita = new JMenuItem("Hacer Cita");
		mntmHacerCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerCita agCita = new HacerCita();
				agCita.setModal(true);
				agCita.setVisible(true);
				
			}
		});
		mnCitasYConsultas.add(mntmHacerCita);
		
		JMenuItem mntmHacerConsulta = new JMenuItem("Hacer Consulta");
		mntmHacerConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerConsulta agConsulta = new HacerConsulta();
				agConsulta.setModal(true);
				agConsulta.setVisible(true);
				
			}
		});
		mnCitasYConsultas.add(mntmHacerConsulta);
		
		JMenu mnHistoral = new JMenu("Historial");
		mnHistoral.setForeground(new Color(0, 51, 255));
		mnHistoral.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnHistoral);
		
		JMenuItem mntmHistorialClinica = new JMenuItem("Historial Clinica");
		mnHistoral.add(mntmHistorialClinica);
		
		JMenuItem mntmReporte = new JMenuItem("Reportes(XPacientes)");
		mnHistoral.add(mntmReporte);
		
		JMenuItem mntmListarCitas = new JMenuItem("Listar Citas Totales");
		mnHistoral.add(mntmListarCitas);
		
		JMenuItem mntmListarConsultas = new JMenuItem("Listar Consultas Totales");
		mnHistoral.add(mntmListarConsultas);
		mntmListarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarConsultas liConsultas = new ListarConsultas();
				liConsultas.setModal(true);
				liConsultas.setVisible(true);
			}
		});
		mntmListarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCitas liCitas = new ListarCitas();
				liCitas.setModal(true);
				liCitas.setVisible(true);
			}
		});
		
		JMenu mnNewMenu = new JMenu("Administracion");
		mnNewMenu.setForeground(new Color(0, 51, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAgregarDoctor = new JMenuItem("Agregar Doctor");
		mnNewMenu.add(mntmAgregarDoctor);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Admin");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewListarPacientes = new JMenuItem("Listar Pacientes Totales");
		mnNewMenu.add(mntmNewListarPacientes);
		
		JMenuItem mntmListarDoctores = new JMenuItem("Listar Doctores");
		mnNewMenu.add(mntmListarDoctores);
		
		JMenuItem mntmListarPacientesB = new JMenuItem("Listar Pacientes B. Vigilancia");
		mnNewMenu.add(mntmListarPacientesB);
		
		JMenuItem mntmControlVacunas = new JMenuItem("Control Vacunas");
		mntmControlVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlVacuna conVacuna = new ControlVacuna();
				conVacuna.setModal(true);
				conVacuna.setVisible(true);
			}
		});
		mnNewMenu.add(mntmControlVacunas);
		mntmListarDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDoctores liDoctores = new ListarDoctores();
				liDoctores.setModal(true);
				liDoctores.setVisible(true);
			}
		});
		mntmAgregarDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarDoctor agDoctor = new AgregarDoctor();
				agDoctor.setModal(true);
				agDoctor.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
