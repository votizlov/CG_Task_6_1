import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class Cutting {
    private BufferedImage img;
    private int left;
    private int right;
    private int top;
    private int bottom;
    private int minX;

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    private int minY;
    private int maxX;
    private int maxY;

    public Cutting(BufferedImage img) {
        minX = img.getWidth();
        minY = img.getHeight();
        maxX = 0;
        maxY = 0;
        int back = img.getRGB(1,1);
        System.out.println(back);
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                if (!(abs(img.getRGB(j,i)-back)<10)){
                    if(i>maxY)
                        maxY=i;
                    else
                    if(i<minY)
                        minY=i;
                    else
                    if(j>maxX)
                        maxX=j;
                    else
                    if(j<minX)
                        minX=j;
                }
            }
        }
        System.out.println(maxX+" "+maxY+" "+minX+" "+minY);
        BufferedImage bi = new BufferedImage(maxX-minX,maxY-minY,BufferedImage.TYPE_INT_RGB);
        //bi.setData(img.getData(new Rectangle(minX,minY,maxX-minX,maxY-minY)));

        bi.setData(img.getData(new Rectangle(minX,minY,maxX-minX,maxY-minY)));
        this.img = bi;
    }

    public BufferedImage getImg() {
        return img;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }
}
