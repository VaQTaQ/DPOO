package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class HacerConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPacienteCedula;
	private JTextField txtPacienteNombre;
	private JTextField txtDoctorId;
	private JTextField txtDoctorNombre;
	private JTextField txtDoctorEspecialidad;
	private JTextField txtPacienteId;
	private JTextField txtDiagnostico;
	private JTextField txtEnfermedad;
	private JTextField txtTratamiento;
	private JTextField txtPacienteSexo;
	private JTextField txtPacienteEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HacerConsulta dialog = new HacerConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HacerConsulta() {
		setBounds(100, 100, 550, 706);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(12, 42, 505, 165);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Cedula:");
				label.setBounds(12, 13, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(12, 67, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Edad:");
				label.setBounds(12, 125, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Sexo:");
				label.setBounds(246, 125, 56, 16);
				panel.add(label);
			}
			{
				txtPacienteCedula = new JTextField();
				txtPacienteCedula.setEditable(false);
				txtPacienteCedula.setColumns(10);
				txtPacienteCedula.setBounds(74, 10, 148, 22);
				panel.add(txtPacienteCedula);
			}
			{
				txtPacienteNombre = new JTextField();
				txtPacienteNombre.setEditable(false);
				txtPacienteNombre.setColumns(10);
				txtPacienteNombre.setBounds(74, 64, 306, 22);
				panel.add(txtPacienteNombre);
			}
			{
				JLabel lblIdPaciente = new JLabel("ID Paciente:");
				lblIdPaciente.setBounds(246, 13, 70, 16);
				panel.add(lblIdPaciente);
			}
			{
				txtPacienteId = new JTextField();
				txtPacienteId.setColumns(10);
				txtPacienteId.setBounds(324, 10, 56, 22);
				panel.add(txtPacienteId);
			}
			{
				JButton btnBuscarPacienteXId = new JButton("Buscar");
				btnBuscarPacienteXId.setBounds(381, 9, 70, 25);
				panel.add(btnBuscarPacienteXId);
			}
			
			txtPacienteSexo = new JTextField();
			txtPacienteSexo.setEditable(false);
			txtPacienteSexo.setColumns(10);
			txtPacienteSexo.setBounds(303, 122, 148, 22);
			panel.add(txtPacienteSexo);
			
			txtPacienteEdad = new JTextField();
			txtPacienteEdad.setEditable(false);
			txtPacienteEdad.setColumns(10);
			txtPacienteEdad.setBounds(74, 122, 80, 22);
			panel.add(txtPacienteEdad);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(119, 220, 299, 154);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("ID Doctor:");
				label.setBounds(12, 22, 70, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Nombre Doc.:");
				label.setBounds(12, 67, 91, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Especialidad:");
				label.setBounds(12, 112, 75, 16);
				panel.add(label);
			}
			{
				txtDoctorId = new JTextField();
				txtDoctorId.setColumns(10);
				txtDoctorId.setBounds(94, 19, 91, 22);
				panel.add(txtDoctorId);
			}
			{
				txtDoctorNombre = new JTextField();
				txtDoctorNombre.setEditable(false);
				txtDoctorNombre.setColumns(10);
				txtDoctorNombre.setBounds(94, 64, 188, 22);
				panel.add(txtDoctorNombre);
			}
			{
				txtDoctorEspecialidad = new JTextField();
				txtDoctorEspecialidad.setEditable(false);
				txtDoctorEspecialidad.setColumns(10);
				txtDoctorEspecialidad.setBounds(94, 109, 188, 22);
				panel.add(txtDoctorEspecialidad);
			}
			{
				JButton btnBuscarDoctorXId = new JButton("Buscar");
				btnBuscarDoctorXId.setBounds(197, 18, 85, 25);
				panel.add(btnBuscarDoctorXId);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(42, 387, 454, 222);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Fecha:");
				label.setBounds(217, 191, 56, 16);
				panel.add(label);
			}
			{
				JSpinner spnFechaConsulta = new JSpinner();
				spnFechaConsulta.setBounds(263, 188, 119, 22);
				panel.add(spnFechaConsulta);
			}
			{
				JLabel lblDiagnostico = new JLabel("Diagnostico:");
				lblDiagnostico.setBounds(12, 13, 89, 16);
				panel.add(lblDiagnostico);
			}
			{
				JLabel lblEnfermedad = new JLabel("Enfermedad:");
				lblEnfermedad.setBounds(12, 42, 74, 16);
				panel.add(lblEnfermedad);
			}
			{
				JLabel lblTratamiento = new JLabel("Tratamiento:");
				lblTratamiento.setBounds(12, 99, 80, 16);
				panel.add(lblTratamiento);
			}
			{
				JLabel lblImportanteParaVigilancia = new JLabel("Importante para vigilancia:");
				lblImportanteParaVigilancia.setBounds(11, 191, 160, 16);
				panel.add(lblImportanteParaVigilancia);
			}
			{
				txtDiagnostico = new JTextField();
				txtDiagnostico.setBounds(95, 10, 268, 22);
				panel.add(txtDiagnostico);
				txtDiagnostico.setColumns(10);
			}
			{
				txtEnfermedad = new JTextField();
				txtEnfermedad.setColumns(10);
				txtEnfermedad.setBounds(95, 42, 268, 46);
				panel.add(txtEnfermedad);
			}
			{
				txtTratamiento = new JTextField();
				txtTratamiento.setColumns(10);
				txtTratamiento.setBounds(95, 101, 268, 46);
				panel.add(txtTratamiento);
			}
			
			JComboBox cmbVigilancia = new JComboBox();
			cmbVigilancia.setModel(new DefaultComboBoxModel(new String[] {"---", "si", "no"}));
			cmbVigilancia.setBounds(166, 188, 39, 22);
			panel.add(cmbVigilancia);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnHacerConsulta = new JButton("Hacer Consulta");
				btnHacerConsulta.setActionCommand("OK");
				buttonPane.add(btnHacerConsulta);
				getRootPane().setDefaultButton(btnHacerConsulta);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
