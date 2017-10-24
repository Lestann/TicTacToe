package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicWeb implements SparkApplication {
  public static void main(String[] args) {
    get("/", (req, res) -> {
      return "Hello World!";
    });
  }

  @Override
  public void init() {
    //
  }
}