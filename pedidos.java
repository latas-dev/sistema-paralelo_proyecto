import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pedidos extends JFrame {
    private JComboBox<String> perfilComboBox;
    private JTextArea medidasTextArea;
    private JButton guardarPedidoButton;
    private JButton terminarOrdenButton; // Nuevo botón
    private JTextArea pedidoTextArea;

    private Map<String, String[]> medidasPorPerfil;

    private List<String> pedidosGuardados;

    public pedidos() {
        setTitle("Ingresar Pedido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar mapas y listas
        medidasPorPerfil = new HashMap<>();
        medidasPorPerfil.put("454F", new String[]{"1650mm", "1100mm"});
        medidasPorPerfil.put("890F", new String[]{"480mm", "870mm"});
        medidasPorPerfil.put("490F", new String[]{"2100mm", "729mm"});

        pedidosGuardados = new ArrayList<>();

        // Tamaño de la ventana
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

        // Etiqueta y combo box para perfil
        JLabel perfilLabel = new JLabel("Perfil:");
        mainPanel.add(perfilLabel, gbc);

        String[] perfiles = {"454F", "890F", "490F"};
        perfilComboBox = new JComboBox<>(perfiles);
        gbc.gridx++;
        mainPanel.add(perfilComboBox, gbc);

        // Etiqueta y área de texto para medidas
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel medidasLabel = new JLabel("Medidas:");
        mainPanel.add(medidasLabel, gbc);

        medidasTextArea = new JTextArea(2, 20);
        medidasTextArea.setEditable(false);
        JScrollPane medidasScrollPane = new JScrollPane(medidasTextArea);
        gbc.gridx++;
        mainPanel.add(medidasScrollPane, gbc);

        // Botón para guardar pedido
        gbc.gridx = 0;
        gbc.gridy++;
        guardarPedidoButton = new JButton("Guardar Pedido");
        mainPanel.add(guardarPedidoButton, gbc);

        // Nuevo botón "Terminar Orden"
        terminarOrdenButton = new JButton("Terminar Orden");
        gbc.gridy++;
        mainPanel.add(terminarOrdenButton, gbc);

        // Área de texto para mostrar el pedido
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        pedidoTextArea = new JTextArea(5, 20);
        pedidoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(pedidoTextArea);
        mainPanel.add(scrollPane, gbc);

        // Agregar el panel principal a la ventana
        add(mainPanel);

        // Listeners
        perfilComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String perfilSeleccionado = (String) perfilComboBox.getSelectedItem();
                if (perfilSeleccionado != null) {
                    String[] medidas = medidasPorPerfil.get(perfilSeleccionado);
                    StringBuilder medidasText = new StringBuilder();
                    for (String medida : medidas) {
                        medidasText.append(medida).append("\n");
                    }
                    medidasTextArea.setText(medidasText.toString());
                }
            }
        });

        guardarPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String perfilSeleccionado = (String) perfilComboBox.getSelectedItem();
                if (perfilSeleccionado != null) {
                    String[] medidas = medidasPorPerfil.get(perfilSeleccionado);
                    StringBuilder pedido = new StringBuilder();
                    pedido.append("Perfil: ").append(perfilSeleccionado).append("\n");
                    pedido.append("Medidas: ").append(String.join(", ", medidas)).append("\n");
                    pedidosGuardados.add(pedido.toString());
                    actualizarPedidosTextArea();
                }
            }
        });

        // Listener para el botón "Terminar Orden"
        terminarOrdenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes añadir la lógica para continuar con el cálculo de desperdicio
                JOptionPane.showMessageDialog(pedidos.this, "Orden terminada. Continuar con el cálculo de desperdicio.");
            }
        });
    }

    private void actualizarPedidosTextArea() {
        StringBuilder pedidosText = new StringBuilder();
        for (String pedido : pedidosGuardados) {
            pedidosText.append(pedido).append("\n");
        }
        pedidoTextArea.setText(pedidosText.toString());
    }

    public static void main(String[] args) {
        pedidos frame = new pedidos();
        frame.setVisible(true);
    }
}



