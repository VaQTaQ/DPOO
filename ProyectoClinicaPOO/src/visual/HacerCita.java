package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lógico.Clinica;
import lógico.Medico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HacerCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDoctorId;
	private JTextField txtDoctorNombre;
	private JTextField txtDoctorEspecialidad;
	private JTextField txtCitaPrioridad;
	private JTextField txtCitaPrecio;
	private JTextField txtCitaActiva;
	private JTextField txtPacienteCedula;
	private JTextField txtPacienteNombre;
	private JTextField txtPacienteApellido;
	private JTextField txtPacienteDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HacerCita dialog = new HacerCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HacerCita() {
		setBounds(100, 100, 728, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlDatosPaciente = new JPanel();
		pnlDatosPaciente.setBounds(12, 33, 686, 165);
		contentPanel.add(pnlDatosPaciente);
		pnlDatosPaciente.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(12, 13, 56, 16);
		pnlDatosPaciente.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 67, 56, 16);
		pnlDatosPaciente.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(12, 125, 56, 16);
		pnlDatosPaciente.add(lblEdad);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(456, 13, 68, 16);
		pnlDatosPaciente.add(lblDireccion);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(246, 67, 56, 16);
		pnlDatosPaciente.add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(246, 125, 56, 16);
		pnlDatosPaciente.add(lblSexo);
		
		txtPacienteCedula = new JTextField();
		txtPacienteCedula.setColumns(10);
		txtPacienteCedula.setBounds(74, 10, 148, 22);
		pnlDatosPaciente.add(txtPacienteCedula);
		
		txtPacienteNombre = new JTextField();
		txtPacienteNombre.setColumns(10);
		txtPacienteNombre.setBounds(74, 64, 148, 22);
		pnlDatosPaciente.add(txtPacienteNombre);
		
		txtPacienteApellido = new JTextField();
		txtPacienteApellido.setColumns(10);
		txtPacienteApellido.setBounds(301, 64, 148, 22);
		pnlDatosPaciente.add(txtPacienteApellido);
		
		txtPacienteDireccion = new JTextField();
		txtPacienteDireccion.setColumns(10);
		txtPacienteDireccion.setBounds(526, 10, 148, 73);
		pnlDatosPaciente.add(txtPacienteDireccion);
		
		JComboBox cmbPacienteSexo = new JComboBox();
		cmbPacienteSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
		cmbPacienteSexo.setBounds(301, 122, 145, 22);
		pnlDatosPaciente.add(cmbPacienteSexo);
		
		JSpinner spnPacienteEdad = new JSpinner();
		spnPacienteEdad.setBounds(74, 122, 78, 30);
		pnlDatosPaciente.add(spnPacienteEdad);
		
		JPanel pnlDatosDoctor = new JPanel();
		pnlDatosDoctor.setBounds(40, 211, 299, 154);
		contentPanel.add(pnlDatosDoctor);
		pnlDatosDoctor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idDoctor:");
		lblNewLabel.setBounds(12, 22, 56, 16);
		pnlDatosDoctor.add(lblNewLabel);
		
		JLabel lblNombreDoc = new JLabel("Nombre Doc.:");
		lblNombreDoc.setBounds(12, 67, 91, 16);
		pnlDatosDoctor.add(lblNombreDoc);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(12, 112, 75, 16);
		pnlDatosDoctor.add(lblEspecialidad);
		
		txtDoctorId = new JTextField();
		txtDoctorId.setBounds(99, 19, 91, 22);
		pnlDatosDoctor.add(txtDoctorId);
		txtDoctorId.setColumns(10);
		
		txtDoctorNombre = new JTextField();
		txtDoctorNombre.setEditable(false);
		txtDoctorNombre.setColumns(10);
		txtDoctorNombre.setBounds(99, 64, 188, 22);
		pnlDatosDoctor.add(txtDoctorNombre);
		
		txtDoctorEspecialidad = new JTextField();
		txtDoctorEspecialidad.setEditable(false);
		txtDoctorEspecialidad.setColumns(10);
		txtDoctorEspecialidad.setBounds(99, 109, 188, 22);
		pnlDatosDoctor.add(txtDoctorEspecialidad);
		
		JButton btnBuscarDoctorById = new JButton("Buscar");
		btnBuscarDoctorById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		        Medico doctor = Clinica.getInstance().buscarDoctorById(txtDoctorId.getText());
		        
		        if (doctor != null) {
		            txtDoctorNombre.setText(doctor.getNombre() + " " + doctor.getApellido());
		            txtDoctorEspecialidad.setText(doctor.getEspecialidad());
		        } else {
		            JOptionPane.showMessageDialog(null, "Doctor no encontrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		            txtDoctorNombre.setText("");
		            txtDoctorEspecialidad.setText("");
		        }

		       
			}
		});
		btnBuscarDoctorById.setBounds(202, 18, 85, 25);
		pnlDatosDoctor.add(btnBuscarDoctorById);
		
		JPanel pnlDatosCita = new JPanel();
		pnlDatosCita.setBounds(369, 211, 299, 154);
		contentPanel.add(pnlDatosCita);
		pnlDatosCita.setLayout(null);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setBounds(10, 23, 56, 16);
		pnlDatosCita.add(lblPrioridad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 68, 56, 16);
		pnlDatosCita.add(lblPrecio);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 113, 56, 16);
		pnlDatosCita.add(lblFecha);
		
		JLabel lblActiva = new JLabel("Activa:");
		lblActiva.setBounds(165, 23, 56, 16);
		pnlDatosCita.add(lblActiva);
		
		txtCitaPrioridad = new JTextField();
		txtCitaPrioridad.setBounds(65, 20, 94, 22);
		pnlDatosCita.add(txtCitaPrioridad);
		txtCitaPrioridad.setColumns(10);
		
		txtCitaPrecio = new JTextField();
		txtCitaPrecio.setColumns(10);
		txtCitaPrecio.setBounds(65, 65, 94, 22);
		pnlDatosCita.add(txtCitaPrecio);
		
		txtCitaActiva = new JTextField();
		txtCitaActiva.setColumns(10);
		txtCitaActiva.setBounds(205, 20, 82, 22);
		pnlDatosCita.add(txtCitaActiva);
		
		JSpinner spnCitaFecha = new JSpinner();
		spnCitaFecha.setBounds(65, 110, 119, 22);
		pnlDatosCita.add(spnCitaFecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnHacerCita = new JButton("Hacer Cita");
				btnHacerCita.setActionCommand("OK");
				buttonPane.add(btnHacerCita);
				getRootPane().setDefaultButton(btnHacerCita);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
