package dvd;
import javax.swing.JFrame;

public class DVDMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("100 CLIPES LOVE SONGS ROCK AND ROLL ANOS 90");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PainelQuadradosSaltitantes panel = new PainelQuadradosSaltitantes();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
