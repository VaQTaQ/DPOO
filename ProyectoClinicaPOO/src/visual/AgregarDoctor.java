package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import lógico.Clinica;
import lógico.Medico;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedulaDoctor;
	private JTextField txtNombresDoctor;
	private JSpinner spnEdadDoctor;
	private JTextField txtIdDoctor;
	private JTextField txtApellidosDoctor;
	private JTextField txtDireccionDoctor;
	private JTextField txtUsuarioDoctor;
	private JPasswordField txtPasswordDoctor;
	private JPasswordField txtConfirmPasswordDoctor; // Nuevo campo para confirmar contraseña

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarDoctor dialog = new AgregarDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarDoctor() {
		setTitle("Agregue un doctor");
		setBounds(100, 100, 599, 550); // Incrementar altura para acomodar campos nuevos
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// Campos existentes
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setBounds(39, 51, 56, 16);
		contentPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(39, 96, 56, 16);
		contentPanel.add(lblNombre);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(39, 143, 56, 16);
		contentPanel.add(lblEdad);

		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(39, 191, 81, 16);
		contentPanel.add(lblEspecialidad);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(283, 191, 69, 16);
		contentPanel.add(lblDireccion);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(287, 54, 56, 16);
		contentPanel.add(lblId);

		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(287, 99, 56, 16);
		contentPanel.add(lblApellido);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(287, 143, 56, 16);
		contentPanel.add(lblSexo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(39, 240, 56, 16);
		contentPanel.add(lblUsuario);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(283, 240, 81, 16);
		contentPanel.add(lblPassword);

		// Nuevo campo para confirmar contraseña
		JLabel lblConfirmPassword = new JLabel("Confirmar contraseña:");
		lblConfirmPassword.setBounds(39, 280, 150, 16);
		contentPanel.add(lblConfirmPassword);

		txtCedulaDoctor = new JTextField();
		txtCedulaDoctor.setBounds(88, 48, 155, 22);
		contentPanel.add(txtCedulaDoctor);
		txtCedulaDoctor.setColumns(10);

		txtNombresDoctor = new JTextField();
		txtNombresDoctor.setColumns(10);
		txtNombresDoctor.setBounds(98, 93, 155, 22);
		contentPanel.add(txtNombresDoctor);

		spnEdadDoctor = new JSpinner();
		spnEdadDoctor.setModel(new SpinnerNumberModel(18, 0, 120, 1));
		spnEdadDoctor.setBounds(75, 140, 155, 22);
		contentPanel.add(spnEdadDoctor);

		txtIdDoctor = new JTextField();
		txtIdDoctor.setText("D-" + Clinica.idMedico);
		txtIdDoctor.setEditable(false);
		txtIdDoctor.setColumns(10);
		txtIdDoctor.setBounds(310, 51, 155, 22);
		contentPanel.add(txtIdDoctor);

		txtApellidosDoctor = new JTextField();
		txtApellidosDoctor.setColumns(10);
		txtApellidosDoctor.setBounds(343, 96, 155, 22);
		contentPanel.add(txtApellidosDoctor);

		JComboBox cmbSexoDoctor = new JComboBox();
		cmbSexoDoctor.setModel(new DefaultComboBoxModel(new String[] { "Seleccione", "Masculino", "Femenino" }));
		cmbSexoDoctor.setBounds(329, 140, 145, 22);
		contentPanel.add(cmbSexoDoctor);

		txtDireccionDoctor = new JTextField();
		txtDireccionDoctor.setColumns(10);
		txtDireccionDoctor.setBounds(343, 188, 179, 40);
		contentPanel.add(txtDireccionDoctor);

		txtUsuarioDoctor = new JTextField();
		txtUsuarioDoctor.setBounds(98, 237, 155, 22);
		contentPanel.add(txtUsuarioDoctor);
		txtUsuarioDoctor.setColumns(10);

		txtPasswordDoctor = new JPasswordField();
		txtPasswordDoctor.setBounds(373, 237, 155, 22);
		contentPanel.add(txtPasswordDoctor);

		txtConfirmPasswordDoctor = new JPasswordField();
		txtConfirmPasswordDoctor.setBounds(185, 277, 155, 22);
		contentPanel.add(txtConfirmPasswordDoctor);

		JComboBox cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setModel(new DefaultComboBoxModel(
				new String[] { "<Seleccione>", "Medicina General/Familiar", "Pediatría", "Ginecología y Obstetricia", "Cardiología" }));
		cmbEspecialidad.setBounds(116, 188, 145, 22);
		contentPanel.add(cmbEspecialidad);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton btnAgregarDoctor = new JButton("Agregar");
		btnAgregarDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Validaciones
					if (txtCedulaDoctor.getText().isEmpty() || txtNombresDoctor.getText().isEmpty()
							|| txtApellidosDoctor.getText().isEmpty() || cmbSexoDoctor.getSelectedIndex() == 0
							|| txtDireccionDoctor.getText().isEmpty() || cmbEspecialidad.getSelectedIndex() == 0
							|| txtUsuarioDoctor.getText().isEmpty() || txtPasswordDoctor.getPassword().length == 0
							|| txtConfirmPasswordDoctor.getPassword().length == 0) {

						JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.",
								"Advertencia", JOptionPane.WARNING_MESSAGE);
						return;
					}

					String password = new String(txtPasswordDoctor.getPassword());
					String confirmPassword = new String(txtConfirmPasswordDoctor.getPassword());

					if (!password.equals(confirmPassword)) {
						JOptionPane.showMessageDialog(null,
								"Las contraseñas no coinciden. Por favor, inténtelo de nuevo.", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Crear objeto Medico y registrar
					int edad = (Integer) spnEdadDoctor.getValue();
					String cedula = txtCedulaDoctor.getText();
					String nombre = txtNombresDoctor.getText();
					String apellido = txtApellidosDoctor.getText();
					String sexo = cmbSexoDoctor.getSelectedItem().toString();
					String direccion = txtDireccionDoctor.getText();
					String especialidad = cmbEspecialidad.getSelectedItem().toString();
					String codigoMedico = txtIdDoctor.getText();

					Medico nuevoMedico = new Medico(cedula, nombre, apellido, edad, sexo, direccion, especialidad,
							codigoMedico);

					Clinica.getInstance().registrarMedico(nuevoMedico);

					JOptionPane.showMessageDialog(null, "Médico registrado satisfactoriamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					clean();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"Error al registrar el médico: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void clean() {
				txtCedulaDoctor.setText("");
				txtNombresDoctor.setText("");
				txtApellidosDoctor.setText("");
				spnEdadDoctor.setValue(18);
				cmbSexoDoctor.setSelectedIndex(0);
				txtDireccionDoctor.setText("");
				cmbEspecialidad.setSelectedIndex(0);
				txtUsuarioDoctor.setText("");
				txtPasswordDoctor.setText("");
				txtConfirmPasswordDoctor.setText("");
				txtIdDoctor.setText("D-" + Clinica.idMedico);
			}
		});
		buttonPane.add(btnAgregarDoctor);
		getRootPane().setDefaultButton(btnAgregarDoctor);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(btnCancelar);
	}
}
