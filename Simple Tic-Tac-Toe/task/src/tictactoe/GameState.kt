package tictactoe

/**
Stefan created on 12/9/2022
 */
enum class GameState(val description: String) {
    X_WINS("X wins"),
    O_WINS("O wins"),
    GAME_NOT_FINISHED("Game not finished"),
    IMPOSSIBLE("Impossible"),
    DRAW("Draw")
}