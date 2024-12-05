package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import lógico.Clinica;
import lógico.Paciente;
import lógico.Vacuna;
import lógico.VacunaDisponible;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ControlVacuna extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombreVacuna;
    private JTable tblListarVacunas;
    private DefaultTableModel modelo;
    private Object[] row;
    private JSpinner spnEdadMinima;
    private JSpinner spnEdadMaxima;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ControlVacuna dialog = new ControlVacuna();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ControlVacuna() {
        setTitle("Control de Vacunas");
        setBounds(100, 100, 659, 392);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(173, 216, 230)); 
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JPanel pnlEliminarVacuna = new JPanel();
            pnlEliminarVacuna.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
            pnlEliminarVacuna.setBounds(12, 13, 404, 285);
            pnlEliminarVacuna.setBackground(new Color(255, 255, 204)); 
            contentPanel.add(pnlEliminarVacuna);
            pnlEliminarVacuna.setLayout(null);
            {
                JButton btnEliminarVacuna = new JButton("Eliminar");
                //btnEliminarVacuna.setBackground(new Color(255, 0, 0));
                btnEliminarVacuna.setBounds(295, 260, 97, 25);
                pnlEliminarVacuna.add(btnEliminarVacuna);
                btnEliminarVacuna.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = tblListarVacunas.getSelectedRow();

                        if (selectedRow >= 0) {

                            String nombreVacuna = (String) modelo.getValueAt(selectedRow, 0);
                            VacunaDisponible vacunaAEliminar = null;

                            for (VacunaDisponible vacunaDisponible : Clinica.getInstance().getVacunasDisponibles()) {

                                if (vacunaDisponible.getNombre().equalsIgnoreCase(nombreVacuna)) {

                                    vacunaAEliminar = vacunaDisponible;
                                    break;
                                }
                            }

                            if (vacunaAEliminar != null) {
                                Clinica.getInstance().getVacunasDisponibles().remove(vacunaAEliminar);
                                cargarVacunas();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe seleccionar una vacuna para eliminar.",
                                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
            }
            {
                JPanel pnlListarVacunas = new JPanel();
                pnlListarVacunas.setBounds(12, 13, 380, 247);
                pnlListarVacunas.setBackground(new Color(173, 216, 230)); 
                pnlEliminarVacuna.add(pnlListarVacunas);
                pnlListarVacunas.setLayout(new BorderLayout(0, 0));

                JScrollPane scrollPane = new JScrollPane();
                pnlListarVacunas.add(scrollPane, BorderLayout.CENTER);

                tblListarVacunas = new JTable();
                modelo = new DefaultTableModel();
                String[] columnas = { "Nombre", "Edad Min", "Edad Max", "Cantidad Vacunados" };
                tblListarVacunas.getTableHeader().setForeground(new Color(0, 0, 255));
                tblListarVacunas.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
                modelo.setColumnIdentifiers(columnas);
                tblListarVacunas.setModel(modelo);
                scrollPane.setViewportView(tblListarVacunas);
            }
        }
        {
            JPanel pnlAgregarVacuna = new JPanel();
            pnlAgregarVacuna.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
            pnlAgregarVacuna.setBounds(428, 13, 201, 285);
            pnlAgregarVacuna.setBackground(new Color(204, 255, 204)); 
            contentPanel.add(pnlAgregarVacuna);
            pnlAgregarVacuna.setLayout(null);
            {
                JLabel lblNewLabel = new JLabel("Nombre:");
                lblNewLabel.setForeground(Color.BLUE);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
                lblNewLabel.setBounds(72, 13, 56, 16);
                pnlAgregarVacuna.add(lblNewLabel);
            }
            {
                JLabel lblEdadMinima = new JLabel("Edad Minima:");
                lblEdadMinima.setForeground(Color.BLUE);
                lblEdadMinima.setFont(new Font("Tahoma", Font.BOLD, 13));
                lblEdadMinima.setBounds(60, 99, 80, 16);
                pnlAgregarVacuna.add(lblEdadMinima);
            }
            {
                JLabel lblEdadMaxima = new JLabel("Edad Maxima:");
                lblEdadMaxima.setForeground(Color.BLUE);
                lblEdadMaxima.setFont(new Font("Tahoma", Font.BOLD, 13));
                lblEdadMaxima.setBounds(60, 175, 88, 16);
                pnlAgregarVacuna.add(lblEdadMaxima);
            }
            {
                JButton btnAgregarVacuna = new JButton("Agregar Vacuna");
                //btnAgregarVacuna.setBackground(new Color(0, 255, 0));
                btnAgregarVacuna.setBounds(45, 247, 125, 25);
                pnlAgregarVacuna.add(btnAgregarVacuna);
                btnAgregarVacuna.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nombre = txtNombreVacuna.getText();
                        int minEdad = (int) spnEdadMinima.getValue();
                        int maxEdad = (int) spnEdadMaxima.getValue();

                        if (!nombre.isEmpty()) {

                            VacunaDisponible nuevaVacuna = new VacunaDisponible(nombre, minEdad, maxEdad);
                            Clinica.getInstance().registrarVacunaDisponible(nuevaVacuna);
                            cargarVacunas();
                            txtNombreVacuna.setText("");
                            spnEdadMinima.setValue(0);
                            spnEdadMaxima.setValue(0);

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El nombre de la vacuna no puede estar vacío.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
            {
                txtNombreVacuna = new JTextField();
                txtNombreVacuna.setBounds(27, 35, 146, 51);
                pnlAgregarVacuna.add(txtNombreVacuna);
                txtNombreVacuna.setColumns(10);
            }
            {
                spnEdadMinima = new JSpinner();
                spnEdadMinima.setBounds(78, 128, 44, 22);
                pnlAgregarVacuna.add(spnEdadMinima);
            }
            {
                spnEdadMaxima = new JSpinner();
                spnEdadMaxima.setBounds(78, 206, 44, 22);
                pnlAgregarVacuna.add(spnEdadMaxima);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
            buttonPane.setBackground(new Color(153, 204, 204));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton cancelButton = new JButton("Cerrar");
                cancelButton.setBackground(new Color(255, 69, 58));
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
            }
        }

        cargarVacunas();
    }

    private void cargarVacunas() {
        modelo.setRowCount(0);
        ArrayList<VacunaDisponible> listaVacunas = Clinica.getInstance().getVacunasDisponibles();
        row = new Object[modelo.getColumnCount()];

        for (VacunaDisponible vacunaDisponible : listaVacunas) {

            row[0] = vacunaDisponible.getNombre();

            row[1] = vacunaDisponible.getMinEdad();

            row[2] = vacunaDisponible.getMaxEdad();

            row[3] = getCantPacientesVacunados(vacunaDisponible);

            modelo.addRow(row);
        }
    }

    private int getCantPacientesVacunados(VacunaDisponible vacunaDisponible) {

        ArrayList<Paciente> pacientes = Clinica.getInstance().getPacientes();
        int cont = 0;

        for (Paciente paciente : pacientes) {
            ArrayList<Vacuna> vacunasPuestas = paciente.getMisVacunas();

            for (Vacuna vacuna : vacunasPuestas) {

                if (vacuna.getNombre().equalsIgnoreCase(vacunaDisponible.getNombre())) {
                    cont++;

                }
            }

        }

        return cont;
    }
}
