package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Clinica;
import lógico.Consulta;
import lógico.Medico;
import lógico.Enfermedad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class ConsultasXDoctor extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblConsultas;
    private DefaultTableModel modelo;
    private Object[] row;
    private JTextField txtIdDoctor;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultasXDoctor dialog = new ConsultasXDoctor();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ConsultasXDoctor() {
        setTitle("Consultas por Doctor");
        setBounds(100, 100, 800, 500);
        setLocationRelativeTo(null); 
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(SystemColor.activeCaption);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        {
            JPanel topPanel = new JPanel();
            topPanel.setBackground(SystemColor.activeCaption);
            contentPanel.add(topPanel, BorderLayout.NORTH);
            topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel lblIdDoctor = new JLabel("ID del Doctor:");
            topPanel.add(lblIdDoctor);

            txtIdDoctor = new JTextField();
            topPanel.add(txtIdDoctor);
            txtIdDoctor.setColumns(10);

            JButton btnBuscar = new JButton("Buscar");
            btnBuscar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cargarConsultas();
                }
            });
            topPanel.add(btnBuscar);
        }

        {
            JScrollPane scrollPane = new JScrollPane();
            contentPanel.add(scrollPane, BorderLayout.CENTER);
            {
                tblConsultas = new JTable();
                modelo = new DefaultTableModel();
                String[] columnas = { "ID Consulta", "Importante", "Paciente", "Médico", "Diagnóstico", "Enfermedad", "Tratamiento", "Tratado" };
                modelo.setColumnIdentifiers(columnas);
                tblConsultas.setModel(modelo);
                scrollPane.setViewportView(tblConsultas);
                tblConsultas.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13)); 
                tblConsultas.getTableHeader().setForeground(Color.BLUE); 
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            buttonPane.setBackground(SystemColor.activeCaption);
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
    }

    private void cargarConsultas() {
        modelo.setRowCount(0);  

        Medico medico = Clinica.getInstance().buscarDoctorById("D-"+txtIdDoctor.getText());

        if (medico == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el Doctor con ID: " + txtIdDoctor.getText(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Consulta> consultasDoctor = new ArrayList<>();
        for (Consulta consulta : Clinica.getInstance().getConsultas()) {
            if (consulta.getMedico().equals(medico)) {
                consultasDoctor.add(consulta);
            }
        }

        row = new Object[modelo.getColumnCount()];

        for (Consulta consulta : consultasDoctor) {
            row[0] = "Cons-" + consulta.getIdConsulta();
            row[1] = consulta.isImportante() ? "Si" : "No";
            row[2] = consulta.getPaciente().getNombre() + " " + consulta.getPaciente().getApellido();
            row[3] = consulta.getMedico().getNombre() + " " + consulta.getMedico().getApellido();
            row[4] = consulta.getDiagnostico();
            Enfermedad enfermedad = consulta.getEnfermedad();
            row[5] = enfermedad != null ? enfermedad.getNombre() : "N/A";
            row[6] = consulta.getTratamiento();
            row[7] = consulta.isTratado() ? "Si" : "No";

            modelo.addRow(row);
        }
    }
}
