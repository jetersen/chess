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
class Pawn extends Piece {

    Collection<Square> possibleMoves;

    public Pawn(PieceColor color, PieceType type) {
        super(color, type);
        possibleMoves = new ArrayList<>();
    }

    @Override
    public Collection<Square> generatePossibleMoves() {
        possibleMoves.clear();
        boolean color = super.isWhite();
        int dx = color ? -1 : 1;

        Square ahead = super.getSquare().neighbour(dx, 0);
        if (ahead.getPiece() == null) {
            possibleMoves.add(ahead);
            if (super.getSquare().ROW == 6 && color) {
                Square aheadsecond = super.getSquare().neighbour(dx - 1, 0);
                if (aheadsecond.getPiece() == null) {
                    possibleMoves.add(aheadsecond);
                }
            } else if (super.getSquare().ROW == 1 && !color) {
                Square aheadsecond = super.getSquare().neighbour(dx + 1, 0);
                if (aheadsecond.getPiece() == null) {
                    possibleMoves.add(aheadsecond);
                }
            }
        }
        Square aheadLeft = super.getSquare().neighbour(dx, -1);
        if (aheadLeft != null && aheadLeft.getPiece() != null && isOpponent(aheadLeft.getPiece())) {
            possibleMoves.add(aheadLeft);
        }
        Square aheadRight = super.getSquare().neighbour(dx, 1);
        if (aheadRight != null && aheadRight.getPiece() != null && isOpponent(aheadRight.getPiece())) {
            possibleMoves.add(aheadRight);
        }
        return possibleMoves;
    }

    @Override
    public Collection<Square> getPossibleMoves() {
        return possibleMoves;
    }

}
