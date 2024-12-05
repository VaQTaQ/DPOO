package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Clinica;
import lógico.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class ListarAdmins extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblListarAdmins;
    private DefaultTableModel modelo;
    private Object[] row;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListarAdmins dialog = new ListarAdmins();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListarAdmins() {
        setTitle("Listado de Administradores");
        setBounds(100, 100, 500, 300);
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
                tblListarAdmins = new JTable();
                modelo = new DefaultTableModel();
                String[] columnas = { "Nombre de Usuario", "Contraseña" };
                modelo.setColumnIdentifiers(columnas);
                tblListarAdmins.setModel(modelo);
                scrollPane.setViewportView(tblListarAdmins);
                tblListarAdmins.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
                tblListarAdmins.getTableHeader().setForeground(Color.BLUE);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(SystemColor.activeCaption);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton btnCerrar = new JButton("Cerrar");
                btnCerrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                btnCerrar.setActionCommand("Cancel");
                buttonPane.add(btnCerrar);
            }
        }
        cargarAdmins();
    }

    private void cargarAdmins() {
        modelo.setRowCount(0);
        ArrayList<User> listaUsuarios = Clinica.getInstance().getUsuarios();
        row = new Object[modelo.getColumnCount()];

        for (User user : listaUsuarios) {
            if (user.isAdmint()) {
                row[0] = user.getNombre();
                row[1] = user.getPasword();
                modelo.addRow(row);
            }
        }
    }
}
