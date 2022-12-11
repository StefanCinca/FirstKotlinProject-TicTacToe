package tictactoe

import tictactoe.exceptions.InvalidCoordinateException
import java.lang.IllegalArgumentException
import java.util.*

fun main() {
    val ticTacToeGame = TicTacToeGame()

    ticTacToeGame.printTable()
    while (true) {
        val coordinate: TicTacToeCoordinate
        try {
            coordinate = readInputs()
        } catch (e: InvalidCoordinateException) {
            println(e.message)
            continue
        }

        try {
            val gameState = ticTacToeGame.play(coordinate)
            ticTacToeGame.printTable()
            if (gameState != GameState.GAME_NOT_FINISHED) {
                println(gameState.description)
                return
            }
        } catch (e: InvalidCoordinateException) {
            println(e.message)
            continue
        }
    }
}

private fun readInputs(): TicTacToeCoordinate {
    try {
        val scanner = Scanner(System.`in`)
        val x = scanner.nextInt()
        val y = scanner.nextInt()
        return TicTacToeCoordinate.of(x, y)
    } catch (e: InputMismatchException) {
        throw InvalidCoordinateException("You should enter numbers!")
    } catch (e: IllegalArgumentException) {
        throw InvalidCoordinateException("Coordinates should be from 1 to 3!")
    }
}

