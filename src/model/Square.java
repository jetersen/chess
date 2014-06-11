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
package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class Square extends JButton {

    public final int ROW;
    public final int COLUMN;
    private Piece piece;
    private final Board board;
    private boolean selected;

    public Square(int row, int column, Board board) {
        this.board = board;
        ROW = row;
        COLUMN = column;
        selected = false;
        setFocusPainted(false);
        setBackground(getColor());
        setPreferredSize(new Dimension(80, 80));
        addActionListener((ActionEvent e) -> {
            select();
        });
    }

    public Color getColor() {
        return (ROW + COLUMN) % 2 == 0 ? Color.BLACK : Color.WHITE;
    }

    private void select() {
        if (piece != null) {
            if ((board.getTurn() && !piece.isWhite()) || (!board.getTurn() && piece.isWhite()) && !selected) {
                if (piece.getTypeNumber() == 5 || !board.kingInCheck()) {
                    if (board.getSelected() != null && !board.getSelected().isEmpty()) {
                        board.getSelected().getPiece().getPossibleMoves().stream().forEach((_item) -> {
                            _item.deselect();
                        });
                    }
                    board.deselect();
                    board.setSelected(this);
                    selected = true;
                    setBackground(Color.YELLOW);
                    piece.printPossibleMoves();
                } else {
                    if (board.getReminder() > 1) {
                        JOptionPane.showMessageDialog(this, "King in check");
                        board.resetReminder();
                    }
                }
            } else if ((board.getTurn() && piece.isWhite()) || (!board.getTurn() && !piece.isWhite())) {
                if (board.getSelected() != null && !board.getSelected().isEmpty()) {
                    if (board.getSelected().getPiece().getPossibleMoves().contains(this)) {
                        //Capture move
                        Square from = board.getSelected();
                        Square to = this;
                        if (from.getPiece() != null) {
                            from.getPiece().getPossibleMoves().stream().forEach((square) -> {
                                square.deselect();
                            });
                        }
                        board.move(from, to);
                        from.deselect();
                        to.deselect();
                    }
                }
            }
        } else {
            if (board.getSelected() != null && !board.getSelected().isEmpty()) {
                if (board.getSelected().getPiece().getPossibleMoves().contains(this)) {
                    //Natural move
                    Square from = board.getSelected();
                    Square to = this;
                    from.getPiece().getPossibleMoves().stream().forEach((square) -> {
                        square.deselect();
                    });
                    board.move(from, to);
                    board.deselect();
                    board.setSelected(null);
                }
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Square neighbour(int row, int column) {
        return board.getSquare(ROW + row, COLUMN + column);
    }

    public Square getBoardSquare(int row, int column) {
        return board.getSquare(row, column);
    }

    public void deselect() {
        setBackground(getColor());
        selected = false;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        setIcon(this.piece.getIcon());
    }

    public void movePiece(Piece piece) {
        this.piece = piece;
        this.piece.setMoved();
        setIcon(this.piece.getIcon());
        this.piece.setSquare(this);
        this.piece.generatePossibleMoves();
    }

    public void removePiece() {
        piece = null;
        setIcon(null);
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return "Row: " + Board.printRow(ROW) + " Column: " + Board.printColumn(COLUMN) + " - (" + ROW + "," + COLUMN + ")";
    }
}
