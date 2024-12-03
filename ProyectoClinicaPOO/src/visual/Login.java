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
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Usuario;
    private JPasswordField Contra;
    private JComboBox<String> Rol;

    public static void main(String[] args) {
        try {
            Login dialog = new Login();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Login() {
        setTitle("Iniciar Sesión");
        setBounds(100, 100, 521, 358);
        getContentPane().setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        contentPanel.setBackground(new Color(173, 216, 230)); 
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Sistema de Gestión Clínica");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setBounds(126, 50, 270, 30);
        contentPanel.add(lblTitulo);

        JLabel label = new JLabel("Usuario:");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setBounds(148, 120, 70, 14);
        contentPanel.add(label);

        JLabel lblNewLabel = new JLabel("Contraseña:");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNewLabel.setBounds(126, 163, 90, 14);
        contentPanel.add(lblNewLabel);

        Usuario = new JTextField();
        Usuario.setBounds(208, 117, 170, 25);
        contentPanel.add(Usuario);
        Usuario.setColumns(10);

        Contra = new JPasswordField();
        Contra.setBounds(208, 160, 170, 25);
        contentPanel.add(Contra);
        Contra.setColumns(10);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblRol.setBounds(170, 200, 26, 14);
        contentPanel.add(lblRol);

        Rol = new JComboBox<>();
        Rol.setModel(new DefaultComboBoxModel<>(new String[] { "Médico", "Admin"}));
        Rol.setBounds(208, 197, 170, 25);
        contentPanel.add(Rol);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.setBackground(new Color(173, 216, 230)); 
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Iniciar Sesión");
        okButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana Principal directamente
                Principal principal = new Principal();
                principal.setVisible(true);
                dispose(); // Cerrar ventana de Login
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Salir");
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
}