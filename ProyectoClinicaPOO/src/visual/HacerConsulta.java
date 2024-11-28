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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_9;

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
		setBounds(100, 100, 551, 692);
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
				JLabel label = new JLabel("Apellido:");
				label.setBounds(246, 67, 56, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Sexo:");
				label.setBounds(246, 125, 56, 16);
				panel.add(label);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(74, 10, 148, 22);
				panel.add(textField);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(74, 64, 148, 22);
				panel.add(textField_1);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(301, 64, 148, 22);
				panel.add(textField_2);
			}
			{
				JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(301, 122, 145, 22);
				panel.add(comboBox);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setBounds(74, 122, 78, 22);
				panel.add(spinner);
			}
			{
				JLabel lblIdPaciente = new JLabel("ID Paciente:");
				lblIdPaciente.setBounds(246, 13, 70, 16);
				panel.add(lblIdPaciente);
			}
			{
				textField_8 = new JTextField();
				textField_8.setColumns(10);
				textField_8.setBounds(324, 10, 56, 22);
				panel.add(textField_8);
			}
			{
				JButton button = new JButton("Buscar");
				button.setBounds(381, 9, 70, 25);
				panel.add(button);
			}
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
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(94, 19, 91, 22);
				panel.add(textField_4);
			}
			{
				textField_5 = new JTextField();
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				textField_5.setBounds(94, 64, 188, 22);
				panel.add(textField_5);
			}
			{
				textField_6 = new JTextField();
				textField_6.setEditable(false);
				textField_6.setColumns(10);
				textField_6.setBounds(94, 109, 188, 22);
				panel.add(textField_6);
			}
			{
				JButton button = new JButton("Buscar");
				button.setBounds(197, 18, 85, 25);
				panel.add(button);
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
				JSpinner spinner = new JSpinner();
				spinner.setBounds(263, 188, 119, 22);
				panel.add(spinner);
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
				textField_3 = new JTextField();
				textField_3.setBounds(95, 10, 268, 22);
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				textField_7.setBounds(95, 42, 268, 46);
				panel.add(textField_7);
			}
			{
				textField_9 = new JTextField();
				textField_9.setColumns(10);
				textField_9.setBounds(95, 101, 268, 46);
				panel.add(textField_9);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"---", "si", "no"}));
			comboBox.setBounds(166, 188, 39, 22);
			panel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
