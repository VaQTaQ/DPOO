package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lógico.Clinica;
import lógico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AgregarAdmin extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JTextField txtUsuario;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AgregarAdmin dialog = new AgregarAdmin();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AgregarAdmin() {
        setTitle("Agregar Administrador");
        setBounds(100, 100, 344, 220);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(153, 204, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(new Color(51, 51, 255));
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUsuario.setBounds(12, 16, 81, 16);
        contentPanel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(99, 13, 155, 22);
        contentPanel.add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(new Color(51, 51, 255));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPassword.setBounds(12, 61, 81, 16);
        contentPanel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(99, 58, 155, 22);
        contentPanel.add(txtPassword);

        JLabel lblConfirmPassword = new JLabel("Confirmar:");
        lblConfirmPassword.setForeground(new Color(51, 51, 255));
        lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblConfirmPassword.setBounds(12, 89, 81, 16);
        contentPanel.add(lblConfirmPassword);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(99, 86, 155, 22);
        contentPanel.add(txtConfirmPassword);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(153, 204, 204));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton btnAgregarAdmin = new JButton("Agregar");
            btnAgregarAdmin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    agregarAdmin();
                }
            });
            btnAgregarAdmin.setActionCommand("OK");
            buttonPane.add(btnAgregarAdmin);
            getRootPane().setDefaultButton(btnAgregarAdmin);

            JButton cancelButton = new JButton("Cancelar");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
        }
    }

    private void agregarAdmin() {
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        if (usuario.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Clinica.getInstance().buscarUsuarioPorNombre(usuario) != null) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        User nuevoAdmin = new User(usuario, password, "Administrador", null, true, false,false);

        Clinica.getInstance().registrarUsuario(nuevoAdmin);

        JOptionPane.showMessageDialog(null, "Administrador registrado exitosamente.", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
        dispose();
    }

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
    }
}
