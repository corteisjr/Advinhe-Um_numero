import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Advinha extends JFrame{
    private int chutes = 1;
    private int chutesAntigos = 0;
    private int numero;
    private JTextField chuteEntrada;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel LabelMessagem1;
    private JLabel LabelMessagem2;
    private JLabel numeroAleatorio = new JLabel("");
    private JButton novoJogoBtn;
    private Color fundo;

    public Advinha(){
        super("Mentalista");

        setLayout(new FlowLayout());
        setFundo(Color.LIGHT_GRAY);
        Label1 = new JLabel("Eu tenho um numero entre 1 a 100");
        add(Label1);
        Label2 = new JLabel("Você pode advinhar? tente: ");
        add(Label2);
        chuteEntrada = new JTextField(5);
        chuteEntrada.addActionListener(new Advinhador());
        add(chuteEntrada);
        LabelMessagem1 = new JLabel("");
        add(LabelMessagem1);
        LabelMessagem2 = new JLabel("");
        add(LabelMessagem2);
        novoJogoBtn = new JButton("Novo Jogo");

        Random gerarNumeroAletorio = new Random();
        numero = gerarNumeroAletorio.nextInt(101);

        novoJogoBtn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    chuteEntrada.setText("");
                    Random gerarNumeroAletorio = new Random();
                    numero = gerarNumeroAletorio.nextInt(101);
                    numeroAleatorio.setText("" + numero);
                    SwingUtilities.updateComponentTreeUI(numeroAleatorio);
                    Label1.setText("");
                    chuteEntrada.setEditable(true);
                    chutes = 0;
                    Label2.setText("Chutes: " + chutes);
                    chutes++;

                }
            }
        );
        Ojogo();
    }

    public Color getFundo() {
        return fundo;
    }

    public void setFundo(Color fundo) {
        this.fundo = fundo;
    }

    public void Ojogo(){}

    class Advinhador implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int advinha;

            advinha = Integer.parseInt(chuteEntrada.getText());
            if (Math.abs(numero - advinha) < Math.abs(numero - chutesAntigos)){
                getContentPane().setBackground(Color.RED);
            }else {
                getContentPane().setBackground(Color.blue);
            }

            chutesAntigos = advinha;
            if (advinha > numero){
                Label1.setText("Muito acima do numero pretendido");
                SwingUtilities.updateComponentTreeUI(Label1);
            }else if (advinha < numero){
                Label1.setText("Muito abaixo do numero pretendido");
            }else{
                Label1.setText("Ta com sorte voce acertou!!");
                SwingUtilities.updateComponentTreeUI(Label1);
                chuteEntrada.setEditable(false);
            }
            Label2.setText("Numero de chutes: " + chutes++);
        }
    }





}