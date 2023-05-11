package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame {


    public static void main(String[] args) {
        JFrame  frame = new JFrame("My Shelfie");

        JTextArea jTextArea = new JTextArea();
        JButton jButtonProsegui= new JButton("Prosegui");
        frame.add(jButtonProsegui, BorderLayout.SOUTH);
        
        jButtonProsegui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //qui vanno inserite le azioni che il pulsante svolge quando viene premuto

            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // per terminere l'esecuzione quando si preme la X
        frame.setSize(800,500); //dimensione dello schermo
        frame.setLocationRelativeTo(null); //setta l'apertura della finestra nel centro dello schermo
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);;
        frame.setVisible(true); // setta visibile la finestra







    }
}
