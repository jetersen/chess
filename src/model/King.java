/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Joseph
 */
class King extends Piece {

    Collection<Square> possibleMoves;

    public King(PieceColor color, PieceType type) {
        super(color, type);
        possibleMoves = new ArrayList<>();
    }

    @Override
    public Collection<Square> generatePossibleMoves() {
        possibleMoves.clear();
        List<Square> moves = new ArrayList<>();
        int[][] offsets = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
            {1, 1},
            {-1, 1},
            {-1, -1},
            {1, -1}
        };
        for (int[] o : offsets) {
            Square square = super.getSquare().neighbour(o[0], o[1]);
            if (square != null && (square.getPiece() == null || isOpponent(square.getPiece()))) {
                moves.add(square);
            }
        }
        possibleMoves.addAll(moves);
        if (getSquare().isSelected()) {
            Piece[] pieces = {
                PieceType.PAWN.create(getPieceColor()),
                PieceType.ROOK.create(getPieceColor()),
                PieceType.BISHOP.create(getPieceColor()),
                PieceType.KNIGHT.create(getPieceColor()),
                PieceType.QUEEN.create(getPieceColor()),
                PieceType.KING.create(getPieceColor())};
            Piece oldKing = this;
            getSquare().removePiece();
            moves.stream().forEach((kingMove) -> {
                if (kingMove.isEmpty()) {
                    for (Piece piece : pieces) {
                        piece.putPieceOnSquareFirstTime(kingMove);
                        piece.generatePossibleMoves();
                        piece.getPossibleMoves().stream().filter((enemy) ->
                                (possibleMoves.contains(kingMove) && !enemy.isEmpty() 
                                        && enemy.getPiece().isOpponent(piece) 
                                        && enemy.getPiece().getTypeNumber() == piece.getTypeNumber())).forEach((_item) -> {
                            possibleMoves.remove(kingMove);
                        });
                    }
                    kingMove.removePiece();
                } else if (isOpponent(kingMove.getPiece())) {
                    Piece oldPiece = kingMove.getPiece();
                    for (Piece piece : pieces) {
                        kingMove.removePiece();
                        piece.putPieceOnSquareFirstTime(kingMove);
                        piece.generatePossibleMoves();
                        piece.getPossibleMoves().stream().filter((enemy) ->
                                (possibleMoves.contains(kingMove) && !enemy.isEmpty() 
                                        && enemy.getPiece().isOpponent(piece) 
                                        && enemy.getPiece().getTypeNumber() == piece.getTypeNumber())).forEach((_item) -> {
                            possibleMoves.remove(kingMove);
                        });
                    }
                    kingMove.removePiece();
                    oldPiece.putPieceOnSquareFirstTime(kingMove);
                }
            });
            oldKing.putPieceOnSquareFirstTime(getSquare());
        }
        return possibleMoves;
    }

    @Override
    public Collection<Square> getPossibleMoves() {
        return possibleMoves;
    }

}
