package rpg;

public class Main {
    public static void main(String[] args) {
        /**
         * Ejecutar la ventana del juego en el hilo de la interfaz gráfica
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Game game = new Game();
                game.setVisible(true);

            }
        });
    }
}
