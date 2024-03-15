import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu_selectivo extends JFrame {
    private JRadioButton sequentialRadioButton;
    private JRadioButton parallelRadioButton;
    private JTextField dataTextField;
    private JButton executeButton;

    public menu_selectivo() {
        setTitle("Selección de Ejecución");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tamaño de la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.35); // Tamaño ancho 
        int height = (int) (screenSize.getHeight() * 0.45); // Tamaño altura
        setSize(width, height);

        // Panel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiqueta de selección
        JLabel selectionLabel = new JLabel("Selecciona el tipo de ejecución:");
        mainPanel.add(selectionLabel, gbc);

        // Botones de radio para selección secuencial/paralela
        ButtonGroup executionGroup = new ButtonGroup();
        sequentialRadioButton = new JRadioButton("Secuencial");
        parallelRadioButton = new JRadioButton("Paralela");
        executionGroup.add(sequentialRadioButton);
        executionGroup.add(parallelRadioButton);

        gbc.gridy++;
        mainPanel.add(sequentialRadioButton, gbc);
        gbc.gridy++;
        mainPanel.add(parallelRadioButton, gbc);

        // Campo de texto para ingresar datos
        gbc.gridy++;
        JLabel dataLabel = new JLabel("Ingrese datos:");
        mainPanel.add(dataLabel, gbc);
        gbc.gridy++;
        dataTextField = new JTextField(20);
        mainPanel.add(dataTextField, gbc);

        // Botón de ejecución
        gbc.gridy++;
        executeButton = new JButton("Ejecutar");
        executeButton.addActionListener(new ExecuteButtonListener());
        mainPanel.add(executeButton, gbc);

        add(mainPanel);
    }

    public void opciones() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        menu_selectivo menu = new menu_selectivo();
        menu.opciones();
    }

    private class ExecuteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Verifica qué tipo de ejecución fue seleccionada
            boolean isSequential = sequentialRadioButton.isSelected();
            // Obtiene los datos ingresados por el usuario
            String data = dataTextField.getText();
            // Aquí puedes realizar la lógica de ejecución secuencial o paralela según la selección del usuario
            // Ejemplo: if (isSequential) { // Ejecución secuencial } else { // Ejecución paralela }
            // Aquí puedes imprimir los datos ingresados por el usuario para fines de demostración
            System.out.println("Datos ingresados: " + data);
        }
    }
}

