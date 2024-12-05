package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import l�gico.Clinica;
import l�gico.Historial;
import l�gico.Paciente;
import l�gico.Vacuna;
import l�gico.VacunaDisponible;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class VacunarPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedulaPaciente;
	private JTextField txtNombrePaciente;
	private JTextField txtIdPaciente;
	private JTextField txtSexoPaciente;
	private JTextField txtEdadPaciente;
	private JTextField txtFechaHoy;
	private JTextField txtDosisAplicar;
	private Paciente pacienteSeleccionado;
	
    private JTable tblVacunasDisponibles;
    private DefaultTableModel modeloVacunas;
    private Object[] rowVacunas;
    

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
	
	 public VacunarPaciente(Paciente paciente) {
	        this(); 
	        this.pacienteSeleccionado = paciente;
	        txtCedulaPaciente.setText(paciente.getCedula());
	        txtNombrePaciente.setText(paciente.getNombre() + " " + paciente.getApellido());
	        txtIdPaciente.setText(paciente.getCodigoPaciente());
	        txtSexoPaciente.setText(paciente.getSexo());
	        txtEdadPaciente.setText(String.valueOf(paciente.getEdad()));
	        txtFechaHoy.setText(new Date().toString());	 
	        
	        
	        cargarVacunasDisponibles();
	        
	        }
	 
	private void cargarVacunasDisponibles() {
		// TODO Auto-generated method stub
	        modeloVacunas.setRowCount(0);
	        ArrayList<VacunaDisponible> vacunas = Clinica.getInstance().getVacunasDisponibles();
	        rowVacunas = new Object[modeloVacunas.getColumnCount()];

	        for (VacunaDisponible vacuna : vacunas) {
	        	
	            rowVacunas[0] = vacuna.getNombre();
	            
	            rowVacunas[1] = vacuna.getMinEdad();
	            
	            rowVacunas[2] = vacuna.getMaxEdad();
	            
	            modeloVacunas.addRow(rowVacunas);
	        }
	    

	}

	public VacunarPaciente() {
		setBounds(100, 100, 633, 527);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(173, 216, 230));
		
		
		JPanel pnlListaVacunasDisponibles = new JPanel();
		pnlListaVacunasDisponibles.setBounds(27, 181, 561, 238);
        pnlListaVacunasDisponibles.setLayout(new BorderLayout());
		contentPanel.add(pnlListaVacunasDisponibles);
		pnlListaVacunasDisponibles.setBackground(new Color(173, 216, 230));

        JScrollPane scrollPane = new JScrollPane();
        pnlListaVacunasDisponibles.add(scrollPane, BorderLayout.CENTER);

        tblVacunasDisponibles = new JTable();
        modeloVacunas = new DefaultTableModel();
        String[] columnas = { "Nombre", "Edad Min", "Edad Max" };
        modeloVacunas.setColumnIdentifiers(columnas);
        tblVacunasDisponibles.setModel(modeloVacunas);
        JTableHeader header = tblVacunasDisponibles.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 13)); 
        header.setForeground(Color.BLUE); 
        tblVacunasDisponibles.setBackground(new Color(173, 216, 230));
        scrollPane.setViewportView(tblVacunasDisponibles);

		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 204));
		panel.setLayout(null);
		panel.setBounds(27, 26, 381, 142);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("Cedula:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(12, 16, 56, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(12, 70, 56, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Edad:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(296, 73, 56, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Sexo:");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(254, 16, 56, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("ID Paciente:");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		pnlDatosVacuna.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDatosVacuna.setBackground(new Color(255, 204, 204));
		pnlDatosVacuna.setBounds(423, 26, 165, 142);
		contentPanel.add(pnlDatosVacuna);
		pnlDatosVacuna.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		lblDosisAAplicar.setForeground(Color.BLUE);
		lblDosisAAplicar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDosisAAplicar.setBounds(31, 16, 103, 16);
		pnlDatosVacuna.add(lblDosisAAplicar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setBackground(new Color(153, 204, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVacunar = new JButton("Vacunar");
				btnVacunar.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	
				        
				        if (tblVacunasDisponibles.getSelectedRow() >= 0) {
				        	
				            String nombreVacuna = (String) modeloVacunas.getValueAt(tblVacunasDisponibles.getSelectedRow(), 0);
				            VacunaDisponible vacunaSeleccionada = null;

				            for (VacunaDisponible vacuna : Clinica.getInstance().getVacunasDisponibles()) {
				            	
				                if (vacuna.getNombre().equalsIgnoreCase(nombreVacuna)) {
				                	
				                    vacunaSeleccionada = vacuna;
				                    break;
				                }
				            }

				            if (vacunaSeleccionada != null) {
				                try {
				                    int dosisNecesarias = 1;

				                    Vacuna nuevaVacuna = new Vacuna(vacunaSeleccionada.getNombre(),new Date(), dosisNecesarias,Integer.parseInt(txtDosisAplicar.getText()), vacunaSeleccionada.getMinEdad(),vacunaSeleccionada.getMaxEdad()
				                    );

				                    pacienteSeleccionado.getMisVacunas().add(nuevaVacuna); 
				                    String accion = "Vacunar Paciente";
				                    String detalle = "Vacuna: " + nuevaVacuna.getNombre() + " | Paciente: " + pacienteSeleccionado.getNombre();
				                    Historial historial = new Historial(accion, detalle, new Date());
				                    Clinica.getInstance().getHistoriales().add(historial);

				                    JOptionPane.showMessageDialog(null, "Paciente vacunado con: " + vacunaSeleccionada.getNombre(), "Vacunaci�n exitosa", JOptionPane.INFORMATION_MESSAGE);
				                    dispose();

				                } catch (Exception ex) {
				                    JOptionPane.showMessageDialog(null, "Error al vacunar al paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				                }
				            }
				        } else {
				            JOptionPane.showMessageDialog(null, "Seleccione una vacuna de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    }
				});

				btnVacunar.setActionCommand("OK");
				btnVacunar.setBackground(new Color(102, 255, 51));
				buttonPane.add(btnVacunar);
				getRootPane().setDefaultButton(btnVacunar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.setBackground(new Color(255, 69, 58));
				buttonPane.add(cancelButton);
			}
		}
	}
}
