package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lógico.Paciente;
import lógico.Vacuna;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class VacunarPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedulaPaciente;
	private JTextField txtNombrePaciente;
	private JTextField txtIdPaciente;
	private JTextField txtSexoPaciente;
	private JTextField txtEdadPaciente;
	private JTextField txtFechaHoy;
	private JTextField txtDosisAplicar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VacunarPaciente dialog = new VacunarPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VacunarPaciente() {
		setBounds(100, 100, 633, 527);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlListaVacunasDisponibles = new JPanel();
		pnlListaVacunasDisponibles.setBounds(22, 181, 561, 238);
		contentPanel.add(pnlListaVacunasDisponibles);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(22, 26, 381, 142);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("Cedula:");
		label.setBounds(12, 16, 56, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(12, 70, 56, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Edad:");
		label_2.setBounds(296, 73, 56, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Sexo:");
		label_3.setBounds(254, 16, 56, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("ID Paciente:");
		label_4.setBounds(172, 16, 70, 16);
		panel.add(label_4);
		
		txtCedulaPaciente = new JTextField();
		txtCedulaPaciente.setEditable(false);
		txtCedulaPaciente.setColumns(10);
		txtCedulaPaciente.setBounds(12, 35, 148, 22);
		panel.add(txtCedulaPaciente);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setEditable(false);
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(12, 90, 247, 22);
		panel.add(txtNombrePaciente);
		
		txtIdPaciente = new JTextField();
		txtIdPaciente.setEditable(false);
		txtIdPaciente.setColumns(10);
		txtIdPaciente.setBounds(172, 35, 70, 22);
		panel.add(txtIdPaciente);
		
		txtSexoPaciente = new JTextField();
		txtSexoPaciente.setEditable(false);
		txtSexoPaciente.setColumns(10);
		txtSexoPaciente.setBounds(254, 35, 98, 22);
		panel.add(txtSexoPaciente);
		
		txtEdadPaciente = new JTextField();
		txtEdadPaciente.setEditable(false);
		txtEdadPaciente.setColumns(10);
		txtEdadPaciente.setBounds(272, 90, 80, 22);
		panel.add(txtEdadPaciente);
		
		JPanel pnlDatosVacuna = new JPanel();
		pnlDatosVacuna.setBounds(416, 26, 165, 142);
		contentPanel.add(pnlDatosVacuna);
		pnlDatosVacuna.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(54, 72, 56, 16);
		pnlDatosVacuna.add(lblNewLabel);
		
		txtFechaHoy = new JTextField();
		txtFechaHoy.setEditable(false);
		txtFechaHoy.setBounds(24, 90, 116, 22);
		pnlDatosVacuna.add(txtFechaHoy);
		txtFechaHoy.setColumns(10);
		
		txtDosisAplicar = new JTextField();
		txtDosisAplicar.setColumns(10);
		txtDosisAplicar.setBounds(24, 35, 116, 22);
		pnlDatosVacuna.add(txtDosisAplicar);
		
		JLabel lblDosisAAplicar = new JLabel("Dosis a Aplicar:");
		lblDosisAAplicar.setBounds(31, 16, 103, 16);
		pnlDatosVacuna.add(lblDosisAAplicar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVacunar = new JButton("Vacunar");
				btnVacunar.setActionCommand("OK");
				buttonPane.add(btnVacunar);
				getRootPane().setDefaultButton(btnVacunar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
