package dvd;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelQuadradosSaltitantes extends JPanel implements ActionListener {

    private static final int TAMANHO_QUADRADO = 20;
    private static final int VELOCIDADE_DO_QUADRADO = 5;
    private int posXQuadrado1, posYQuadrado1;
    private int posXQuadrado2, posYQuadrado2;
    private int velocidadeXQuadrado1, velocidadeYQuadrado1;
    private int velocidadeXQuadrado2, velocidadeYQuadrado2;

    public PainelQuadradosSaltitantes() {
        setPreferredSize(new Dimension(800, 300));
        setBackground(Color.BLACK);

        posXQuadrado1 = 0;
        posYQuadrado1 = 0;
        velocidadeXQuadrado1 = VELOCIDADE_DO_QUADRADO;
        velocidadeYQuadrado1 = VELOCIDADE_DO_QUADRADO;

        posXQuadrado2 = 800;
        posYQuadrado2 = 300;
        velocidadeXQuadrado2 = -VELOCIDADE_DO_QUADRADO;
        velocidadeYQuadrado2 = -VELOCIDADE_DO_QUADRADO;

        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        int largura = getWidth();
        int altura = getHeight();

        // Atualizar posição do primeiro quadrado (verde)
        posXQuadrado1 += velocidadeXQuadrado1;
        posYQuadrado1 += velocidadeYQuadrado1;

        if (posXQuadrado1 < 0) {
            posXQuadrado1 = 0;
            velocidadeXQuadrado1 = VELOCIDADE_DO_QUADRADO;
        } else if (posXQuadrado1 > largura - TAMANHO_QUADRADO) {
            posXQuadrado1 = largura - TAMANHO_QUADRADO;
            velocidadeXQuadrado1 = -VELOCIDADE_DO_QUADRADO;
        }

        if (posYQuadrado1 < 0) {
            posYQuadrado1 = 0;
            velocidadeYQuadrado1 = VELOCIDADE_DO_QUADRADO;
        } else if (posYQuadrado1 > altura - TAMANHO_QUADRADO) {
            posYQuadrado1 = altura - TAMANHO_QUADRADO;
            velocidadeYQuadrado1 = -VELOCIDADE_DO_QUADRADO;
        }

        // Atualizar posição do segundo quadrado (azul)
        posXQuadrado2 += velocidadeXQuadrado2;
        posYQuadrado2 += velocidadeYQuadrado2;

        if (posXQuadrado2 < 0) {
            posXQuadrado2 = 0;
            velocidadeXQuadrado2 = VELOCIDADE_DO_QUADRADO;
        } else if (posXQuadrado2 > largura - TAMANHO_QUADRADO) {
            posXQuadrado2 = largura - TAMANHO_QUADRADO;
            velocidadeXQuadrado2 = -VELOCIDADE_DO_QUADRADO;
        }

        if (posYQuadrado2 < 0) {
            posYQuadrado2 = 0;
            velocidadeYQuadrado2 = VELOCIDADE_DO_QUADRADO;
        } else if (posYQuadrado2 > altura - TAMANHO_QUADRADO) {
            posYQuadrado2 = altura - TAMANHO_QUADRADO;
            velocidadeYQuadrado2 = -VELOCIDADE_DO_QUADRADO;
        }

        // Detecção de colisão
        Rectangle quadrado1 = new Rectangle(posXQuadrado1, posYQuadrado1, TAMANHO_QUADRADO, TAMANHO_QUADRADO);
        Rectangle quadrado2 = new Rectangle(posXQuadrado2, posYQuadrado2, TAMANHO_QUADRADO, TAMANHO_QUADRADO);

        if (quadrado1.intersects(quadrado2)) {
            // Os quadrados colidiram, então mude as posições

            // mudança de posição para o quadrado verde
            posXQuadrado1 = largura - posXQuadrado1 - TAMANHO_QUADRADO;
            posYQuadrado1 = altura - posYQuadrado1 - TAMANHO_QUADRADO;

            // mudança de posição para o quadrado azul
            posXQuadrado2 = largura - posXQuadrado2 - TAMANHO_QUADRADO;
            posYQuadrado2 = altura - posYQuadrado2 - TAMANHO_QUADRADO;
            
        }
        
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenhar a palavra "LOVE SONGS"
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 40);
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (getWidth() - metrics.stringWidth("me passa, murilao")) / 2;
        int y = getHeight() / 2 + metrics.getHeight() / 2;
        g.setFont(font);
        g.drawString("Me passa, Murilao", x, y);
       
        // Desenhar o primeiro quadrado verde
        g.setColor(Color.CYAN);
        g.fillRect(posXQuadrado1, posYQuadrado1, TAMANHO_QUADRADO, TAMANHO_QUADRADO);

        // Desenhar o segundo quadrado azul
        g.setColor(Color.CYAN);
        g.fillRect(posXQuadrado2, posYQuadrado2, TAMANHO_QUADRADO, TAMANHO_QUADRADO);
    }
}
