package tictactoe

import tictactoe.exceptions.InvalidCoordinateException

/**
Stefan created on 12/11/2022
 */
enum class Move {

    X,
    O;

    fun nextMove(): Move {
        when (this) {
            Move.O -> return Move.X
            Move.X -> return Move.O
            else -> {
                throw InvalidCoordinateException("Move not supported: $this")
            }
        }
    }
}