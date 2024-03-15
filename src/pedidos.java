
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pedidos extends JFrame {
    private JComboBox<String> medidasComboBox;
    private JComboBox<String> resistenciaComboBox;
    private JTextField cantidadTextField;
    private JButton agregarMaterialButton;
    private JButton calcularCostoButton;
    private JTextArea pedidoTextArea;

    public pedidos() {
        setTitle("Ingresar Pedido");
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

        // Etiqueta y combo box para medidas
        JLabel medidasLabel = new JLabel("Medidas:");
        mainPanel.add(medidasLabel, gbc);

        String[] medidas = {"Pequeño", "Mediano", "Grande"};
        medidasComboBox = new JComboBox<>(medidas);
        gbc.gridx++;
        mainPanel.add(medidasComboBox, gbc);

        // Etiqueta y combo box para tipo de resistencia
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel resistenciaLabel = new JLabel("Tipo de Resistencia:");
        mainPanel.add(resistenciaLabel, gbc);

        String[] resistencia = {"Super Ligero", "Ligero", "Normal", "Fuerte"};
        resistenciaComboBox = new JComboBox<>(resistencia);
        gbc.gridx++;
        mainPanel.add(resistenciaComboBox, gbc);

        // Etiqueta y campo de texto para cantidad de materiales
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel cantidadLabel = new JLabel("Cantidad de Materiales:");
        mainPanel.add(cantidadLabel, gbc);

        cantidadTextField = new JTextField(10);
        gbc.gridx++;
        mainPanel.add(cantidadTextField, gbc);

        // Botón para agregar material al pedido
        gbc.gridx = 0;
        gbc.gridy++;
        agregarMaterialButton = new JButton("Agregar Material");
        mainPanel.add(agregarMaterialButton, gbc);

        // Área de texto para mostrar el pedido
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        pedidoTextArea = new JTextArea(5, 20);
        pedidoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(pedidoTextArea);
        mainPanel.add(scrollPane, gbc);

        // Botón para calcular el costo total
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        calcularCostoButton = new JButton("Calcular Costo Total");
        mainPanel.add(calcularCostoButton, gbc);

        // Agregar el panel principal a la ventana
        add(mainPanel);
    }

    public static void main(String[] args) {
        pedidos frame = new pedidos();
        frame.setVisible(true);
    }
}

