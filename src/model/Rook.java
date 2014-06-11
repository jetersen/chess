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

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Joseph
 */
class Rook extends Piece {

    Collection<Square> possibleMoves;

    public Rook(PieceColor color, PieceType type) {
        super(color, type);
        possibleMoves = new ArrayList<>();
    }

    @Override
    public Collection<Square> generatePossibleMoves() {
        int row = super.getSquare().ROW;
        int column = super.getSquare().COLUMN;
        possibleMoves.clear();
        //all possible moves in the up
        for (int i = row + 1; i < Board.SIZE; i++) {
            Square square = super.getSquare().getBoardSquare(i, column);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down
        for (int i = row - 1; i > -1; i--) {
            Square square = super.getSquare().getBoardSquare(i, column);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves to the right
        for (int i = column + 1; i < Board.SIZE; i++) {
            Square square = super.getSquare().getBoardSquare(row, i);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves to the left
        for (int i = column - 1; i > -1; i--) {
            Square square = super.getSquare().getBoardSquare(row, i);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        return possibleMoves;
    }

    @Override
    public Collection<Square> getPossibleMoves() {
        return possibleMoves;
    }

}
