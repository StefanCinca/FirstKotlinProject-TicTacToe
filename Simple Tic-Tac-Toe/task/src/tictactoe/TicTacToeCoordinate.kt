package tictactoe

/**
Stefan created on 12/7/2022
 */
data class TicTacToeCoordinate (val x: Int, val y: Int) {

    companion object {
        fun of(x: Int, y: Int): TicTacToeCoordinate {
            require(isInsideGrid(x, y)) { "Coordinates should be from 1 to 3!" }
            return TicTacToeCoordinate(x, y)
        }

        private fun isInsideGrid(x: Int, y: Int): Boolean = x in 1..3 && y in 1..3
    }
}