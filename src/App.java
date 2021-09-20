import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        Advinha jogo = new Advinha();
        jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jogo.setSize(550, 150);
        jogo.setVisible(true);
    }
}
