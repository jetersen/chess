/* 
 * Copyright (C) 2014 Joseph
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
