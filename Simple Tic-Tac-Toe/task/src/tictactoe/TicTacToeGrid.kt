package tictactoe

import tictactoe.exceptions.InvalidCoordinateException

/**
Stefan created on 12/6/2022
 */
class TicTacToeGrid constructor(var input: String){


    fun putCharacter(move: Move, position: TicTacToeCoordinate) {
        val char = move.name
        val (x, y) = position
        val indexInRawString = (x - 1) * 3 + (y -1) % 3
        val sb: StringBuilder = StringBuilder(input)
        if (sb[indexInRawString] != '_') {
            throw InvalidCoordinateException("This cell is occupied! Choose another one!")
        }
        sb[indexInRawString] = char[0]
        input = sb.toString()
    }

    fun printTicTacToeGrid() {
        printBorderLine()
        val lines:Array<CharArray> = getLinesFromRawInput()
        lines.forEach {
            println(it.joinToString(prefix = "| ", postfix = " |", separator = " "))
        }
        printBorderLine()
    }

    private fun getLinesFromRawInput(): Array<CharArray> {
        val line1 = input.substring(0, 3).toCharArray()
        val line2 = input.substring(3, 6).toCharArray()
        val line3 = input.substring(6, 9).toCharArray()
        return arrayOf(line1, line2, line3)
    }

    private fun printBorderLine() = println("-".repeat(9))
}