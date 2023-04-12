import javax.swing.*;
import java.awt.*;

public class GuiTienda extends JFrame {
    private JPanel panel1;
    // Configuración básica del JFrame
    public GuiTienda() {

        // Crear un JPanel para la imagen de fondo
        ImagePanel background = new ImagePanel("C:\\Users\\Nacho\\Desktop\\Proyecto\\imagenFondo.jpg");
        background.setLayout(new BorderLayout());
        add(background, BorderLayout.CENTER);






    }


}
