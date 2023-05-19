package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame {


    public static void main(String[] args) {
        JFrame frame = new JFrame("My Shelfie");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;  //prende la dimensione dello schermo
        int height = Toolkit.getDefaultToolkit().getScreenSize().height; //prende la dimensione dello schermo

        JTextArea jTextArea = new JTextArea();
        JButton jButtonProsegui = new JButton("START A NEW GAME");
        frame.add(jButtonProsegui, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // per terminere l'esecuzione quando si preme la X
        frame.setSize(width, height); //dimensione dello schermo
        frame.setLocationRelativeTo(null); //setta l'apertura della finestra nel centro dello schermo
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        ;
        frame.setVisible(true); // setta visibile la finestra
        jButtonProsegui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame newFrame = new JFrame("Nuova Finestra");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Impostazione delle dimensioni della nuova finestra
                newFrame.setSize(300, 200);

                // Visualizzazione della nuova finestra
                newFrame.setVisible(true);
                frame.setVisible(false);

            }
        });


    }
}
