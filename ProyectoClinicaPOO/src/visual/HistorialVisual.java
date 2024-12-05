package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lógico.Clinica;
import lógico.Historial;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class HistorialVisual extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable tblHistorial;
    private DefaultTableModel modelo;
    private Object[] row;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            HistorialVisual dialog = new HistorialVisual();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public HistorialVisual() {
        setTitle("Historial de Acciones");
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
            	tblHistorial = new JTable();
            	modelo = new DefaultTableModel();
            	String[] columnas = { "Acción", "Detalle", "Fecha" };
            	modelo.setColumnIdentifiers(columnas);
            	tblHistorial.setModel(modelo);
            	scrollPane.setViewportView(tblHistorial);
            	tblHistorial.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
            	tblHistorial.getTableHeader().setForeground(Color.BLUE); 
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(173, 216, 230));
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
                btnCerrar.setBackground(new Color(255, 0, 0));
                buttonPane.add(btnCerrar);
            }
        }
        cargarHistorial();
    }

    private void cargarHistorial() {
        modelo.setRowCount(0);
        ArrayList<Historial> listaHistorial = Clinica.getInstance().getHistoriales();
        row = new Object[modelo.getColumnCount()];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (Historial historial : listaHistorial) {
            row[0] = historial.getAccion();
            row[1] = historial.getDetalle();
            row[2] = sdf.format(historial.getFecha());

            modelo.addRow(row);
        }
    }
}
