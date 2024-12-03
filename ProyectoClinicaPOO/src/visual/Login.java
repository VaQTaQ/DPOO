package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Usuario;
    private JTextField Contra;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            Login dialog = new Login();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public Login() {
        setBounds(100, 100, 521, 358);
        getContentPane().setLayout(new BorderLayout());

        // Cambiar el color de fondo del contentPanel
        contentPanel.setBackground(new Color(173, 216, 230)); // Azul clarito (RGB: 173, 216, 230)
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel label = new JLabel("Usuario:");
        label.setBounds(148, 120, 48, 14);
        contentPanel.add(label);

        JLabel lblNewLabel = new JLabel("Contrase�a:");
        lblNewLabel.setBounds(126, 163, 70, 14);
        contentPanel.add(lblNewLabel);

        Usuario = new JTextField();
        Usuario.setBounds(208, 117, 111, 20);
        contentPanel.add(Usuario);
        Usuario.setColumns(10);

        Contra = new JTextField();
        Contra.setBounds(208, 160, 111, 20);
        contentPanel.add(Contra);
        Contra.setColumns(10);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(170, 200, 26, 14);
        contentPanel.add(lblRol);

        JComboBox<String> Rol = new JComboBox<>();
        Rol.setModel(new DefaultComboBoxModel<>(new String[] {"Paciente", "M�dico", "Administra"}));
        Rol.setBounds(208, 197, 111, 20);
        contentPanel.add(Rol);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.setBackground(new Color(173, 216, 230)); // Azul clarito
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Registrar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Salir");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
}
