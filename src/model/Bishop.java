/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Joseph
 */
class Bishop extends Piece {

    Collection<Square> possibleMoves;

    public Bishop(PieceColor color, PieceType type) {
        super(color, type);
        possibleMoves = new ArrayList<>();
    }

    @Override
    public Collection<Square> generatePossibleMoves() {
        int row = super.getSquare().ROW;
        int column = super.getSquare().COLUMN;
        possibleMoves.clear();
        //all possible moves in the down positive diagonal
        for (int j = column + 1, i = row + 1; j < Board.SIZE && i < Board.SIZE; j++, i++) {
            Square square = super.getSquare().getBoardSquare(i, j);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the up positive diagonal
        for (int j = column - 1, i = row + 1; j > -0 && i < Board.SIZE; j--, i++) {
            Square square = super.getSquare().getBoardSquare(i, j);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the up negative diagonal
        for (int j = column - 1, i = row - 1; j >= 0 && i > -0; j--, i--) {
            Square square = super.getSquare().getBoardSquare(i, j);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down negative diagonal
        for (int j = column + 1, i = row - 1; j < Board.SIZE && i > -0; j++, i--) {
            Square square = super.getSquare().getBoardSquare(i, j);
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
