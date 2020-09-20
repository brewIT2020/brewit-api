package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;

/**
 * Project: brewit-api
 *
 * <p>Created on: 22.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
public class SecurityContextHolder {

  private static final ThreadLocal<SecurityContext> THREAD_LOCAL = new ThreadLocal<>();

  private static WebContext context;

  public static void initialize(final CommonProfile userProfile) {
    THREAD_LOCAL.set(new SimpleSecurityContext(userProfile));
  }

  public static SecurityContext getContext() {
    return THREAD_LOCAL.get();
  }

  //  public static void setContext(WebContext webContext) {
  //    THREAD_LOCAL.set(webContext);
  //  }

  public static void destroy() {
    THREAD_LOCAL.set(null);
  }
}
