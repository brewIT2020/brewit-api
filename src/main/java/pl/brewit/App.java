package pl.brewit;

import account.AccountDao;
import io.javalin.Javalin;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
    }


}
