import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
    LinkedList<Cutting> cuttings = new LinkedList<>();

    @Override
    public void paint(Graphics g){

        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics gr = bi.getGraphics();
        for (Cutting c:cuttings
             ) {
            g.drawImage(c.getImg(),0,0,null);
        }
        //g.drawImage(bi, 0, 0, null);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void addCutting(Cutting cutting) {
        cuttings.add(cutting);
        repaint();
    }
}
