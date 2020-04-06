package pl.brewit.common.server;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

/**
 * Project: brewit-api
 *
 * <p>Created on: 24.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public final class JavalinWebServer {

  public void run() {

  }

  public void start() {
    Javalin app = Javalin.create().start(7000);
    app.get("/", ctx -> ctx.result("Hello World"));

    app.before("/", ctx -> {
      ctx.
    });

    app.config.server(() -> {

    })
  }

}
