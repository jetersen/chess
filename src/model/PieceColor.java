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
