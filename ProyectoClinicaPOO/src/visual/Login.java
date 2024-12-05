package visual;
import java.awt.image.*;
import javax.swing.ImageIcon;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import lógico.Persona;
import lógico.User;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
public class Login extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField Usuario;
    private JPasswordField Contra;
    private JComboBox<String> Rol;
    private JLabel image;

    public static void main(String[] args) {
        try {
            Login dialog = new Login(new ArrayList<User>());
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Login(ArrayList<User> usuariosRegistrados) {
        setTitle("Iniciar Sesión");
        setBounds(100, 100, 521, 358);
        getContentPane().setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        contentPanel.setBackground(new Color(173, 216, 230)); 
        contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("Sistema de Gesti\u00F3n Cl\u00EDnica Homs");
        lblTitulo.setForeground(Color.BLUE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(87, 47, 328, 30);
        contentPanel.add(lblTitulo);
//        
//        ImageIcon imageIcon = new ImageIcon("/logo.jpg"); 
//        //JLabel imageLabel = new JLabel(imageIcon);
//        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        ImageIcon scaledIcon = new ImageIcon("/logo.jpg");
//        JLabel imageLabel = new JLabel(scaledIcon);
//        contentPanel.add(imageLabel);
//        imageLabel.setVisible(true);
        
        JLabel label = new JLabel("Usuario:");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Tahoma", Font.BOLD, 13));
        label.setBounds(84, 122, 70, 14);
        contentPanel.add(label);

        JLabel lblNewLabel = new JLabel("Contraseña:");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(64, 165, 90, 14);
        contentPanel.add(lblNewLabel);

        Usuario = new JTextField();
        Usuario.setBounds(166, 117, 170, 25);
        contentPanel.add(Usuario);
        Usuario.setColumns(10);

        Contra = new JPasswordField();
        Contra.setBounds(166, 160, 170, 25);
        contentPanel.add(Contra);
        Contra.setColumns(10);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setForeground(Color.BLUE);
        lblRol.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblRol.setBounds(115, 194, 26, 30);
        contentPanel.add(lblRol);

        Rol = new JComboBox<>();
        Rol.setFont(new Font("Tahoma", Font.BOLD, 13));
        Rol.setForeground(Color.BLACK);
        Rol.setModel(new DefaultComboBoxModel<>(new String[] { "Médico", "Admin"}));
        Rol.setBounds(166, 197, 170, 25);
        contentPanel.add(Rol);
        
        image = new JLabel("");
        
      //  ImageIcon ico = new ImageIcon(getClass().getResource("/logo.jpg"));
		//ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
        
        //image.setBounds(372, 129, 90, 50);
        //contentPanel.add(image);
        

        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.setBackground(new Color(153, 204, 204)); 
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Iniciar Sesión");
        okButton.setBackground(new Color(102, 255, 51)); 
        okButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	User usuario = new User (Usuario.getText(),new String(Contra.getPassword()), Rol.getSelectedItem().toString(), null, false, false, false);
            	if(usuario.getNombre().equals("admin") && usuario.getPasword().equals("admin") && usuario.getType().equals("Admin")) {
            			usuario.setAdmint(true);
		            	Principal principal = new Principal(usuario);
		                principal.setVisible(true);
		                dispose();
            		}
            	else if(usuario.getNombre().equals("medico") && usuario.getPasword().equals("medico") && usuario.getType().equals("Médico")) {
        			usuario.setAdmint(false);
        			usuario.setMedic(true);
	            	Principal principal = new Principal(usuario);
	                principal.setVisible(true);
	                dispose();
        		}
            	if(usuario.getType().equalsIgnoreCase("Médico")) {
            		usuario.setMedic(true);
            		usuario.setAdmint(false);
            	}
            	if(usuario.getType().equalsIgnoreCase("Admin")) {
            		usuario.setAdmint(true);
            		usuario.setMedic(false);
            	}
            	if(!usuariosRegistrados.isEmpty())
	            	for(User temp : usuariosRegistrados) {
	            		if(temp.getNombre().equals(usuario.getNombre()) && temp.getPasword().equals(usuario.getPasword()) && temp.getType().equals(usuario.getType()))
	            		{
			            	Principal principal = new Principal(temp);
			                principal.setVisible(true);
			                dispose();
	            		}
	            	}
            	else {
            		
            	}
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Salir");
        cancelButton.setBackground(new Color(255, 69, 58));
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