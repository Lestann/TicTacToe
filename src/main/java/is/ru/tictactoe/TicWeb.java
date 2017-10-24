package is.ru.tictactoe;

import static spark.Spark.*;

public class TicWeb {
  public static void main(String[] args) {
    get("/", (req, res) -> {
      return "HELLO WORLD!";
    });
  }
}