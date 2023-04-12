import javax.swing.*;
import java.awt.*;

public class LoginGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");
        JPanel panel = new JPanel();

        // Configurar el panel con la imagen de fondo
        ImagePanel background = new ImagePanel("C:\\Users\\Nacho\\Desktop\\Proyecto\\imagenFondo.jpg");
        panel.setLayout(new BorderLayout());
        panel.add(background, BorderLayout.CENTER);

        // Agregar los componentes al panel
        JLabel labelUsuario = new JLabel("Usuario:");
        JTextField textFieldUsuario = new JTextField(10);
        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField(10);
        JButton buttonIniciarSesion = new JButton("Iniciar Sesión");

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 2));
        panelFormulario.add(labelUsuario);
        panelFormulario.add(textFieldUsuario);
        panelFormulario.add(labelContrasena);
        panelFormulario.add(passwordField);
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(buttonIniciarSesion);

        panel.add(panelFormulario, BorderLayout.SOUTH);

        // Configurar el frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}