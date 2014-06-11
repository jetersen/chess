/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.Board;

/**
 *
 * @author Joseph
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board();
        JFrame frame = new JFrame("My chessboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(board);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationByPlatform(true);
        JFrame frame2 = new JFrame("My chessboard util window");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton newGame = new JButton("New Game");
        newGame.addActionListener((ActionEvent e) -> {
            board.create();
        });
        frame2.getContentPane().add(newGame);
        frame2.setVisible(true);
        frame.setVisible(true);
        frame2.setResizable(false);
        frame2.pack();
        frame2.setLocation(frame.getX() + 20 + frame.getWidth(), frame.getY());
    }
}
