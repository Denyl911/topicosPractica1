import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame {

    private JPanel contentPane;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JComboBox<String> sexBox;
    private JRadioButton rdbtnOpcion;
    private JRadioButton rdbtnOpcion_1;
    private JRadioButton rdbtnOpcion_2;
    private DefaultListModel<String> userList;
    private JCheckBox acceptBox;
    private JSpinner ageField;
    private Boolean checked = false;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public App() {
        setTitle("Registro de empleados");
        setBounds(400, 200, 655, 520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Labels
        JLabel lblName = new JLabel("Nombre");
        lblName.setBounds(47, 32, 85, 14);
        contentPane.add(lblName);
        JLabel lblLastName = new JLabel("Apellidos");
        lblLastName.setBounds(255, 32, 85, 14);
        contentPane.add(lblLastName);
        JLabel lblPhone = new JLabel("Telefono");
        lblPhone.setBounds(47, 85, 85, 14);
        contentPane.add(lblPhone);
        JLabel lblGender = new JLabel("Sexo");
        lblGender.setBounds(255, 85, 85, 14);
        contentPane.add(lblGender);
        JLabel lblBranch = new JLabel("Edad");
        lblBranch.setBounds(255, 150, 85, 14);
        contentPane.add(lblBranch);
        JLabel lblAge = new JLabel("Sucursal");
        lblAge.setBounds(47, 150, 120, 14);
        contentPane.add(lblAge);
        JLabel lblTable = new JLabel("Registro de usuarios");
        lblTable.setBounds(463, 32, 150, 14);
        contentPane.add(lblTable);

        // Campos de texto
        nameField = new JTextField();
        nameField.setBounds(47, 50, 193, 26);
        contentPane.add(nameField);
        lastNameField = new JTextField();
        lastNameField.setBounds(250, 50, 193, 26);
        contentPane.add(lastNameField);
        phoneField = new JTextField();
        phoneField.setBounds(47, 105, 193, 26);
        contentPane.add(phoneField);

        // Botones
        JButton saveBtn = new JButton("Guardar");
        saveBtn.setBounds(50, 300, 89, 23);
        contentPane.add(saveBtn);

        // Menu de opciones
        sexBox = new JComboBox<>();
        sexBox.setBounds(250, 105, 141, 22);
        contentPane.add(sexBox);
        sexBox.addItem("Hombre");
        sexBox.addItem("Mujer");
        sexBox.addItem("Otro");

        // List
        userList = new DefaultListModel<>();
        JList<String> list = new JList<>(userList);
        list.setBounds(460, 50, 200, 350);
        contentPane.add(list);

        // Radio buttons
        rdbtnOpcion = new JRadioButton("Norte");
        rdbtnOpcion.setBounds(43, 170, 109, 23);
        contentPane.add(rdbtnOpcion);

        rdbtnOpcion_1 = new JRadioButton("Centro");
        rdbtnOpcion_1.setBounds(43, 194, 109, 23);
        contentPane.add(rdbtnOpcion_1);

        rdbtnOpcion_2 = new JRadioButton("Sur");
        rdbtnOpcion_2.setBounds(43, 218, 109, 23);
        contentPane.add(rdbtnOpcion_2);
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnOpcion);
        bgroup.add(rdbtnOpcion_1);
        bgroup.add(rdbtnOpcion_2);

        // Edad
        SpinnerModel value = new SpinnerNumberModel(18, // initial value
                0, // minimum value
                100, // maximum value
                1); // step
        ageField = new JSpinner(value);
        ageField.setBounds(250, 170, 50, 30);
        contentPane.add(ageField);

        // Check box
        acceptBox = new JCheckBox("Aceptas los terminos y condiciones");
        acceptBox.setBounds(48, 250, 300, 50);
        contentPane.add(acceptBox);

        // Eventos
        acceptBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    checked = true;
                } else {
                    checked = false;
                }
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checked) {
                    userList.addElement(nameField.getText() + ' ' + lastNameField.getText());
                    nameField.setText("");
                    lastNameField.setText("");
                    phoneField.setText("");
                    JOptionPane.showMessageDialog(contentPane, "¡Registro agregado exitosamente en la sucursal "
                            + sexBox.getItemAt(sexBox.getSelectedIndex()) + "!");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Primero debes aceptar los terminos y condiciones");
                }
            }
        });

        nameField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // Si el caracter introducido es un digito...
                if (Character.isDigit(e.getKeyChar())) {
                    // ... no lo escribe
                    e.consume();
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
        });
        lastNameField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // Si el caracter introducido es un digito...
                if (Character.isDigit(e.getKeyChar())) {
                    // ... no lo escribe
                    e.consume();
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
        });
        phoneField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // Si el caracter introducido no es un digito...
                if (!Character.isDigit(e.getKeyChar())) {
                    // ... no lo escribe
                    e.consume();
                }
            }

            public void keyReleased(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {

            }
        });

    }
}
