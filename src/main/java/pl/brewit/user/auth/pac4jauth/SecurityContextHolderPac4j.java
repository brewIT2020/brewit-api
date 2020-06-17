package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.context.WebContext;
/**
 * Project: brewit-api
 * <p>
 * Created on: 22.03.2020
 * <p>
 * Author : Kamil Szerląg
 */

public class SecurityContextHolderPac4j {

  private static final ThreadLocal<WebContext> THREAD_LOCAL = new ThreadLocal<>();

  private static WebContext context;

  public static WebContext getContext() {
    return THREAD_LOCAL.get();
  }

  public static void setContext(WebContext webContext) {
    THREAD_LOCAL.set(webContext);
  }
}
