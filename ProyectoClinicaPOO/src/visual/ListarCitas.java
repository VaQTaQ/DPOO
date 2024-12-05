package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Cita;
import lógico.Clinica;
import lógico.Medico;
import lógico.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ListarCitas extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblListarCitas;
    private DefaultTableModel modelo;
    private Object[] row;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListarCitas dialog = new ListarCitas();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListarCitas() {
        setTitle("Listado de Citas");
        setBounds(100, 100, 800, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        
        
        contentPanel.setBackground(new java.awt.Color(173, 216, 230)); 
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);

      
        tblListarCitas = new JTable();
        modelo = new DefaultTableModel();
        String[] columnas = { "ID Cita", "Nombre Paciente", "Nombre Doctor", "Prioridad", "Activa", "Fecha" };
        modelo.setColumnIdentifiers(columnas);
        tblListarCitas.setModel(modelo);
        scrollPane.setViewportView(tblListarCitas);
        tblListarCitas.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13)); 
        tblListarCitas.getTableHeader().setForeground(Color.BLUE); 

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        
        JButton cancelButton = new JButton("Cerrar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        cancelButton.setBackground(new Color(255, 0, 0));
        buttonPane.add(cancelButton);
        
        
        buttonPane.setBackground(new java.awt.Color(173, 216, 230)); 
        
        cargarCitas();
    }

    private void cargarCitas() {
        modelo.setRowCount(0);
        ArrayList<Cita> listaCitas = (ArrayList<Cita>) Clinica.getInstance().getCitas();
        row = new Object[modelo.getColumnCount()];
        
        for (Cita cita : listaCitas) {
            Medico medico = Clinica.getInstance().buscarDoctorById(cita.getDoctorID());
            Paciente paciente = (Paciente) cita.getPosiblePaciente();

            row[0] = "C-" + cita.getIdCita();
            row[1] = paciente.getNombre() + " " + paciente.getApellido();
            row[2] = medico.getNombre() + " " + medico.getApellido();
            row[3] = cita.getPrioridad();
            row[4] = cita.isActive() ? "Sí" : "No";
            row[5] = cita.getFecha();

            modelo.addRow(row);
        }
    }
}
