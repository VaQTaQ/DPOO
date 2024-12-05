package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

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
		setBounds(100, 100, 546, 430); 
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(173, 216, 230)); // Fondo azul clarito
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// Campos existentes
		JLabel lblNewLabel = new JLabel("Cedula:");
		lblNewLabel.setForeground(new Color(51, 51, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(23, 16, 56, 16);
		contentPanel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(new Color(51, 51, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(23, 61, 67, 16);
		contentPanel.add(lblNombre);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(new Color(51, 51, 255));
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdad.setBounds(34, 108, 56, 16);
		contentPanel.add(lblEdad);

		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setForeground(new Color(51, 51, 255));
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEspecialidad.setBounds(12, 156, 96, 16);
		contentPanel.add(lblEspecialidad);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(51, 51, 255));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccion.setBounds(258, 156, 69, 16);
		contentPanel.add(lblDireccion);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(51, 51, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(271, 19, 56, 16);
		contentPanel.add(lblId);

		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setForeground(new Color(51, 51, 255));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBounds(267, 61, 72, 16);
		contentPanel.add(lblApellido);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(51, 51, 255));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(271, 108, 56, 16);
		contentPanel.add(lblSexo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(51, 51, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(12, 274, 56, 16);
		contentPanel.add(lblUsuario);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setForeground(new Color(51, 51, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(237, 274, 81, 16);
		contentPanel.add(lblPassword);

		
		JLabel lblConfirmPassword = new JLabel("Confirmar: ");
		lblConfirmPassword.setForeground(new Color(51, 51, 255));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmPassword.setBounds(237, 306, 81, 16);
		contentPanel.add(lblConfirmPassword);

		txtCedulaDoctor = new JTextField();
		txtCedulaDoctor.setBounds(91, 13, 155, 22);
		contentPanel.add(txtCedulaDoctor);
		txtCedulaDoctor.setColumns(10);

		txtNombresDoctor = new JTextField();
		txtNombresDoctor.setColumns(10);
		txtNombresDoctor.setBounds(91, 58, 155, 22);
		contentPanel.add(txtNombresDoctor);

		spnEdadDoctor = new JSpinner();
		spnEdadDoctor.setModel(new SpinnerNumberModel(18, 0, 120, 1));
		spnEdadDoctor.setBounds(208, 105, 45, 22);
		contentPanel.add(spnEdadDoctor);

		txtIdDoctor = new JTextField();
		txtIdDoctor.setText("D-" + Clinica.idMedico);
		txtIdDoctor.setEditable(false);
		txtIdDoctor.setColumns(10);
		txtIdDoctor.setBounds(437, 13, 69, 22);
		contentPanel.add(txtIdDoctor);

		txtApellidosDoctor = new JTextField();
		txtApellidosDoctor.setColumns(10);
		txtApellidosDoctor.setBounds(351, 58, 155, 22);
		contentPanel.add(txtApellidosDoctor);

		JComboBox cmbSexoDoctor = new JComboBox();
		cmbSexoDoctor.setModel(new DefaultComboBoxModel(new String[] { "Seleccione", "Masculino", "Femenino" }));
		cmbSexoDoctor.setBounds(361, 105, 145, 22);
		contentPanel.add(cmbSexoDoctor);

		txtDireccionDoctor = new JTextField();
		txtDireccionDoctor.setColumns(10);
		txtDireccionDoctor.setBounds(327, 153, 179, 40);
		contentPanel.add(txtDireccionDoctor);

		txtUsuarioDoctor = new JTextField();
		txtUsuarioDoctor.setBounds(70, 271, 155, 22);
		contentPanel.add(txtUsuarioDoctor);
		txtUsuarioDoctor.setColumns(10);

		txtPasswordDoctor = new JPasswordField();
		txtPasswordDoctor.setBounds(330, 268, 155, 22);
		contentPanel.add(txtPasswordDoctor);

		txtConfirmPasswordDoctor = new JPasswordField();
		txtConfirmPasswordDoctor.setBounds(330, 300, 155, 22);
		contentPanel.add(txtConfirmPasswordDoctor);

		JComboBox cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Cardiolog\u00EDa", "Dermatolog\u00EDa", "Neurolog\u00EDa", "Ginecolog\u00EDa y Obstetricia", "Pediatr\u00EDa", "Oncolog\u00EDa", "Psiquiatr\u00EDa", "Cirug\u00EDa General", "Oftalmolog\u00EDa", "Otorrinolaringolog\u00EDa", "Ortopedia y Traumatolog\u00EDa", "Urolog\u00EDa", "Endocrinolog\u00EDa", "Gastroenterolog\u00EDa", "Reumatolog\u00EDa", "Nefrolog\u00EDa", "Hematolog\u00EDa", "Medicina Interna", "Medicina Familiar", "Neumolog\u00EDa", "Anestesiolog\u00EDa", "Medicina de Emergencias", "Patolog\u00EDa", "Radiolog\u00EDa", "Infectolog\u00EDa"}));
		cmbEspecialidad.setBounds(100, 153, 155, 22);
		contentPanel.add(cmbEspecialidad);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(173, 216, 230));
		buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton btnAgregarDoctor = new JButton("Agregar");
		btnAgregarDoctor.setBackground(new Color(102, 255, 51));
		btnAgregarDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
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
				txtDireccionDoctor.setText("");
				txtUsuarioDoctor.setText("");
				txtPasswordDoctor.setText("");
				txtConfirmPasswordDoctor.setText("");
				cmbEspecialidad.setSelectedIndex(0);
				cmbSexoDoctor.setSelectedIndex(0);
			}
		});

		btnAgregarDoctor.setActionCommand("OK");
		buttonPane.add(btnAgregarDoctor);
		getRootPane().setDefaultButton(btnAgregarDoctor);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setBackground(new Color(255, 69, 58));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
