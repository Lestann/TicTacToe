package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicWeb implements SparkApplication {
  public static void main(String[] args) {
    staticFileLocation("/public");
    SparkApplication tictactoe = new TicWeb();
    port(getHerokuPort());

    post("/newGame", (req, res) -> {
      return true;
    });
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
    //
  }
}