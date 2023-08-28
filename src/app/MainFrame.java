package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private JButton[] grid;
    private JButton again;
    private JLabel mainl, scorel;
    private JPanel p, p1;
    private String str;
    private int i;
    private int clickCount=0, times=0; // Array to keep track of click counts

    public MainFrame() {
        super("Tic Tac Toe");
        scorel = new JLabel("Player is first", SwingConstants.CENTER);
        mainl = new JLabel("Let's play TicTacToe", SwingConstants.CENTER);
        
        again = new JButton("Play Again");
        again.setEnabled(false);
        again.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new MainFrame().setVisible(true);
            }
       });
        
        p = new JPanel(new GridLayout(3, 3));

        grid = new JButton[9];

        for (i = 0; i < 9; i++) {
            grid[i] = new JButton("");
            grid[i].setPreferredSize(new Dimension(100, 100));
            grid[i].setFont(new Font("Arial", Font.PLAIN, 40));
            p.add(grid[i]);

            grid[i].addActionListener(new ActionListener() {
                private int buttonIndex = i;

                @Override
                public void actionPerformed(ActionEvent e) {
                    times++;
                    if (clickCount == 0) {
                    	
                    	clickCount = 1;
                        str = "X"; // Change the text to "X"
                        scorel.setText("It is the computer's turn");
                    } else if(clickCount == 1){
                    	
                    	clickCount = 0;
                        str = "O"; // Clear the text
                        scorel.setText("It is the player's turn");
                    }
                    grid[buttonIndex].setText(str);
                    grid[buttonIndex].setEnabled(false);
                    new FindWinner(grid, scorel, times, again);
                   
                }
            });
            
            
            
            
            p1 = new JPanel(new GridLayout(1,2));
            p1.add(scorel);
            p1.add(again);
            
        }

        add(mainl, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}
