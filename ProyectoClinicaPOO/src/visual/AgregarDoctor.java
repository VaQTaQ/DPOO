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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedulaDoctor;
	private JTextField txtNombresDoctor;
	private JTextField txtEdadDoctor;
	private JTextField txtEspecialidadDoctor;
	private JTextField txtIdDoctor;
	private JTextField txtApellidosDoctor;
	private JTextField txtDireccionDoctor;

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
		setBounds(100, 100, 599, 426);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		
		txtCedulaDoctor = new JTextField();
		txtCedulaDoctor.setBounds(88, 48, 155, 22);
		contentPanel.add(txtCedulaDoctor);
		txtCedulaDoctor.setColumns(10);
		
		txtNombresDoctor = new JTextField();
		txtNombresDoctor.setColumns(10);
		txtNombresDoctor.setBounds(98, 93, 155, 22);
		contentPanel.add(txtNombresDoctor);
		
		txtEdadDoctor = new JTextField();
		txtEdadDoctor.setColumns(10);
		txtEdadDoctor.setBounds(75, 140, 155, 22);
		contentPanel.add(txtEdadDoctor);
		
		txtEspecialidadDoctor = new JTextField();
		txtEspecialidadDoctor.setColumns(10);
		txtEspecialidadDoctor.setBounds(116, 188, 155, 22);
		contentPanel.add(txtEspecialidadDoctor);
		
		txtIdDoctor = new JTextField();
		txtIdDoctor.setEditable(false);
		txtIdDoctor.setColumns(10);
		txtIdDoctor.setBounds(310, 51, 155, 22);
		contentPanel.add(txtIdDoctor);
		
		txtApellidosDoctor = new JTextField();
		txtApellidosDoctor.setColumns(10);
		txtApellidosDoctor.setBounds(343, 96, 155, 22);
		contentPanel.add(txtApellidosDoctor);
		
		JComboBox cmbSexoDoctor = new JComboBox();
		cmbSexoDoctor.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Masculino", "Femenino"}));
		cmbSexoDoctor.setBounds(329, 140, 145, 22);
		contentPanel.add(cmbSexoDoctor);
		
		txtDireccionDoctor = new JTextField();
		txtDireccionDoctor.setColumns(10);
		txtDireccionDoctor.setBounds(343, 188, 179, 108);
		contentPanel.add(txtDireccionDoctor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAgregarDoctor = new JButton("Agregar");
				btnAgregarDoctor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String cedula = txtCedulaDoctor.getText();
					    String nombre = txtNombresDoctor.getText();
					    String apellido = txtApellidosDoctor.getText();
					    int edad = Integer.parseInt(txtEdadDoctor.getText());
					    String sexo = cmbSexoDoctor.getSelectedItem().toString();
					    String direccion = txtDireccionDoctor.getText();
					    String especialidad = txtEspecialidadDoctor.getText();
					    String codigoMedico = txtIdDoctor.getText();
					    
					    
					    Medico nuevoMedico = new Medico(cedula, nombre, apellido, edad, sexo, direccion, especialidad, codigoMedico);
					    
					    
					    Clinica.getInstance().registrarMedico(nuevoMedico);
					    
					    
					    JOptionPane.showMessageDialog(null, "Médico registrado satisfactoriamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					    
					    clean();
						
					}

					private void clean() {
						// TODO Auto-generated method stub
						txtCedulaDoctor.setText("");
					    txtNombresDoctor.setText("");
					    txtApellidosDoctor.setText("");
					    txtEdadDoctor.setText("");
					    cmbSexoDoctor.setSelectedIndex(0);
					    txtDireccionDoctor.setText("");
					    txtEspecialidadDoctor.setText("");
					    txtIdDoctor.setText("");
						
					}
				});
				btnAgregarDoctor.setActionCommand("OK");
				buttonPane.add(btnAgregarDoctor);
				getRootPane().setDefaultButton(btnAgregarDoctor);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
