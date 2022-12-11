package tictactoe

import tictactoe.exceptions.InvalidCoordinateException

/**
Stefan created on 12/9/2022
 */
class TicTacToeGame {

    var input: String = "_".repeat(9)
    val ticTacToeGrid: TicTacToeGrid = TicTacToeGrid(input)
    var move: Move = Move.X

    fun play(ticTacToeCoordinate: TicTacToeCoordinate): GameState {
        try {
            ticTacToeGrid.putCharacter(move, ticTacToeCoordinate)
            move = move.nextMove()
            return calculateGameState()
        } catch(e:InvalidCoordinateException) {
            throw e
        }
    }

    fun printTable() {
        ticTacToeGrid.printTicTacToeGrid()
    }

    private fun calculateGameState(): GameState {
        val conditionsToWin = arrayOf(
            arrayOf(0, 1, 2),
            arrayOf(3, 4, 5),
            arrayOf(6, 7, 8),
            arrayOf(0, 4, 8),
            arrayOf(2, 4, 6),
            arrayOf(0, 3, 6),
            arrayOf(1, 4, 7),
            arrayOf(2, 5, 8)
        )

        val countX = ticTacToeGrid.input.count({ it == 'X'})
        val countO = ticTacToeGrid.input.count({ it == 'O'})

        if (Math.abs(countX - countO) > 1) {
            return GameState.IMPOSSIBLE
        }

        var xWins = 0
        var oWins = 0
        conditionsToWin.forEach {
            val winner = checkForWinner(ticTacToeGrid.input, it)
            if (winner == 1) {
                xWins += 1
            }
            if (winner == -1) {
                oWins += 1
            }
        }
        if (xWins > 0 && oWins > 0) {
            return GameState.IMPOSSIBLE
        }
        if (xWins > 0) {
            return GameState.X_WINS
        } else if (oWins > 0) {
            return GameState.O_WINS
        }

        if (ticTacToeGrid.input.contains("_")) {
            return GameState.GAME_NOT_FINISHED
        }
        return GameState.DRAW
    }

    fun checkForWinner(input:String, indices:Array<Int>): Int {
        if (input[indices[0]] != 'X' && input[indices[0]] != 'O') {
            return 0
        }
        val somebodyWon = input[indices[0]] == input[indices[1]] &&
                input[indices[1]] == input[indices[2]]
        if (!somebodyWon) {
            return 0
        }
        if (input[indices[0]] == 'X') {
            return 1
        }
        return -1;
    }
}