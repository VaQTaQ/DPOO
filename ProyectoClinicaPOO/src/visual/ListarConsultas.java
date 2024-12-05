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

import lógico.Clinica;
import lógico.Consulta;
import lógico.Enfermedad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ListarConsultas extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblListarConsultas;
    private DefaultTableModel modelo;
    private Object[] row;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListarConsultas dialog = new ListarConsultas();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListarConsultas() {
        setTitle("Listado de Consultas");
        setBounds(100, 100, 1000, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new java.awt.Color(173, 216, 230));
        contentPanel.setBackground(SystemColor.activeCaption);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JScrollPane scrollPane = new JScrollPane();
            contentPanel.add(scrollPane, BorderLayout.CENTER);
            {
            	tblListarConsultas = new JTable();
            	modelo = new DefaultTableModel();
            	String[] columnas = { "ID Consulta", "Importante", "Nombre Paciente", "Nombre Doctor", "Diagnóstico",
            	    "Enfermedad", "Tratamiento", "Tratado" };
            	modelo.setColumnIdentifiers(columnas);
            	tblListarConsultas.setModel(modelo);
            	scrollPane.setViewportView(tblListarConsultas);
            	tblListarConsultas.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13)); 
            	tblListarConsultas.getTableHeader().setForeground(Color.BLUE); 

            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            buttonPane.setBackground(new java.awt.Color(173, 216, 230));
            {
                JButton cancelButton = new JButton("Cerrar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();

                    }
                });
                cancelButton.setActionCommand("Cancel");
                cancelButton.setBackground(new Color(255, 69, 58));
                buttonPane.add(cancelButton);
            }
        }
        cargarConsultas();
    }

    private void cargarConsultas() {

        modelo.setRowCount(0);
        ArrayList<Consulta> listaConsultas = (ArrayList<Consulta>) Clinica.getInstance().getConsultas();
        row = new Object[modelo.getColumnCount()];

        for (int i = 0; i < listaConsultas.size(); i++) {
        	
            Consulta consulta = listaConsultas.get(i);
            Enfermedad enfermedad = consulta.getEnfermedad();
            
            row[0] = "Cons-" + consulta.getIdConsulta();
            row[1] = consulta.isImportante() ? "Si" : "No";
            row[2] = consulta.getPaciente().getNombre() + " " + consulta.getPaciente().getApellido();
            row[3] = consulta.getMedico().getNombre() + " " + consulta.getMedico().getApellido();
            row[4] = consulta.getDiagnostico();
            row[5] = enfermedad.getNombre();
            row[6] = consulta.getTratamiento();
            row[7] = consulta.isTratado() ? "Si" : "No";
            
            modelo.addRow(row);
        }
        
    }
}
