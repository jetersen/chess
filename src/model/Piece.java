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
import java.util.Collection;
import javax.swing.ImageIcon;

/**
 *
 * @author Joseph
 */
public abstract class Piece {

    private final PieceType pieceType;
    private final PieceColor pieceColor;
    private Square square;
    private boolean moved;

    public Piece(PieceColor color, PieceType type) {
        pieceColor = color;
        pieceType = type;
        moved = false;
    }
    
    public PieceColor getPieceColor() {
        return pieceColor;
    }
    
    public void setMoved() {
        moved = true;
    }

    public boolean hasMoved() {
        return moved;
    }

    public int getTypeNumber() {
        return pieceType.getTypeNumber();
    }

    public String getColorString() {
        return pieceColor.toString();
    }

    public String getType() {
        return pieceType.toString();
    }

    public java.awt.Color getColor() {
        return pieceColor.getColor();
    }

    public Square getSquare() {
        return square;
    }

    public boolean isWhite() {
        return pieceColor.isWhite();
    }
    
    public Piece getOpponentKing() {
        return getSquare().getBoard().getOpponentKing(this);
    }

    public boolean isOpponent(Piece piece) {
        return piece != null && isWhite() != piece.isWhite();
    }

    public boolean legalMove(Square to) {
        return to.getPiece() == null || isOpponent(to.getPiece());
    }

    public abstract Collection<Square> getPossibleMoves();

    public abstract Collection<Square> generatePossibleMoves();

    public ImageIcon getIcon() {
        String path = "/resources/" + getColorString() + " " + getType().substring(0, 1) + ".png";
        return new ImageIcon(getClass().getResource(path));

    }

    public void putPieceOnSquareFirstTime(Square square) {
        this.square = square;
        this.square.setPiece(this);
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return pieceColor.toString().substring(0, 1) + " " + pieceType.toString().substring(0, 1);
    }

    public boolean isKing() {
        return this instanceof King;
    }

    public void printPossibleMoves() {
        generatePossibleMoves();
        getPossibleMoves().stream().forEach((_item) -> {
            if (isOpponent(_item.getPiece())) {
                _item.setBackground(Color.RED);
            } else {
                _item.setBackground(Color.GREEN);
            }
        });
    }

}
