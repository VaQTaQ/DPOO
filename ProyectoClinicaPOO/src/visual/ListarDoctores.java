package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import l�gico.Clinica;
import l�gico.Medico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ListarDoctores extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblListarDoctores;
    private DefaultTableModel modelo;
    private Object[] row;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListarDoctores dialog = new ListarDoctores();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListarDoctores() {
        setTitle("Listado de Doctores");
        setBounds(100, 100, 700, 400);
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
            	tblListarDoctores = new JTable();
            	modelo = new DefaultTableModel();
            	String[] columnas = { "ID", "Nombre y Apellido", "Especialidad", "Edad", "N�mero de Consultas" };
            	modelo.setColumnIdentifiers(columnas);
            	tblListarDoctores.setModel(modelo);
            	scrollPane.setViewportView(tblListarDoctores);
            	tblListarDoctores.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13)); 
            	tblListarDoctores.getTableHeader().setForeground(Color.BLUE); 

                
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
        cargarDoctores();
    }

    private void cargarDoctores() {
    
        modelo.setRowCount(0);
        ArrayList<Medico> listaDoctores = (ArrayList<Medico>) Clinica.getInstance().getMedicos();
        row = new Object[modelo.getColumnCount()];
        
        for (Medico doctor : listaDoctores) {
        	
            row[0] = doctor.getCodigoMedico(); 
            row[1] = doctor.getNombre() + " " + doctor.getApellido(); 
            row[2] = doctor.getEspecialidad(); 
            row[3] = doctor.getEdad(); 
            row[4] = doctor.getNumeroConsultas(); 
            
            modelo.addRow(row);
        }
    }
}
