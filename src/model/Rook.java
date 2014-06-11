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
