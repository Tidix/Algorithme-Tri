package visualiser;

import java.awt.Graphics;

import javax.swing.*;

import java.awt.*;

public class ArrayVisualiser extends JPanel {
    private int[] tab;
    private int costPermute;
    private int costCompare;
    public ArrayVisualiser (int[] t) {
        tab = t;
    }

    public void setTab(int[] t) {
        this.tab = t;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) { //affichage des composants
        super.paintComponent(g);
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<tab.length; i++)
            if (tab[i] > max) max = tab[i];
        Dimension dims = super.getSize();
        double pos = (dims.getWidth()/tab.length);
        for (int i=0; i<tab.length; i++) {
            int value = ((int) (tab[i]*255)/tab.length);
            
            g.setColor(new Color(value, value, 255-value));
            g.fillRect((int)(dims.getWidth()-pos), (int)(tab[i]*dims.getHeight()/max), (int)(dims.getWidth()/tab.length), (int)dims.getHeight());
            g.drawRect((int)(dims.getWidth()-pos), (int)(tab[i]*dims.getHeight()/max), (int)(dims.getWidth()/tab.length), (int)dims.getHeight());
            pos += (dims.getWidth()/tab.length);
            g.setColor(Color.BLACK);   
            g.drawString("CostPermute : "+this.costPermute,10,15); // ajout coût permutation
            g.drawString("CostCompare : "+this.costCompare, 10, 30); // ajout coût comparaison
        }
    }
    public void setCostCompare(int costCompare) { // actualisation coût comparaison
        this.costCompare = costCompare;
    }
    public void setCostPermute(int costPermute) { // actualisation coût permutation
        this.costPermute = costPermute;
    }
}
