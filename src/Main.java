import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;

public class Main {
    public static void main(String... args) {
        DrawPanel myPanel = new DrawPanel();
        JFrame drawFrame = new JFrame();
        JPanel funcPanel = new JPanel();
        JFrame frame = new JFrame();
        HashMap<JButton, Cutting> jButtonCuttingHashMap = new HashMap<>();
        BufferedImage img = null;
        BufferedImage img2 = null;
        try {
            URL url = new URL("https://sun1.informsvyaz.userapi.com/c858132/v858132044/12e81b/cECF0PJ_G5k.jpg");
            img = ImageIO.read(url);
            url = new URL("https://sun9-8.userapi.com/c855636/v855636270/1916a4/deWyKGKI-g8.jpg");
            img2 = ImageIO.read(url);
        } catch (IOException e) {
        }
        Cutting[] cuttings = new Cutting[]{new Cutting(img), new Cutting(img2)};
        funcPanel.setSize(300, 500);
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(funcPanel);
        frame.setVisible(true);
        frame.setTitle("Function chooser");
        funcPanel.setVisible(true);
        funcPanel.setLayout(new GridLayout(8, 1));
        boolean flag = true;
        JButton btn;
        int j = 0;
        for (int i = 0; i < 2; i++) {
            btn = new JButton();
            jButtonCuttingHashMap.put(btn, cuttings[i]);
            if (j < 6)
                j++;
            btn.setAction(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    myPanel.addCutting(jButtonCuttingHashMap.get(e.getSource()));
                }
            });
            funcPanel.add(btn);
        }
        myPanel.setSize(800, 600);
        drawFrame.setSize(800, 600);
        drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame.setContentPane(myPanel);
        drawFrame.setVisible(true);
        drawFrame.requestFocus();
        myPanel.setVisible(true);
        myPanel.grabFocus();
    }
}
