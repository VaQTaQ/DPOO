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
		setJMenuBar(menuBar);
		
		JMenu mnDoctores = new JMenu("Doctores");
		menuBar.add(mnDoctores);
		
		JMenuItem mntmAgregarDoctor = new JMenuItem("Agregar Doctor");
		mntmAgregarDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarDoctor agDoctor = new AgregarDoctor();
				agDoctor.setModal(true);
				agDoctor.setVisible(true);
			}
		});
		mnDoctores.add(mntmAgregarDoctor);
		
		JMenuItem mntmListarDoctores = new JMenuItem("Listar Doctores");
		mntmListarDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDoctores liDoctores = new ListarDoctores();
				liDoctores.setModal(true);
				liDoctores.setVisible(true);
			}
		});
		mnDoctores.add(mntmListarDoctores);
		
		JMenu mnCitasYConsultas = new JMenu("Servicio");
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
		
		JMenuItem mntmListarCitas = new JMenuItem("Listar Citas");
		mntmListarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCitas liCitas = new ListarCitas();
				liCitas.setModal(true);
				liCitas.setVisible(true);
			}
		});
		mnCitasYConsultas.add(mntmListarCitas);
		
		JMenuItem mntmListarConsultas = new JMenuItem("Listar Consultas");
		mntmListarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarConsultas liConsultas = new ListarConsultas();
				liConsultas.setModal(true);
				liConsultas.setVisible(true);
			}
		});
		mnCitasYConsultas.add(mntmListarConsultas);
		
		JMenu mnControl = new JMenu("Control ");
		menuBar.add(mnControl);
		
		JMenuItem mntmPacEnfermedadesVigilancia = new JMenuItem("Pac. Enfermedades Vigilancia");
		mnControl.add(mntmPacEnfermedadesVigilancia);
		
		JMenuItem mntmControlVacunas = new JMenuItem("Control Vacunas");
		mnControl.add(mntmControlVacunas);
		
		JMenuItem mntmNewListarPacientes = new JMenuItem("Listar Pacientes");
		mnControl.add(mntmNewListarPacientes);
		
		JMenu mnHistoral = new JMenu("Historial");
		menuBar.add(mnHistoral);
		
		JMenuItem mntmHistorialClinica = new JMenuItem("Historial Clinica");
		mnHistoral.add(mntmHistorialClinica);
		
		JMenuItem mntmReporte = new JMenuItem("Reportes");
		mnHistoral.add(mntmReporte);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Reportes Por Paciente");
		mnHistoral.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
