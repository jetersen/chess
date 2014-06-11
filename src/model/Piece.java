/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
