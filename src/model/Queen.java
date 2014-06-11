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
