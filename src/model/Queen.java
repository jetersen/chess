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
class Queen extends Piece {

    Collection<Square> possibleMoves;

    public Queen(PieceColor color, PieceType type) {
        super(color, type);
        possibleMoves = new ArrayList<>();
    }

    @Override
    public Collection<Square> generatePossibleMoves() {
        possibleMoves.clear();
        Piece[] pieces = {
            PieceType.ROOK.create(getPieceColor()),
            PieceType.BISHOP.create(getPieceColor())
        };
        for (Piece piece : pieces) {
            piece.setSquare(getSquare());
            possibleMoves.addAll(piece.generatePossibleMoves());
        }
        return possibleMoves;
    }

    @Override
    public Collection<Square> getPossibleMoves() {
        return possibleMoves;
    }
}
