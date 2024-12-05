package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import lógico.Clinica;
import lógico.Consulta;
import lógico.Paciente;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PacientesVigilancia extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblListarPacientesVigilancia; 
    private DefaultTableModel modelo;
    private Object[] row;

    /**
     * Create the dialog.
     */
    public PacientesVigilancia() {
        setTitle("Pacientes en Vigilancia");
        setBounds(100, 100, 700, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(SystemColor.activeCaption);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        {
            JScrollPane scrollPane = new JScrollPane();
            contentPanel.add(scrollPane, BorderLayout.CENTER);
            {
            	tblListarPacientesVigilancia = new JTable();
            	modelo = new DefaultTableModel();
            	String[] columnas = { "ID Paciente", "Nombre", "Doctor", "Enfermedad" };
            	modelo.setColumnIdentifiers(columnas);
            	tblListarPacientesVigilancia.setModel(modelo);
            	JTableHeader header = tblListarPacientesVigilancia.getTableHeader();
            	header.setFont(new Font("Tahoma", Font.BOLD, 13)); 
            	header.setForeground(Color.BLUE); 
            	scrollPane.setViewportView(tblListarPacientesVigilancia);

            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
            buttonPane.setBackground(new Color(153, 204, 255));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton btnVerReportes = new JButton("Ver Reportes");
                btnVerReportes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                        int selectedRow = tblListarPacientesVigilancia.getSelectedRow();
                        
                        if (selectedRow >= 0) {
                        	
                            String idPaciente = (String) modelo.getValueAt(selectedRow, 0);
                            Paciente paciente = Clinica.getInstance().buscarPacienteById(idPaciente);
                            
                            if (paciente != null) {
                            	
                                ReportePacienteVigilancia reportePacienteDialog = new ReportePacienteVigilancia(paciente, PacientesVigilancia.this); 
                                reportePacienteDialog.setVisible(true);
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "Paciente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione un paciente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
                btnVerReportes.setActionCommand("OK");
                btnVerReportes.setBackground(new Color(102, 255, 51));
                buttonPane.add(btnVerReportes);
                getRootPane().setDefaultButton(btnVerReportes);
            }
            {
                JButton cancelButton = new JButton("Cerrar");
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
        cargarPacientesVigilancia();
    }

    private void cargarPacientesVigilancia() { 
        modelo.setRowCount(0);
        row = new Object[modelo.getColumnCount()];
        List<Paciente> pacientesVigilancia = obtenerPacientesVigilancia();
        
        for (Paciente paciente : pacientesVigilancia) {
        	
            row[0] = paciente.getCodigoPaciente();
            row[1] = paciente.getNombre() + " " + paciente.getApellido();

            Consulta ultConsulta = obtenerUltConsultVigNoTratada(paciente); 
            
            if (ultConsulta != null) {
            	
                String nombreDoctor = ultConsulta.getMedico().getNombre() + " " + ultConsulta.getMedico().getApellido();
                row[2] = nombreDoctor;
                row[3] = ultConsulta.getEnfermedad().getNombre();
                modelo.addRow(row);
            }
        }
    }

    private ArrayList<Paciente> obtenerPacientesVigilancia() { 
    	ArrayList<Paciente> pacientesVigilancia = new ArrayList<>();
        
        for (Paciente paciente : Clinica.getInstance().getPacientes()) {
            Consulta ultimaConsulta = obtenerUltConsultVigNoTratada(paciente);
            
            if (ultimaConsulta != null) {
                pacientesVigilancia.add(paciente);
            }
        }
        return pacientesVigilancia;
    }

    private Consulta obtenerUltConsultVigNoTratada(Paciente paciente) { 
        Consulta ultimaConsulta = null;
        
        for (Consulta consulta : Clinica.getInstance().getConsultas()) {
        	
            if (consulta.getPaciente().equals(paciente) && consulta.getEnfermedad().isBajoVigilancia() && !consulta.isTratado()) {
                
                if (ultimaConsulta == null || consulta.getFecha().compareTo(ultimaConsulta.getFecha()) > 0) {
                    ultimaConsulta = consulta;
                }
            }
        }
        return ultimaConsulta;
    }


    public void actualizarLista() {
        cargarPacientesVigilancia();
    }
}
