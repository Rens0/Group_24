package view;
import javax.swing.*;
import java.awt.*;

public class frame {
    public static void main(String[] args) {
        JFrame  frame = new JFrame("My Shelfie");
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // per terminere l'esecuzione quando si preme la X
        frame.setSize(800,500); //dimensione dello schermo
        frame.setLocationRelativeTo(null); //setta l'apertura della finestra nel centro dello schermo
        frame.setVisible(true); // setta visibile la finestra







    }
}
