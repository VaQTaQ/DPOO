package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import lógico.Clinica;
import lógico.Consulta;
import lógico.Enfermedad;
import lógico.Medico;
import lógico.Paciente;
import lógico.Reporte;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
    private Paciente pacienteSeleccionado;


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
        setBounds(100, 100, 584, 717);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(173, 216, 230));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JPanel pnlPaciente = new JPanel();
        pnlPaciente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlPaciente.setBackground(new Color(255, 255, 255));
        pnlPaciente.setBounds(24, 42, 518, 165);
        contentPanel.add(pnlPaciente);
        pnlPaciente.setLayout(null);
        pnlPaciente.setBackground(new Color(173, 216, 230));  // Azul clarito


        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setForeground(new Color(0, 0, 255));
        lblCedula.setBounds(36, 17, 56, 16);
        pnlPaciente.add(lblCedula);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(0, 0, 255));
        lblNombre.setBounds(36, 71, 56, 16);
        pnlPaciente.add(lblNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setForeground(new Color(0, 0, 255));
        lblEdad.setBounds(36, 129, 56, 16);
        pnlPaciente.add(lblEdad);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setForeground(new Color(0, 0, 255));
        lblSexo.setBounds(270, 129, 56, 16);
        pnlPaciente.add(lblSexo);

        JLabel lblPacienteId = new JLabel("ID Paciente:");
        lblPacienteId.setForeground(new Color(0, 0, 255));
        lblPacienteId.setBounds(270, 17, 70, 16);
        pnlPaciente.add(lblPacienteId);

        txtPacienteCedula = new JTextField();
        txtPacienteCedula.setEditable(false);
        txtPacienteCedula.setColumns(10);
        txtPacienteCedula.setBounds(98, 14, 148, 22);
        pnlPaciente.add(txtPacienteCedula);

        txtPacienteNombre = new JTextField();
        txtPacienteNombre.setEditable(false);
        txtPacienteNombre.setColumns(10);
        txtPacienteNombre.setBounds(98, 68, 306, 22);
        pnlPaciente.add(txtPacienteNombre);

        txtPacienteId = new JTextField();
        txtPacienteId.setColumns(10);
        txtPacienteId.setBounds(348, 14, 56, 22);
        pnlPaciente.add(txtPacienteId);

        JButton btnBuscarPacienteXId = new JButton("Buscar");
        btnBuscarPacienteXId.setForeground(Color.BLACK);
        btnBuscarPacienteXId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                Paciente paciente = Clinica.getInstance().buscarPacienteById("P-" + txtPacienteId.getText());
                pacienteSeleccionado = paciente;

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
        btnBuscarPacienteXId.setBounds(405, 13, 80, 25);
        pnlPaciente.add(btnBuscarPacienteXId);

        txtPacienteSexo = new JTextField();
        txtPacienteSexo.setEditable(false);
        txtPacienteSexo.setColumns(10);
        txtPacienteSexo.setBounds(327, 126, 148, 22);
        pnlPaciente.add(txtPacienteSexo);

        txtPacienteEdad = new JTextField();
        txtPacienteEdad.setEditable(false);
        txtPacienteEdad.setColumns(10);
        txtPacienteEdad.setBounds(98, 126, 80, 22);
        pnlPaciente.add(txtPacienteEdad);

        JPanel pnlDoctor = new JPanel();
        pnlDoctor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlDoctor.setBackground(new Color(240, 255, 240));
        pnlDoctor.setBounds(133, 220, 299, 154);
        contentPanel.add(pnlDoctor);
        pnlDoctor.setLayout(null);
        pnlDoctor.setBackground(new Color(173, 216, 230));  // Azul clarito


        JLabel lblDoctorId = new JLabel("ID Doctor:");
        lblDoctorId.setForeground(new Color(0, 0, 255));
        lblDoctorId.setBounds(12, 22, 70, 16);
        pnlDoctor.add(lblDoctorId);

        JLabel lblDoctorNombre = new JLabel("Nombre Doc.:");
        lblDoctorNombre.setForeground(new Color(0, 0, 255));
        lblDoctorNombre.setBounds(12, 67, 91, 16);
        pnlDoctor.add(lblDoctorNombre);

        JLabel lblDoctorEspecialidad = new JLabel("Especialidad:");
        lblDoctorEspecialidad.setForeground(new Color(0, 0, 255));
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
        btnBuscarDoctorXId.setForeground(Color.BLACK);
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
        pnlConsulta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        pnlConsulta.setBackground(new Color(255, 255, 204));
        pnlConsulta.setBounds(27, 387, 512, 221);
        contentPanel.add(pnlConsulta);
        pnlConsulta.setBackground(new Color(173, 216, 230));  // Azul clarito
        pnlConsulta.setLayout(null);


        JLabel lblFechaConsulta = new JLabel("Fecha:");
        lblFechaConsulta.setBounds(239, 190, 56, 16);
        lblFechaConsulta.setForeground(new Color(0, 0, 255));
        pnlConsulta.add(lblFechaConsulta);

        spnFechaConsulta = new JSpinner();
        spnFechaConsulta.setBounds(285, 187, 119, 22);
        spnFechaConsulta.setModel(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        pnlConsulta.add(spnFechaConsulta);

        JLabel lblDiagnostico = new JLabel("Diagnostico:");
        lblDiagnostico.setBounds(31, 16, 89, 16);
        lblDiagnostico.setForeground(new Color(0, 0, 255));
        pnlConsulta.add(lblDiagnostico);

        JLabel lblEnfermedad = new JLabel("Enfermedad:");
        lblEnfermedad.setBounds(31, 45, 74, 16);
        lblEnfermedad.setForeground(new Color(0, 0, 255));
        pnlConsulta.add(lblEnfermedad);

        JLabel lblTratamiento = new JLabel("Tratamiento:");
        lblTratamiento.setBounds(31, 133, 80, 16);
        lblTratamiento.setForeground(new Color(0, 0, 255));
        pnlConsulta.add(lblTratamiento);

        JLabel lblVigilancia = new JLabel("Importante para vigilancia:");
        lblVigilancia.setBounds(11, 191, 160, 16);
        lblVigilancia.setForeground(new Color(0, 0, 255));
        pnlConsulta.add(lblVigilancia);

        txtDiagnostico = new JTextField();
        txtDiagnostico.setBounds(114, 13, 268, 22);
        pnlConsulta.add(txtDiagnostico);
        txtDiagnostico.setColumns(10);

        txtEnfermedadNombre = new JTextField();
        txtEnfermedadNombre.setBounds(114, 45, 268, 22);
        txtEnfermedadNombre.setColumns(10);
        pnlConsulta.add(txtEnfermedadNombre);

        txtTratamiento = new JTextField();
        txtTratamiento.setBounds(114, 135, 268, 46);
        txtTratamiento.setColumns(10);
        pnlConsulta.add(txtTratamiento);

        cmbVigilancia = new JComboBox<>();
        cmbVigilancia.setBounds(166, 188, 56, 22);
        cmbVigilancia.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "No" }));
        pnlConsulta.add(cmbVigilancia);
        
        JLabel lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setBounds(31, 74, 74, 16);
        lblDescripcion.setForeground(new Color(0, 0, 255));
        pnlConsulta.add(lblDescripcion);
        
        txtEnfermedadDescripcion = new JTextField();
        txtEnfermedadDescripcion.setBounds(114, 74, 268, 56);
        txtEnfermedadDescripcion.setColumns(10);
        pnlConsulta.add(txtEnfermedadDescripcion);
        
        JButton btnVacunar = new JButton("Vacunar");
        btnVacunar.setBounds(403, 146, 97, 25);
        //btnVacunar.setBackground(new Color(255, 0, 0));
        btnVacunar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VacunarPaciente vacPaciente = new VacunarPaciente(pacienteSeleccionado);
        		vacPaciente.setModal(true);
        		vacPaciente.setVisible(true);
        		
        	}
        });
        pnlConsulta.add(btnVacunar);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(173, 216, 230));
        buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnHacerConsulta = new JButton("Hacer Consulta");
        btnHacerConsulta.setBackground(new Color(102, 255, 51));
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
                    
                    if (paciente.getHistoriaClinica() == null) { 
                        paciente.setHistoriaClinica(new Reporte("H-" + paciente.getCodigoPaciente(), paciente)); 
                    }
                    paciente.getHistoriaClinica().agregarConsulta(consulta); 
                    

                    limpiarFormulario();
                    
                    
                    

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar la consulta: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPane.add(btnHacerConsulta);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBackground(new Color(255, 69, 58));
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
