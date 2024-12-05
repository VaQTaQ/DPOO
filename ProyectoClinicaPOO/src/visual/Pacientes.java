package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Clinica;
import lógico.Consulta;
import lógico.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Pacientes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblListarPacientes; 
    private DefaultTableModel modelo; 
    private Object[] row; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Pacientes dialog = new Pacientes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public Pacientes() {
        setTitle("Listado de Pacientes"); 
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
                tblListarPacientes = new JTable(); 
                modelo = new DefaultTableModel();
                String[] columnas = { "ID Paciente", "Nombre", "Doctor", "Enfermedad" }; 
                modelo.setColumnIdentifiers(columnas);
                tblListarPacientes.setModel(modelo);
                scrollPane.setViewportView(tblListarPacientes);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton btnVerReportes = new JButton("Ver Reportes");
                btnVerReportes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        int selectedRow = tblListarPacientes.getSelectedRow();
                        
                        if (selectedRow >= 0) {
                            
                            String idPaciente = (String) modelo.getValueAt(selectedRow, 0);
                            Paciente paciente = Clinica.getInstance().buscarPacienteById(idPaciente);
                            
                            if (paciente != null) {
                                ReportePaciente reportePacienteDialog = new ReportePaciente(paciente);
                                reportePacienteDialog.setModal(true);
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
                buttonPane.add(btnVerReportes);
                getRootPane().setDefaultButton(btnVerReportes);
            }
            {
                JButton cancelButton = new JButton("Cerrar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
        cargarPacientes(); 
    }

    private void cargarPacientes() {
        modelo.setRowCount(0);
        row = new Object[modelo.getColumnCount()];
        for (Paciente paciente : Clinica.getInstance().getPacientes()) {
            row[0] = paciente.getCodigoPaciente();
            row[1] = paciente.getNombre() + " " + paciente.getApellido();

            Consulta ultimaConsulta = obtenerUltimaConsulta(paciente);
            
            if (ultimaConsulta != null) {
                String nombreDoctor = ultimaConsulta.getMedico().getNombre() + " " + ultimaConsulta.getMedico().getApellido();
                row[2] = nombreDoctor;
                row[3] = ultimaConsulta.getEnfermedad().getNombre();
            } else {
            	
                row[2] = "N/A";
                row[3] = "N/A";
            }
            modelo.addRow(row);
        }
    }

    private Consulta obtenerUltimaConsulta(Paciente paciente) { 
        List<Consulta> consultasPaciente = new ArrayList<>();
        for (Consulta consulta : Clinica.getInstance().getConsultas()) {
            if (consulta.getPaciente().equals(paciente)) {
                consultasPaciente.add(consulta);
            }
        }
        
        if (!consultasPaciente.isEmpty()) {

            consultasPaciente.sort((c1, c2) -> c2.getFecha().compareTo(c1.getFecha()));
            return consultasPaciente.get(0);
        } else {
            return null;
        }
    }
}
