import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizacionDeDatos {
    public static void main(String[] args) {
        // Crear el marco de la aplicación
        JFrame marco = new JFrame("Analizador de Texto");
        marco.setSize(600, 450);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(null);

        // Crear y añadir área de texto para la entrada del usuario
        JTextArea areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(50, 30, 500, 150);
        marco.add(areaDeTexto);

        // Crear y añadir botón para analizar el texto
        JButton botonAnalizar = new JButton("Analizar Texto");
        botonAnalizar.setBounds(50, 210, 150, 30);
        marco.add(botonAnalizar);

        // Crear y añadir etiquetas para mostrar los resultados
        JLabel etiquetaOraciones = new JLabel("Número de oraciones: ");
        etiquetaOraciones.setBounds(100, 260, 500, 30);
        marco.add(etiquetaOraciones);

        JLabel etiquetaPalabras = new JLabel("Número de palabras: ");
        etiquetaPalabras.setBounds(350, 260, 500, 30);
        marco.add(etiquetaPalabras);

        JLabel etiquetaLetras = new JLabel("Número de letras: ");
        etiquetaLetras.setBounds(100, 320, 500, 30);
        marco.add(etiquetaLetras);

        JLabel etiquetaNumeros = new JLabel("Número de números: ");
        etiquetaNumeros.setBounds(350, 320, 500, 30);
        marco.add(etiquetaNumeros);

        JLabel etiquetaEspacios = new JLabel("Número de espacios entre palabras: ");
        etiquetaEspacios.setBounds(100, 370, 500, 30);
        marco.add(etiquetaEspacios);

        // Añadir el listener para el botón de análisis
        botonAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = areaDeTexto.getText();
                int numeroDeOraciones = contarOraciones(texto);
                int numeroDePalabras = contarPalabras(texto);
                int numeroDeLetras = contarLetras(texto);
                int numeroDeNumeros = contarNumeros(texto);
                int numeroDeEspacios = contarEspacios(texto);

                etiquetaOraciones.setText("Número de oraciones: " + numeroDeOraciones);
                etiquetaPalabras.setText("Número de palabras: " + numeroDePalabras);
                etiquetaLetras.setText("Número de letras: " + numeroDeLetras);
                etiquetaNumeros.setText("Número de números: " + numeroDeNumeros);
                etiquetaEspacios.setText("Número de espacios entre palabras: " + numeroDeEspacios);
            }
        });

        // Hacer visible el marco de la aplicación
        marco.setLocationRelativeTo(null); // Colocar la ventana en el centro de la pantalla
        marco.setVisible(true);
    }

    // Contar el número de oraciones en el texto (basado en líneas nuevas)
    private static int contarOraciones(String texto) {
        int cuenta = 0;
        boolean finDeOracion = false;
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == '\n' || i + 1 == texto.length()) {
                finDeOracion = true;
            } else if (finDeOracion && !Character.isWhitespace(c)) {
                finDeOracion = false;
                cuenta++;
            }
        }
        if (finDeOracion) {
            cuenta++;
        }
        return cuenta;
    }

    // Contar el número de palabras en el texto
    private static int contarPalabras(String texto) {
        int cuenta = 0;
        boolean enPalabra = false;
        for (char c : texto.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (!enPalabra) {
                    enPalabra = true;
                    cuenta++;
                }
            } else {
                enPalabra = false;
            }
        }
        return cuenta;
    }

    // Contar el número de letras en el texto
    private static int contarLetras(String texto) {
        int cuenta = 0;
        for (char c : texto.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                cuenta++;
            }
        }
        return cuenta;
    }

    // Contar el número de números en el texto
    private static int contarNumeros(String texto) {
        int cuenta = 0;
        for (char c : texto.toCharArray()) {
            if (c >= '0' && c <= '9') {
                cuenta++;
            }
        }
        return cuenta;
    }

    // Contar el número de espacios en el texto
    private static int contarEspacios(String texto) {
        int cuenta = 0;
        boolean enEspacio = false;
        for (char c : texto.toCharArray()) {
            if (c == ' ') {
                if (!enEspacio) {
                    enEspacio = true;
                    cuenta++;
                }
            } else {
                enEspacio = false;
            }
        }
        return cuenta;
    }
}
