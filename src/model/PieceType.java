/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joseph
 */
public enum PieceType {

    PAWN(0) {
                @Override
                Piece create(PieceColor color) {
                    return new Pawn(color, this);
                }
            }, ROOK(1) {
                @Override
                Piece create(PieceColor color) {
                    return new Rook(color, this);
                }
            }, KNIGHT(2) {
                @Override
                Piece create(PieceColor color) {
                    return new Knight(color, this);
                }
            }, BISHOP(3) {
                @Override
                Piece create(PieceColor color) {
                    return new Bishop(color, this);
                }
            }, QUEEN(4) {
                @Override
                Piece create(PieceColor color) {
                    return new Queen(color, this);
                }
            }, KING(5) {
                @Override
                Piece create(PieceColor color) {
                    return new King(color, this);
                }
            };
    private final int type;

    PieceType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String str = "";
        switch (type) {
            case 0:
                str = "Pawn";
                break;
            case 1:
                str = "Rook";
                break;
            case 2:
                str = "Knight";
                break;
            case 3:
                str = "Bishop";
                break;
            case 4:
                str = "Queen";
                break;
            case 5:
                str = "King";
                break;
        }
        return str;
    }

    public int getTypeNumber() {
        return type;
    }

    abstract Piece create(PieceColor color);
}
