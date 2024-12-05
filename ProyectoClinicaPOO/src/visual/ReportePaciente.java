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

import l�gico.Clinica;
import l�gico.Consulta;
import l�gico.Paciente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ReportePaciente extends JDialog {

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
    private int indiceConsultaActual; 
    private JComboBox cmbTratadoConsulta; 
    private JButton btnAnteriorReporte; 
    private JButton btnSiguienteReporte; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportePaciente dialog = new ReportePaciente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportePaciente(Paciente paciente) { 
        this.paciente = paciente; 
        setBounds(100, 100, 644, 453);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtNombreClinica = new JTextField();
        txtNombreClinica.setEditable(false);
        txtNombreClinica.setBounds(18, 13, 277, 22);
        contentPanel.add(txtNombreClinica);
        txtNombreClinica.setColumns(10);

        JPanel pnlDatosMedico = new JPanel();
        pnlDatosMedico.setBounds(18, 57, 225, 86);
        contentPanel.add(pnlDatosMedico);
        pnlDatosMedico.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setBounds(12, 13, 56, 16);
        pnlDatosMedico.add(lblNewLabel);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(12, 45, 83, 16);
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
        pnlDatosPaciente.setBounds(260, 57, 348, 86);
        contentPanel.add(pnlDatosPaciente);
        pnlDatosPaciente.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(12, 13, 56, 16);
        pnlDatosPaciente.add(lblNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(12, 42, 56, 16);
        pnlDatosPaciente.add(lblEdad);

        JLabel txtSexoPaciente = new JLabel("Sexo:");
        txtSexoPaciente.setBounds(195, 45, 56, 16);
        pnlDatosPaciente.add(txtSexoPaciente);

        JLabel lblId = new JLabel("Id:");
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
        pnlDatosConsulta.setBounds(18, 156, 590, 172);
        contentPanel.add(pnlDatosConsulta);
        pnlDatosConsulta.setLayout(null);

        JLabel lblEnfermedad = new JLabel("Enfermedad:");
        lblEnfermedad.setBounds(12, 13, 83, 16);
        pnlDatosConsulta.add(lblEnfermedad);

        JLabel lblDiagnosticos = new JLabel("Diagnosticos:");
        lblDiagnosticos.setBounds(12, 68, 83, 16);
        pnlDatosConsulta.add(lblDiagnosticos);

        JLabel lblTratamiento = new JLabel("Tratamiento:");
        lblTratamiento.setBounds(12, 116, 83, 16);
        pnlDatosConsulta.add(lblTratamiento);

        JLabel lblVacunas = new JLabel("Vacunas:");
        lblVacunas.setBounds(271, 13, 56, 16);
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
        lblFechaDeEmision.setBounds(271, 125, 105, 16);
        pnlDatosConsulta.add(lblFechaDeEmision);

        txtFechaEmision = new JTextField();
        txtFechaEmision.setBounds(383, 122, 189, 22);
        pnlDatosConsulta.add(txtFechaEmision);
        txtFechaEmision.setEditable(false);
        txtFechaEmision.setColumns(10);

        JLabel lblTratado = new JLabel("Tratado:");
        lblTratado.setBounds(128, 339, 50, 16);
        contentPanel.add(lblTratado);

        cmbTratadoConsulta = new JComboBox(); // [Modificaci�n L�nea 139: Convertido a variable de clase]
        cmbTratadoConsulta.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
        cmbTratadoConsulta.setBounds(190, 336, 42, 22);
        contentPanel.add(cmbTratadoConsulta);

        
        cmbTratadoConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (consultasPaciente != null && !consultasPaciente.isEmpty()) {
                    Consulta consulta = consultasPaciente.get(indiceConsultaActual);
                    boolean tratado = cmbTratadoConsulta.getSelectedItem().toString().equals("Si");
                    consulta.setTratado(tratado);
                }
            }
        });

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                btnAnteriorReporte = new JButton("Anterior"); // [Modificaci�n L�nea 159: Convertido a variable de clase]
                btnAnteriorReporte.setActionCommand("OK");
                buttonPane.add(btnAnteriorReporte);
                getRootPane().setDefaultButton(btnAnteriorReporte);

                btnAnteriorReporte.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (indiceConsultaActual > 0) {
                            indiceConsultaActual--;
                            mostrarConsultaActual();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay consultas anteriores.");
                        }
                    }
                });
            }
            {
                btnSiguienteReporte = new JButton("Siguiente"); // Convertido a variable de clase]
                btnSiguienteReporte.setActionCommand("Cancel");
                buttonPane.add(btnSiguienteReporte);
                btnSiguienteReporte.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                        if (indiceConsultaActual < consultasPaciente.size() - 1) {
                            indiceConsultaActual++;
                            
                            mostrarConsultaActual();
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay m�s consultas.");
                        }
                    }
                });
            }
        }

        Clinica clinica = Clinica.getInstance();
        txtNombreClinica.setText(clinica.getNombre());

        txtNombrePaciente.setText(paciente.getNombre() + " " + paciente.getApellido());//dy
        txtEdadPaciente.setText(String.valueOf(paciente.getEdad()));
        txtIdPaciente.setText(paciente.getCodigoPaciente());
        txtSexPaciente.setText(paciente.getSexo());

        String vacunas = "";
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

        if (consultasPaciente != null && !consultasPaciente.isEmpty()) {
            indiceConsultaActual = 0;
            mostrarConsultaActual();
        } else {
            JOptionPane.showMessageDialog(this, "El paciente no tiene consultas registradas.");
        }
    }

    private void mostrarConsultaActual() { 
        Consulta consulta = consultasPaciente.get(indiceConsultaActual);
        txtNombreDoctor.setText(consulta.getMedico().getNombre() + " " + consulta.getMedico().getApellido());
        txtEspecialidadDoctor.setText(consulta.getMedico().getEspecialidad());
        txtEnfermedadConsulta.setText(consulta.getEnfermedad().getNombre());
        txtDiagnosticosConsulta.setText(consulta.getDiagnostico());
        txtTratamientoConsultas.setText(consulta.getTratamiento());
        txtFechaEmision.setText(consulta.getFecha().toString());
        cmbTratadoConsulta.setSelectedItem(consulta.isTratado() ? "Si" : "No");
    }
}
