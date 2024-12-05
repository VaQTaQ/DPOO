package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lógico.Clinica;
import lógico.Consulta;
import lógico.Paciente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ReportePacienteVigilancia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreClinica;
	private JTextField txtNombreDoctor;
	private JTextField txtEspecialidadDoctor;
	private JTextField txtNombrePaciente;
	private JTextField txtEdadPaciente;
	private JTextField txtIdPaciente;
	private JTextField txtEnfermedadConsulta;
	private JTextField txtDiagnosticosConsulta;
	private JTextField txtTratamientoConsultas;
	private JTextField txtVacunasPaciente;
	private JTextField txtFechaEmision;
	private JTextField txtSexPaciente;
	
	private Paciente paciente; 
    private ArrayList<Consulta> consultasPaciente; 
    private int indConsultaActual; 
    private JComboBox<String> cmbTratadoConsulta; 
    private JButton btnAnteriorReporte; 
    private JButton btnSiguienteReporte; 
    private PacientesVigilancia pacientesVigilancia; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportePacienteVigilancia dialog = new ReportePacienteVigilancia(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportePacienteVigilancia(Paciente paciente,PacientesVigilancia pacientesVigilancia) { 
        this.paciente = paciente; 
        this.pacientesVigilancia = pacientesVigilancia;
        

        setBounds(100, 100, 644, 453);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(173, 216, 230));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        setAlwaysOnTop(true);


        txtNombreClinica = new JTextField();
        txtNombreClinica.setBackground(new Color(173, 216, 230));
        txtNombreClinica.setForeground(Color.BLUE);
        txtNombreClinica.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtNombreClinica.setEditable(false);
        txtNombreClinica.setBounds(18, 13, 277, 22);
        contentPanel.add(txtNombreClinica);
        txtNombreClinica.setColumns(10);

        JPanel pnlDatosMedico = new JPanel();
        pnlDatosMedico.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDatosMedico.setBackground(new Color(255, 255, 204));
        pnlDatosMedico.setBounds(18, 57, 225, 86);
        contentPanel.add(pnlDatosMedico);
        pnlDatosMedico.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setBounds(33, 13, 56, 16);
        pnlDatosMedico.add(lblNewLabel);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setForeground(Color.BLUE);
        lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEspecialidad.setBounds(6, 45, 83, 16);
        pnlDatosMedico.add(lblEspecialidad);

        txtNombreDoctor = new JTextField();
        
        txtNombreDoctor.setEditable(false);
        txtNombreDoctor.setBounds(91, 10, 116, 22);
        pnlDatosMedico.add(txtNombreDoctor);
        txtNombreDoctor.setColumns(10);

        txtEspecialidadDoctor = new JTextField();
        txtEspecialidadDoctor.setEditable(false);
        txtEspecialidadDoctor.setColumns(10);
        txtEspecialidadDoctor.setBounds(91, 42, 116, 22);
        pnlDatosMedico.add(txtEspecialidadDoctor);

        JPanel pnlDatosPaciente = new JPanel();
        pnlDatosPaciente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDatosPaciente.setBackground(new Color(153, 204, 204));
        pnlDatosPaciente.setBounds(260, 57, 348, 86);
        contentPanel.add(pnlDatosPaciente);
        pnlDatosPaciente.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.BLUE);
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombre.setBounds(12, 13, 56, 16);
        pnlDatosPaciente.add(lblNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setForeground(Color.BLUE);
        lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEdad.setBounds(12, 42, 56, 16);
        pnlDatosPaciente.add(lblEdad);

        JLabel txtSexoPaciente = new JLabel("Sexo:");
        txtSexoPaciente.setForeground(Color.BLUE);
        txtSexoPaciente.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtSexoPaciente.setBounds(195, 45, 56, 16);
        pnlDatosPaciente.add(txtSexoPaciente);

        JLabel lblId = new JLabel("Id:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblId.setForeground(Color.BLUE);
        lblId.setBounds(195, 16, 56, 16);
        pnlDatosPaciente.add(lblId);

        txtNombrePaciente = new JTextField();
        txtNombrePaciente.setEditable(false);
        txtNombrePaciente.setColumns(10);
        txtNombrePaciente.setBounds(67, 10, 116, 22);
        pnlDatosPaciente.add(txtNombrePaciente);

        txtEdadPaciente = new JTextField();
        txtEdadPaciente.setEditable(false);
        txtEdadPaciente.setColumns(10);
        txtEdadPaciente.setBounds(67, 42, 116, 22);
        pnlDatosPaciente.add(txtEdadPaciente);

        txtIdPaciente = new JTextField();
        txtIdPaciente.setEditable(false);
        txtIdPaciente.setColumns(10);
        txtIdPaciente.setBounds(234, 13, 102, 22);
        pnlDatosPaciente.add(txtIdPaciente);

        txtSexPaciente = new JTextField();
        txtSexPaciente.setEditable(false);
        txtSexPaciente.setBounds(234, 42, 102, 22);
        pnlDatosPaciente.add(txtSexPaciente);
        txtSexPaciente.setColumns(10);

        JPanel pnlDatosConsulta = new JPanel();
        pnlDatosConsulta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDatosConsulta.setBackground(new Color(255, 204, 204));
        pnlDatosConsulta.setBounds(18, 156, 590, 172);
        contentPanel.add(pnlDatosConsulta);
        pnlDatosConsulta.setLayout(null);

        JLabel lblEnfermedad = new JLabel("Enfermedad:");
        lblEnfermedad.setForeground(Color.BLUE);
        lblEnfermedad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEnfermedad.setBounds(12, 13, 83, 16);
        pnlDatosConsulta.add(lblEnfermedad);

        JLabel lblDiagnosticos = new JLabel("Diagnosticos:");
        lblDiagnosticos.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDiagnosticos.setForeground(Color.BLUE);
        lblDiagnosticos.setBounds(12, 68, 95, 16);
        pnlDatosConsulta.add(lblDiagnosticos);

        JLabel lblTratamiento = new JLabel("Tratamiento:");
        lblTratamiento.setForeground(Color.BLUE);
        lblTratamiento.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTratamiento.setBounds(12, 125, 95, 16);
        pnlDatosConsulta.add(lblTratamiento);

        JLabel lblVacunas = new JLabel("Vacunas:");
        lblVacunas.setForeground(Color.BLUE);
        lblVacunas.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVacunas.setBounds(271, 13, 69, 16);
        pnlDatosConsulta.add(lblVacunas);

        txtEnfermedadConsulta = new JTextField();
        txtEnfermedadConsulta.setEditable(false);
        txtEnfermedadConsulta.setBounds(96, 10, 116, 42);
        pnlDatosConsulta.add(txtEnfermedadConsulta);
        txtEnfermedadConsulta.setColumns(10);

        txtDiagnosticosConsulta = new JTextField();
        txtDiagnosticosConsulta.setEditable(false);
        txtDiagnosticosConsulta.setColumns(10);
        txtDiagnosticosConsulta.setBounds(96, 65, 116, 35);
        pnlDatosConsulta.add(txtDiagnosticosConsulta);

        txtTratamientoConsultas = new JTextField();
        txtTratamientoConsultas.setEditable(false);
        txtTratamientoConsultas.setColumns(10);
        txtTratamientoConsultas.setBounds(96, 113, 116, 41);
        pnlDatosConsulta.add(txtTratamientoConsultas);

        txtVacunasPaciente = new JTextField();
        txtVacunasPaciente.setHorizontalAlignment(SwingConstants.LEFT);
        txtVacunasPaciente.setEditable(false);
        txtVacunasPaciente.setColumns(10);
        txtVacunasPaciente.setBounds(339, 10, 233, 90);
        pnlDatosConsulta.add(txtVacunasPaciente);

        JLabel lblFechaDeEmision = new JLabel("Fecha de Emision:");
        lblFechaDeEmision.setForeground(Color.BLUE);
        lblFechaDeEmision.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblFechaDeEmision.setBounds(271, 125, 116, 16);
        pnlDatosConsulta.add(lblFechaDeEmision);

        txtFechaEmision = new JTextField();
        txtFechaEmision.setBounds(383, 122, 189, 22);
        pnlDatosConsulta.add(txtFechaEmision);
        txtFechaEmision.setEditable(false);
        txtFechaEmision.setColumns(10);

        JLabel lblTratado = new JLabel("Tratado:");
        lblTratado.setForeground(Color.BLUE);
        lblTratado.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTratado.setBounds(128, 339, 68, 16);
        contentPanel.add(lblTratado);

        cmbTratadoConsulta = new JComboBox(); 
        cmbTratadoConsulta.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
        cmbTratadoConsulta.setBounds(190, 336, 42, 22);
        contentPanel.add(cmbTratadoConsulta);

        
        cmbTratadoConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (!consultasPaciente.isEmpty()) {
            		
                    Consulta consulta = consultasPaciente.get(indConsultaActual);
                    boolean tratado = cmbTratadoConsulta.getSelectedItem().toString().equals("Si");
                    consulta.setTratado(tratado);

                    if (tratado && consulta.getEnfermedad().isBajoVigilancia()) { 
                    	
                        pacientesVigilancia.actualizarLista(); 
                        cargarConsultasVigilancia(); 
                        
                        if (consultasPaciente.isEmpty()) { 
                            JOptionPane.showMessageDialog(ReportePacienteVigilancia.this, "Todas las consultas bajo vigilancia han sido tratadas.");
                            dispose(); 
                            
                        } else {
                            mostrarConsultaActual(); 
                        }
                    }
                }
            }
        });

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
            buttonPane.setBackground(new Color(153, 204, 204));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                btnAnteriorReporte = new JButton("Anterior"); 
                btnAnteriorReporte.setBackground(new Color(255, 69, 58));
                btnAnteriorReporte.setActionCommand("OK");
                buttonPane.add(btnAnteriorReporte);
                getRootPane().setDefaultButton(btnAnteriorReporte);

                btnAnteriorReporte.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    
                        if (indConsultaActual > 0) {
                            indConsultaActual--;
                            mostrarConsultaActual();
                        } 
                    }
                });
            }
            {
                btnSiguienteReporte = new JButton("Siguiente"); 
                btnSiguienteReporte.setBackground(new Color(102, 255, 51));
                btnSiguienteReporte.setActionCommand("Cancel");
                buttonPane.add(btnSiguienteReporte);
                btnSiguienteReporte.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                        if (indConsultaActual < consultasPaciente.size() - 1) {
                            indConsultaActual++;
                            
                            mostrarConsultaActual();
                        } 
                    }
                });
            }
        }

        Clinica clinica = Clinica.getInstance();
        txtNombreClinica.setText("HOMS");

        txtNombrePaciente.setText(paciente.getNombre() + " " + paciente.getApellido());//d
        txtEdadPaciente.setText(String.valueOf(paciente.getEdad()));
        txtIdPaciente.setText(paciente.getCodigoPaciente());
        txtSexPaciente.setText(paciente.getSexo());

        String vacunas = " ";
        for (int i = 0; i < paciente.getMisVacunas().size(); i++) {
            vacunas += paciente.getMisVacunas().get(i).getNombre();
            if (i < paciente.getMisVacunas().size() - 1) {
                vacunas += ", ";
            }
        }
        txtVacunasPaciente.setText(vacunas);

        if (paciente.getHistoriaClinica() != null) {
            consultasPaciente = (ArrayList<Consulta>) paciente.getHistoriaClinica().getConsultas();
        } else {
            consultasPaciente = new ArrayList<>();
        }
        
        ArrayList<Consulta> consultasFiltradas = new ArrayList<>(); 
        for (Consulta consulta : consultasPaciente) {
            if (consulta.getEnfermedad().isBajoVigilancia()) {
                consultasFiltradas.add(consulta); 
            }
        }
        consultasPaciente = new ArrayList<>(consultasFiltradas); 

        if (consultasPaciente != null && !consultasPaciente.isEmpty()) {
            indConsultaActual = 0;
            mostrarConsultaActual();
        } 
        
        cargarConsultasVigilancia(); 
        
        
        if (consultasPaciente != null && !consultasPaciente.isEmpty()) {
            indConsultaActual = 0;
            mostrarConsultaActual();
        } 
    }

	 private void cargarConsultasVigilancia() { 
	        ArrayList<Consulta> consultasFiltradas = new ArrayList<>();
	        for (Consulta consulta : consultasPaciente) {
	            if (consulta.getEnfermedad().isBajoVigilancia()) {
	                consultasFiltradas.add(consulta);
	            }
	        }
	        consultasPaciente = consultasFiltradas;
	 }
	
    private void mostrarConsultaActual() { 
        Consulta consulta = consultasPaciente.get(indConsultaActual);
        txtNombreDoctor.setText(consulta.getMedico().getNombre() + " " + consulta.getMedico().getApellido());
        txtEspecialidadDoctor.setText(consulta.getMedico().getEspecialidad());
        txtEnfermedadConsulta.setText(consulta.getEnfermedad().getNombre());
        txtDiagnosticosConsulta.setText(consulta.getDiagnostico());
        txtTratamientoConsultas.setText(consulta.getTratamiento());
        txtFechaEmision.setText(consulta.getFecha().toString());
        cmbTratadoConsulta.setSelectedItem(consulta.isTratado() ? "Si" : "No");
    }
}
