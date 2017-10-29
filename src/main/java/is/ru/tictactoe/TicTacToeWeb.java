package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToeWeb implements SparkApplication {
  public static void main(String[] args) {
    staticFileLocation("/public");
    SparkApplication TicTacToeWeb = new TicTacToeWeb();
    port(getHerokuPort());
    TicTacToeWeb.init();
  }

  static int getHerokuPort() {
    ProcessBuilder psb = new ProcessBuilder();
    if (psb.environment().get("PORT") != null) {
      return Integer.parseInt(psb.environment().get("PORT"));
    }
    return 4567;
  }

  @Override
  public void init() {
    final TicTacToe game = new TicTacToe();
    post("/checkWinner", (req, res) -> game.checkWinner());
    post("/makeMove", (req, res) -> game.makeMove(Integer.parseInt(req.queryParams("id"))));
    post("/resetGame", (req, res) -> game.resetGame());
    post("/newRound", (req, res) -> game.newRound());

    // post("/restart", (req, res) -> game.restartGame());
  }
}
