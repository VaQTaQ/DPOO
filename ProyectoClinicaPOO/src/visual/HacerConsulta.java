package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lógico.Clinica;
import lógico.Consulta;
import lógico.Enfermedad;
import lógico.Medico;
import lógico.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HacerConsulta extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtPacienteCedula;
    private JTextField txtPacienteNombre;
    private JTextField txtDoctorId;
    private JTextField txtDoctorNombre;
    private JTextField txtDoctorEspecialidad;
    private JTextField txtPacienteId;
    private JTextField txtDiagnostico;
    private JTextField txtPacienteSexo;
    private JTextField txtPacienteEdad;
    private JTextField txtEnfermedadNombre;
    private JTextField txtTratamiento;
    private JComboBox<String> cmbVigilancia;
    private JSpinner spnFechaConsulta;
    private JTextField txtEnfermedadDescripcion;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            HacerConsulta dialog = new HacerConsulta();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public HacerConsulta() {
        setTitle("Hacer Consulta");
        setBounds(100, 100, 538, 713);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel pnlPaciente = new JPanel();
        pnlPaciente.setBounds(12, 42, 491, 165);
        contentPanel.add(pnlPaciente);
        pnlPaciente.setLayout(null);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(12, 13, 56, 16);
        pnlPaciente.add(lblCedula);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(12, 67, 56, 16);
        pnlPaciente.add(lblNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(12, 125, 56, 16);
        pnlPaciente.add(lblEdad);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(246, 125, 56, 16);
        pnlPaciente.add(lblSexo);

        JLabel lblPacienteId = new JLabel("ID Paciente:");
        lblPacienteId.setBounds(246, 13, 70, 16);
        pnlPaciente.add(lblPacienteId);

        txtPacienteCedula = new JTextField();
        txtPacienteCedula.setEditable(false);
        txtPacienteCedula.setColumns(10);
        txtPacienteCedula.setBounds(74, 10, 148, 22);
        pnlPaciente.add(txtPacienteCedula);

        txtPacienteNombre = new JTextField();
        txtPacienteNombre.setEditable(false);
        txtPacienteNombre.setColumns(10);
        txtPacienteNombre.setBounds(74, 64, 306, 22);
        pnlPaciente.add(txtPacienteNombre);

        txtPacienteId = new JTextField();
        txtPacienteId.setColumns(10);
        txtPacienteId.setBounds(324, 10, 56, 22);
        pnlPaciente.add(txtPacienteId);

        JButton btnBuscarPacienteXId = new JButton("Buscar");
        btnBuscarPacienteXId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Paciente paciente = Clinica.getInstance().buscarPacienteById("P-" + txtPacienteId.getText());

                if (paciente != null) {
                    txtPacienteCedula.setText(paciente.getCedula());
                    txtPacienteNombre.setText(paciente.getNombre() + " " + paciente.getApellido());
                    txtPacienteSexo.setText(paciente.getSexo());
                    txtPacienteEdad.setText(String.valueOf(paciente.getEdad()));
                } else {
                    JOptionPane.showMessageDialog(null, "Paciente no encontrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    limpiarDatosPaciente();
                }
            }
        });
        btnBuscarPacienteXId.setBounds(381, 9, 70, 25);
        pnlPaciente.add(btnBuscarPacienteXId);

        txtPacienteSexo = new JTextField();
        txtPacienteSexo.setEditable(false);
        txtPacienteSexo.setColumns(10);
        txtPacienteSexo.setBounds(303, 122, 148, 22);
        pnlPaciente.add(txtPacienteSexo);

        txtPacienteEdad = new JTextField();
        txtPacienteEdad.setEditable(false);
        txtPacienteEdad.setColumns(10);
        txtPacienteEdad.setBounds(74, 122, 80, 22);
        pnlPaciente.add(txtPacienteEdad);

        JPanel pnlDoctor = new JPanel();
        pnlDoctor.setBounds(108, 220, 299, 154);
        contentPanel.add(pnlDoctor);
        pnlDoctor.setLayout(null);

        JLabel lblDoctorId = new JLabel("ID Doctor:");
        lblDoctorId.setBounds(12, 22, 70, 16);
        pnlDoctor.add(lblDoctorId);

        JLabel lblDoctorNombre = new JLabel("Nombre Doc.:");
        lblDoctorNombre.setBounds(12, 67, 91, 16);
        pnlDoctor.add(lblDoctorNombre);

        JLabel lblDoctorEspecialidad = new JLabel("Especialidad:");
        lblDoctorEspecialidad.setBounds(12, 112, 75, 16);
        pnlDoctor.add(lblDoctorEspecialidad);

        txtDoctorId = new JTextField();
        txtDoctorId.setColumns(10);
        txtDoctorId.setBounds(94, 19, 91, 22);
        pnlDoctor.add(txtDoctorId);

        txtDoctorNombre = new JTextField();
        txtDoctorNombre.setEditable(false);
        txtDoctorNombre.setColumns(10);
        txtDoctorNombre.setBounds(94, 64, 188, 22);
        pnlDoctor.add(txtDoctorNombre);

        txtDoctorEspecialidad = new JTextField();
        txtDoctorEspecialidad.setEditable(false);
        txtDoctorEspecialidad.setColumns(10);
        txtDoctorEspecialidad.setBounds(94, 109, 188, 22);
        pnlDoctor.add(txtDoctorEspecialidad);

        JButton btnBuscarDoctorXId = new JButton("Buscar");
        btnBuscarDoctorXId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
                Medico medico = Clinica.getInstance().buscarDoctorById("D-" + txtDoctorId.getText());

                if (medico != null) {
                    txtDoctorNombre.setText(medico.getNombre() + " " + medico.getApellido());
                    txtDoctorEspecialidad.setText(medico.getEspecialidad());
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Doctor no encontrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    limpiarDatosDoctor();
                }
            }
        });
        btnBuscarDoctorXId.setBounds(197, 18, 85, 25);
        pnlDoctor.add(btnBuscarDoctorXId);

        JPanel pnlConsulta = new JPanel();
        pnlConsulta.setBounds(32, 387, 454, 222);
        contentPanel.add(pnlConsulta);
        pnlConsulta.setLayout(null);

        JLabel lblFechaConsulta = new JLabel("Fecha:");
        lblFechaConsulta.setBounds(239, 190, 56, 16);
        pnlConsulta.add(lblFechaConsulta);

        spnFechaConsulta = new JSpinner();
        spnFechaConsulta.setModel(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        spnFechaConsulta.setBounds(285, 187, 119, 22);
        pnlConsulta.add(spnFechaConsulta);

        JLabel lblDiagnostico = new JLabel("Diagnostico:");
        lblDiagnostico.setBounds(31, 16, 89, 16);
        pnlConsulta.add(lblDiagnostico);

        JLabel lblEnfermedad = new JLabel("Enfermedad:");
        lblEnfermedad.setBounds(31, 45, 74, 16);
        pnlConsulta.add(lblEnfermedad);

        JLabel lblTratamiento = new JLabel("Tratamiento:");
        lblTratamiento.setBounds(31, 133, 80, 16);
        pnlConsulta.add(lblTratamiento);

        JLabel lblVigilancia = new JLabel("Importante para vigilancia:");
        lblVigilancia.setBounds(11, 191, 160, 16);
        pnlConsulta.add(lblVigilancia);

        txtDiagnostico = new JTextField();
        txtDiagnostico.setBounds(114, 13, 268, 22);
        pnlConsulta.add(txtDiagnostico);
        txtDiagnostico.setColumns(10);

        txtEnfermedadNombre = new JTextField();
        txtEnfermedadNombre.setColumns(10);
        txtEnfermedadNombre.setBounds(114, 45, 268, 22);
        pnlConsulta.add(txtEnfermedadNombre);

        txtTratamiento = new JTextField();
        txtTratamiento.setColumns(10);
        txtTratamiento.setBounds(114, 135, 268, 46);
        pnlConsulta.add(txtTratamiento);

        cmbVigilancia = new JComboBox<>();
        cmbVigilancia.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "No" }));
        cmbVigilancia.setBounds(166, 188, 56, 22);
        pnlConsulta.add(cmbVigilancia);
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setBounds(31, 74, 74, 16);
        pnlConsulta.add(lblDescripcion);
        
        txtEnfermedadDescripcion = new JTextField();
        txtEnfermedadDescripcion.setColumns(10);
        txtEnfermedadDescripcion.setBounds(114, 74, 268, 56);
        pnlConsulta.add(txtEnfermedadDescripcion);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnHacerConsulta = new JButton("Hacer Consulta");
        btnHacerConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                try {
                    if (txtPacienteId.getText().isEmpty() || txtDoctorId.getText().isEmpty()
                            || txtDiagnostico.getText().isEmpty() || txtEnfermedadNombre.getText().isEmpty()
                            || txtTratamiento.getText().isEmpty() || cmbVigilancia.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Complete todos los campos obligatorios.", "Advertencia",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    

                    Paciente paciente = Clinica.getInstance().buscarPacienteById("P-" + txtPacienteId.getText());

                    if (txtPacienteId.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Paciente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    

                    Medico medico = Clinica.getInstance().buscarDoctorById("D-" + txtDoctorId.getText());
                    if (medico == null) {
                        JOptionPane.showMessageDialog(null, "Doctor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    

                    String diagnostico = txtDiagnostico.getText();
                    String enfermedadNombre = txtEnfermedadNombre.getText();
                    boolean bajoVigilancia = cmbVigilancia.getSelectedItem().toString().equalsIgnoreCase("Si");
                    String enfermedadDescripcion = txtEnfermedadDescripcion.getText();

                    Enfermedad enfermedad = new Enfermedad(enfermedadNombre, enfermedadDescripcion, bajoVigilancia);

                    
                    
                    String tratamiento = txtTratamiento.getText();
                    boolean importante = bajoVigilancia;

                    Date fecha = (Date) spnFechaConsulta.getValue();
                    int idConsulta = Clinica.idConsulta + 1;

                    Consulta consulta = new Consulta(idConsulta, paciente, medico, fecha, diagnostico, enfermedad, tratamiento, false,
                            importante);

                    Clinica.getInstance().registrarConsulta(consulta);

                    JOptionPane.showMessageDialog(null, "Consulta registrada exitosamente.", "Información",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    

                    limpiarFormulario();
                    
                    
                    

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar la consulta: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPane.add(btnHacerConsulta);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(cancelButton);
    }

    private void limpiarDatosPaciente() {
        txtPacienteCedula.setText("");
        txtPacienteNombre.setText("");
        txtPacienteSexo.setText("");
        txtPacienteEdad.setText("");
    }

    private void limpiarDatosDoctor() {
        txtDoctorNombre.setText("");
        txtDoctorEspecialidad.setText("");
    }

    private void limpiarFormulario() {
        limpiarDatosPaciente();
        limpiarDatosDoctor();
        txtPacienteId.setText("");
        txtDoctorId.setText("");
        txtDiagnostico.setText("");
        txtEnfermedadNombre.setText("");
        txtTratamiento.setText("");
        cmbVigilancia.setSelectedIndex(0);
        spnFechaConsulta.setValue(new Date());
    }
}
