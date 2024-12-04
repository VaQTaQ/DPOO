package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
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
        ArrayList<String> pacientesAgregadosId = new ArrayList<>(); 

        ArrayList<Consulta> listaConsultas = Clinica.getInstance().getConsultas(); 

        row = new Object[modelo.getColumnCount()];
        
        for (Consulta consulta : listaConsultas) { 
        	
            Paciente paciente = consulta.getPaciente();
            String idPaciente = paciente.getCodigoPaciente();
            
            if (!pacientesAgregadosId.contains(idPaciente)) {
            	
                row[0] = idPaciente;
                
                row[1] = paciente.getNombre() + " " + paciente.getApellido();

                String nombreDoctor = consulta.getMedico().getNombre() + " " + consulta.getMedico().getApellido();
                
                row[2] = nombreDoctor;
                
                row[3] = consulta.getEnfermedad().getNombre();

                modelo.addRow(row);
                pacientesAgregadosId.add(idPaciente); 
            }
        }
    }
}
