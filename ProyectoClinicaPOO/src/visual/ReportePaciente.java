package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReportePaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreClinica;
	private JTextField txtNombreDoctor;
	private JTextField txtEspecialidadDoctor;
	private JTextField txtNombrePaciente;
	private JTextField txtEdadPaciente;
	private JTextField txtIdPaciente;
	private JTextField textField_5;
	private JTextField txtEnfermedadConsulta;
	private JTextField txtDiagnosticosConsulta;
	private JTextField txtTratamientoConsultas;
	private JTextField txtVacunasPaciente;
	private JTextField txtFechaEmision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportePaciente dialog = new ReportePaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportePaciente() {
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
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(234, 42, 102, 22);
		pnlDatosPaciente.add(textField_5);
		
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
		
		JComboBox cmbTratadoConsulta = new JComboBox();
		cmbTratadoConsulta.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		cmbTratadoConsulta.setBounds(190, 336, 42, 22);
		contentPanel.add(cmbTratadoConsulta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAnteriorReporte = new JButton("Anterior");
				btnAnteriorReporte.setActionCommand("OK");
				buttonPane.add(btnAnteriorReporte);
				getRootPane().setDefaultButton(btnAnteriorReporte);
			}
			{
				JButton btnSiguienteReporte = new JButton("Siguiente");
				btnSiguienteReporte.setActionCommand("Cancel");
				buttonPane.add(btnSiguienteReporte);
			}
		}
	}
}
