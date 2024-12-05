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
import lógico.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PacientesXDoctor extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblPacientes;
    private DefaultTableModel modelo;
    private Object[] row;
    private JTextField txtIdDoctor;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            PacientesXDoctor dialog = new PacientesXDoctor();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public PacientesXDoctor() {
        setTitle("Pacientes por Doctor");
        setBounds(100, 100, 800, 500);
        setLocationRelativeTo(null); 
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(SystemColor.activeCaption);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(SystemColor.activeCaption);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblIdDoctor = new JLabel("ID del Doctor:");
        lblIdDoctor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIdDoctor.setForeground(Color.BLUE);
        topPanel.add(lblIdDoctor);

        txtIdDoctor = new JTextField();
        txtIdDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        topPanel.add(txtIdDoctor);
        txtIdDoctor.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBuscar.setBackground(new Color(70, 130, 180));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarPacientes();
            }
        });
        topPanel.add(btnBuscar);

        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        {
            tblPacientes = new JTable();
            modelo = new DefaultTableModel();
            String[] columnas = { "ID Paciente", "Nombre", "Apellido", "Edad", "Sexo", "Dirección", "Cédula" };
            modelo.setColumnIdentifiers(columnas);
            tblPacientes.setModel(modelo);
            scrollPane.setViewportView(tblPacientes);
            tblPacientes.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13)); 
            tblPacientes.getTableHeader().setForeground(Color.BLUE); 
            tblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
            tblPacientes.setRowHeight(25);
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setBackground(SystemColor.activeCaption);
        {
            JButton cancelButton = new JButton("Cerrar");
            cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
            cancelButton.setBackground(new Color(220, 20, 60));
            cancelButton.setForeground(Color.WHITE);
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
        }
    }

    
    private void cargarPacientes() {
        modelo.setRowCount(0); 

        String doctorIdInput = txtIdDoctor.getText().trim();
        if (doctorIdInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID de Doctor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        Medico medico = Clinica.getInstance().buscarDoctorById("D-" + doctorIdInput);

        if (medico == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el Doctor con ID: " + "D-" + doctorIdInput, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Paciente> pacientesDoctor = new ArrayList<>();
        ArrayList<Consulta> consultas = Clinica.getInstance().getConsultas();

        ArrayList<String> pacientesIds = new ArrayList<>(); 
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico)) {
                Paciente paciente = consulta.getPaciente();
                String pacienteId = paciente.getCodigoPaciente();

                boolean yaAgregado = false;
                for (String id : pacientesIds) {
                    if (id.equals(pacienteId)) {
                        yaAgregado = true;
                        break;
                    }
                }

                if (!yaAgregado) {
                    pacientesDoctor.add(paciente);
                    pacientesIds.add(pacienteId);
                }
            }
        }

        if (pacientesDoctor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Doctor con ID: " + "D-" + doctorIdInput + " no tiene pacientes registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        row = new Object[modelo.getColumnCount()];

        for (Paciente paciente : pacientesDoctor) {
            row[0] = paciente.getCodigoPaciente();
            row[1] = paciente.getNombre();
            row[2] = paciente.getApellido();
            row[3] = paciente.getEdad();
            row[4] = paciente.getSexo();
            row[5] = paciente.getDireccion();
            row[6] = paciente.getCedula();

            modelo.addRow(row);
        }
    }
}
