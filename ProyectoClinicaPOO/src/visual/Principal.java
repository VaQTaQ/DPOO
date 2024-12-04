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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

import lógico.User;
import lógico.Clinica;
public class Principal extends JFrame {

    private JPanel contentPane;
    private Dimension dim;
    private User usuario;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                File datos = new File("Clinica.dat");
                if(!datos.exists()) {
                	Clinica clinica = Clinica.getInstance();
                    Login login = new Login(clinica.getUsuarios());
                    login.setVisible(true);
                	}
                else {
                try {
                	FileInputStream datosStream = new FileInputStream(datos);
                	ObjectInputStream clinDat = new ObjectInputStream(datosStream);
                	Clinica clinica = Clinica.getInstance();
                	clinica = (Clinica) clinDat.readObject();
                	Login login = new Login(clinica.getUsuarios());
                    login.setVisible(true);
                	/*
*/
                	
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            }
        });
    }

    public Principal(User user) {
    	addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	try {
            	FileOutputStream clinData = new FileOutputStream("Clinica.dat");
            	ObjectOutputStream clin = new ObjectOutputStream(clinData);
            	clin.writeObject(Clinica.getInstance());
            	}
            	catch(FileNotFoundException e1) {
            		e1.printStackTrace();
            	}
            	catch(IOException e1) {
            		e1.printStackTrace();
            	}
            	
            }
        });
    	
    	usuario = user;
        setTitle("Clinica - Sistema de Gestión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dim = getToolkit().getScreenSize();
        setBounds(100, 100, dim.width, dim.height - 45);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(new Color(0, 153, 255));
        setJMenuBar(menuBar);
        
        JMenu mnDoctores = new JMenu("Doctor");
        mnDoctores.setForeground(new Color(0, 51, 255));
        mnDoctores.setFont(new Font("Segoe UI", Font.BOLD, 20));
        menuBar.add(mnDoctores);
        
        JMenuItem mntmListarCitas = new JMenuItem("Listar Citas");
        mntmListarCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        mnDoctores.add(mntmListarCitas);
        
        JMenuItem mntmListarConsultas = new JMenuItem("Listar Consultas");
        mntmListarConsultas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            }
 
        });
        mnDoctores.add(mntmListarConsultas);
        
        JMenuItem mntmReportesPaciente = new JMenuItem("Reportes Por Paciente");
        mnDoctores.add(mntmReportesPaciente);
        
        JMenuItem mntmPacientesVigilancia = new JMenuItem("Pac. Enfermedades Vigilancia");
        mnDoctores.add(mntmPacientesVigilancia);
        
        JMenu mnServicios = new JMenu("Servicio");
        mnServicios.setForeground(new Color(0, 51, 255));
        mnServicios.setFont(new Font("Segoe UI", Font.BOLD, 20));
        menuBar.add(mnServicios);
        
        JMenuItem mntmHacerCita = new JMenuItem("Hacer Cita");
        mntmHacerCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HacerCita agCita = new HacerCita();
                agCita.setModal(true);
                agCita.setVisible(true);
            }
        });
        mnServicios.add(mntmHacerCita);
        
        JMenuItem mntmHacerConsulta = new JMenuItem("Hacer Consulta");
        mntmHacerConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HacerConsulta agConsulta = new HacerConsulta();
                agConsulta.setModal(true);
                agConsulta.setVisible(true);
            }
        });
        mnServicios.add(mntmHacerConsulta);
        
        JMenu mnHistorial = new JMenu("Historial");
        mnHistorial.setForeground(new Color(0, 51, 255));
        mnHistorial.setFont(new Font("Segoe UI", Font.BOLD, 20));
        menuBar.add(mnHistorial);
        
        JMenuItem mntmHistorialClinico = new JMenuItem("Historial Clinico");
        mnHistorial.add(mntmHistorialClinico);
        
        JMenuItem P = new JMenuItem("Pacientes");
        mnHistorial.add(P);
        
        JMenuItem mntmListarCitasTotales = new JMenuItem("Listar Citas Totales");
        mntmListarCitasTotales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarCitas liCitas = new ListarCitas();
                liCitas.setModal(true);
                liCitas.setVisible(true);
            }
        });
        mnHistorial.add(mntmListarCitasTotales);
        
        JMenuItem mntmListarConsultasTotales = new JMenuItem("Listar Consultas Totales");
        mntmListarConsultasTotales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarConsultas liConsultas = new ListarConsultas();
                liConsultas.setModal(true);
                liConsultas.setVisible(true);
            }
        });
        mnHistorial.add(mntmListarConsultasTotales);
         
        JMenu mnAdministracion = new JMenu("Administracion");
        mnAdministracion.setForeground(new Color(0, 51, 255));
        mnAdministracion.setFont(new Font("Segoe UI", Font.BOLD, 20));
        menuBar.add(mnAdministracion);
        if(!usuario.isAdmint()) {
        	mnAdministracion.setVisible(false);
        }
        
        JMenuItem mntmAgregarDoctor = new JMenuItem("Agregar Doctor");
        mntmAgregarDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarDoctor agDoctor = new AgregarDoctor();
                agDoctor.setModal(true);
                agDoctor.setVisible(true);
            }
        });
        mnAdministracion.add(mntmAgregarDoctor);
        
        JMenuItem mntmAgregarAdmin = new JMenuItem("Agregar Admin");
        mnAdministracion.add(mntmAgregarAdmin);
        
        JMenuItem mntmListarDoctores = new JMenuItem("Listar Doctores");
        mntmListarDoctores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarDoctores liDoctores = new ListarDoctores();
                liDoctores.setModal(true);
                liDoctores.setVisible(true);
            }
        });
        mnAdministracion.add(mntmListarDoctores);
        
        JMenuItem mntmListarPacientesBVigilancia = new JMenuItem("Listar Pacientes B. Vigilancia");
        mnAdministracion.add(mntmListarPacientesBVigilancia);
        
        JMenuItem mntmControlVacunas = new JMenuItem("Control Vacunas");
        mntmControlVacunas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControlVacuna conVacuna = new ControlVacuna();
                conVacuna.setModal(true);
                conVacuna.setVisible(true);
            }
        });
        mnAdministracion.add(mntmControlVacunas);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(153, 204, 255));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        

        
        
        //JLabel lblNewLabel = new JLabel("Bienvenido al Sistema de Gestión de Clínica");
        //lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        //lblNewLabel.setBounds(300, 100, 600, 50);
        //panel.add(lblNewLabel);
    }
}