/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Joseph
 */
public enum PieceColor {

    BLACK(Color.BLACK), WHITE(Color.WHITE);

    private final Color color;

    PieceColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return name().charAt(0) != (char) 66;
    }

    @Override
    public String toString() {
        return name().charAt(0) == (char) 66 ? "Black" : "White";
    }
}
