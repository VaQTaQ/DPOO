package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import lógico.Clinica;
import lógico.Cita;
import lógico.Enfermedad;
import lógico.Medico;
import lógico.Paciente;
import lógico.Vacuna;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class HacerCita extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtDoctorId;
    private JTextField txtDoctorNombre;
    private JTextField txtDoctorEspecialidad;
    private JTextField txtCitaPrioridad;
    private JComboBox<String> cmbCitaActiva;
    private JTextField txtPacienteCedula;
    private JTextField txtPacienteNombre;
    private JTextField txtPacienteApellido;
    private JTextField txtPacienteDireccion;
    private JComboBox<String> cmbPacienteSexo;
    private JSpinner spnPacienteEdad;
    private JSpinner spnCitaFecha;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            HacerCita dialog = new HacerCita();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public HacerCita() {
        setTitle("Hacer Cita");
        setBounds(100, 100, 728, 485);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setBackground(new Color(173, 216, 230));  
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel pnlDatosPaciente = new JPanel();
        pnlDatosPaciente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDatosPaciente.setBounds(12, 33, 686, 165);
        pnlDatosPaciente.setBackground(new Color(255, 255, 204)); 
        contentPanel.add(pnlDatosPaciente);
        pnlDatosPaciente.setLayout(null);
        contentPanel.setBackground(new Color(173, 216, 230));  

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setForeground(Color.BLUE);
        lblCedula.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCedula.setBounds(12, 13, 56, 16);
        pnlDatosPaciente.add(lblCedula);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.BLUE);
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombre.setBounds(12, 67, 56, 16);
        pnlDatosPaciente.add(lblNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setForeground(Color.BLUE);
        lblEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEdad.setBounds(12, 125, 56, 16);
        pnlDatosPaciente.add(lblEdad);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setForeground(Color.BLUE);
        lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDireccion.setBounds(456, 13, 68, 16);
        pnlDatosPaciente.add(lblDireccion);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(Color.BLUE);
        lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblApellido.setBounds(246, 67, 56, 16);
        pnlDatosPaciente.add(lblApellido);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setForeground(Color.BLUE);
        lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSexo.setBounds(246, 125, 56, 16);
        pnlDatosPaciente.add(lblSexo);

        txtPacienteCedula = new JTextField();
        txtPacienteCedula.setColumns(10);
        txtPacienteCedula.setBounds(74, 10, 148, 22);
        pnlDatosPaciente.add(txtPacienteCedula);

        txtPacienteNombre = new JTextField();
        txtPacienteNombre.setColumns(10);
        txtPacienteNombre.setBounds(74, 64, 148, 22);
        pnlDatosPaciente.add(txtPacienteNombre);

        txtPacienteApellido = new JTextField();
        txtPacienteApellido.setColumns(10);
        txtPacienteApellido.setBounds(301, 64, 148, 22);
        pnlDatosPaciente.add(txtPacienteApellido);

        txtPacienteDireccion = new JTextField();
        txtPacienteDireccion.setColumns(10);
        txtPacienteDireccion.setBounds(526, 10, 148, 73);
        pnlDatosPaciente.add(txtPacienteDireccion);

        cmbPacienteSexo = new JComboBox<String>();
        cmbPacienteSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
        cmbPacienteSexo.setBounds(301, 122, 145, 22);
        pnlDatosPaciente.add(cmbPacienteSexo);

        spnPacienteEdad = new JSpinner();
        spnPacienteEdad.setModel(new SpinnerNumberModel(18, 0, 120, 1));
        spnPacienteEdad.setBounds(74, 122, 78, 22);
        pnlDatosPaciente.add(spnPacienteEdad);

        JPanel pnlDatosDoctor = new JPanel();
        pnlDatosDoctor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDatosDoctor.setBounds(12, 211, 299, 154);
        pnlDatosDoctor.setBackground(new Color(204, 255, 204));
        contentPanel.add(pnlDatosDoctor);
        pnlDatosDoctor.setLayout(null);
        contentPanel.setBackground(new Color(173, 216, 230));  

        JLabel lblNewLabel = new JLabel("ID Doctor:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setBounds(12, 22, 70, 16);
        pnlDatosDoctor.add(lblNewLabel);

        JLabel lblNombreDoc = new JLabel("Nombre Doc.:");
        lblNombreDoc.setForeground(Color.BLUE);
        lblNombreDoc.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNombreDoc.setBounds(12, 67, 91, 16);
        pnlDatosDoctor.add(lblNombreDoc);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setForeground(Color.BLUE);
        lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEspecialidad.setBounds(12, 112, 75, 16);
        pnlDatosDoctor.add(lblEspecialidad);

        txtDoctorId = new JTextField();
        txtDoctorId.setBounds(94, 19, 91, 22);
        pnlDatosDoctor.add(txtDoctorId);
        txtDoctorId.setColumns(10);

        txtDoctorNombre = new JTextField();
        txtDoctorNombre.setEditable(false);
        txtDoctorNombre.setColumns(10);
        txtDoctorNombre.setBounds(94, 64, 188, 22);
        pnlDatosDoctor.add(txtDoctorNombre);

        txtDoctorEspecialidad = new JTextField();
        txtDoctorEspecialidad.setEditable(false);
        txtDoctorEspecialidad.setColumns(10);
        txtDoctorEspecialidad.setBounds(94, 109, 188, 22);
        pnlDatosDoctor.add(txtDoctorEspecialidad);

        JButton btnBuscarDoctorById = new JButton("Buscar");
        btnBuscarDoctorById.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
                
                Medico doctor = Clinica.getInstance().buscarDoctorById("D-" + txtDoctorId.getText());

                if (doctor != null) {
                    txtDoctorNombre.setText(doctor.getNombre() + " " + doctor.getApellido());
                    txtDoctorEspecialidad.setText(doctor.getEspecialidad());
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Doctor no encontrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    txtDoctorNombre.setText("");
                    txtDoctorEspecialidad.setText("");
                }
            }
        });
        btnBuscarDoctorById.setBounds(197, 18, 85, 25);
        pnlDatosDoctor.add(btnBuscarDoctorById);

        JPanel pnlDatosCita = new JPanel();
        pnlDatosCita.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDatosCita.setBounds(399, 211, 299, 154);
        pnlDatosCita.setBackground(new Color(153, 204, 204));
        contentPanel.add(pnlDatosCita);
        pnlDatosCita.setLayout(null);
        contentPanel.setBackground(new Color(173, 216, 230));  

        JLabel lblPrioridad = new JLabel("Prioridad:");
        lblPrioridad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPrioridad.setForeground(Color.BLUE);
        lblPrioridad.setBounds(10, 23, 70, 16);
        pnlDatosCita.add(lblPrioridad);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(Color.BLUE);
        lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblFecha.setBounds(10, 68, 56, 16);
        pnlDatosCita.add(lblFecha);

        JLabel lblActiva = new JLabel("Activa:");
        lblActiva.setForeground(Color.BLUE);
        lblActiva.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblActiva.setBounds(10, 113, 56, 16);
        pnlDatosCita.add(lblActiva);

        txtCitaPrioridad = new JTextField();
        txtCitaPrioridad.setBounds(90, 20, 94, 22);
        pnlDatosCita.add(txtCitaPrioridad);
        txtCitaPrioridad.setColumns(10);

        spnCitaFecha = new JSpinner();
        spnCitaFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spnCitaFecha.setBounds(90, 65, 119, 22);
        pnlDatosCita.add(spnCitaFecha);

        cmbCitaActiva = new JComboBox<>();
        cmbCitaActiva.setModel(new DefaultComboBoxModel<>(new String[]{"<Seleccione>", "si", "No"}));
        cmbCitaActiva.setBounds(90, 110, 82, 22);
        pnlDatosCita.add(cmbCitaActiva);

        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPane.setBackground(new Color(173, 216, 230));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnHacerCita = new JButton("Hacer Cita");
        btnHacerCita.setBackground(new Color(102, 255, 51));
        btnHacerCita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	
                    if (txtPacienteCedula.getText().isEmpty() || txtPacienteNombre.getText().isEmpty()
                            || txtPacienteApellido.getText().isEmpty()
                            || txtPacienteDireccion.getText().isEmpty()
                            || cmbPacienteSexo.getSelectedIndex() == 0 || txtDoctorId.getText().isEmpty()
                            || txtCitaPrioridad.getText().isEmpty() || cmbCitaActiva.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos .",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return ;
                        
                        
                    }

                    
                    int edad = (Integer) spnPacienteEdad.getValue();
                    String cedula = txtPacienteCedula.getText();
                    String nombre = txtPacienteNombre.getText();
                    String apellido = txtPacienteApellido.getText();
                    String sexo = cmbPacienteSexo.getSelectedItem().toString();
                    String direccion = txtPacienteDireccion.getText();

                    
                    Paciente paciente = Clinica.getInstance().buscarPacientePorCedula(cedula);
                    if (paciente == null) {
                    	
                        String codigoPaciente = "P-" + (Clinica.idPaciente + 1);
                        
                        paciente = new Paciente(cedula, nombre, apellido, edad, sexo, direccion,
                                new ArrayList<>(), new ArrayList<>(), null, codigoPaciente);
                        
                        Clinica.getInstance().registrarPaciente(paciente);
                    }

                   
                    Medico doctor = Clinica.getInstance().buscarDoctorById("D-" + txtDoctorId.getText());
                   
                    if (doctor == null) {
                        JOptionPane.showMessageDialog(null, "Doctor no encontrado.", "Advertencia",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    

                    int prioridad = Integer.parseInt(txtCitaPrioridad.getText());
                    boolean active = cmbCitaActiva.getSelectedItem().toString().equalsIgnoreCase("Si");
                    Date fecha = (Date) spnCitaFecha.getValue();

                    int idCita = Clinica.idCita + 1;
                    Cita cita = new Cita(idCita, paciente, paciente.getCodigoPaciente(), doctor.getCodigoMedico(), prioridad,
                            active, fecha);

                    Clinica.getInstance().registrarCita(cita);

                    JOptionPane.showMessageDialog(null, "Cita creada exitosamente.", "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    

                    clean();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numericos validos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear la cita: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void clean() {
                txtPacienteCedula.setText("");
                txtPacienteNombre.setText("");
                txtPacienteApellido.setText("");
                spnPacienteEdad.setValue(18);//(edad min)
                cmbPacienteSexo.setSelectedIndex(0);
                txtPacienteDireccion.setText("");
                txtDoctorId.setText("");
                txtDoctorNombre.setText("");
                txtDoctorEspecialidad.setText("");
                txtCitaPrioridad.setText("");
                cmbCitaActiva.setSelectedIndex(0);
                spnCitaFecha.setValue(new Date());
            }
        });
        btnHacerCita.setActionCommand("OK");
        buttonPane.add(btnHacerCita);
        getRootPane().setDefaultButton(btnHacerCita);

        JButton cancelButton = new JButton("Cancelar");
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
