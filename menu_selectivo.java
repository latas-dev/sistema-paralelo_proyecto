import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_selectivo extends JFrame {

    public menu_selectivo() {
        setTitle("Perfiles App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear controles
        JLabel lblPerfil = new JLabel("Perfil:");
        JTextArea txtPerfil = new JTextArea(1, 10);
        JButton btnMostrar = new JButton("Mostrar");
        JLabel lblMedidas = new JLabel("Medidas:");
        JLabel[] lblMedidasArray = new JLabel[6];
        for (int i = 0; i < lblMedidasArray.length; i++) {
            lblMedidasArray[i] = new JLabel();
        }

        // Evento para agregar medidas
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener medidas
                String perfil = txtPerfil.getText();
                if (!perfil.isEmpty()) {
                    String[] medidas = {"750mm", "890mm", "890mm", "100mm", "1200mm", "750mm"};
                    for (int i = 0; i < medidas.length; i++) {
                        lblMedidasArray[i].setText(medidas[i]);
                    }
                }
            }
        });

        // Botones
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar");

        // Contenedor para las medidas
        JPanel medidasPanel = new JPanel();
        medidasPanel.setLayout(new GridLayout(6, 2));
        medidasPanel.add(lblMedidas);
        for (JLabel lblMedida : lblMedidasArray) {
            medidasPanel.add(lblMedida);
        }

        // Crear un panel para el perfil y el botón de agregar
        JPanel perfilPanel = new JPanel(new BorderLayout());
        perfilPanel.add(lblPerfil, BorderLayout.WEST);
        perfilPanel.add(txtPerfil, BorderLayout.CENTER);
        perfilPanel.add(btnMostrar, BorderLayout.EAST);

        // Contenedor para los botones
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(btnModificar);
        buttonsPanel.add(btnEliminar);
        buttonsPanel.add(btnListar);

        // Crear layout principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(perfilPanel, BorderLayout.NORTH);
        mainPanel.add(medidasPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Agregar layout principal al JFrame
        add(mainPanel);

        // Ajustar tamaño y mostrar la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(menu_selectivo::new);
    }
}


