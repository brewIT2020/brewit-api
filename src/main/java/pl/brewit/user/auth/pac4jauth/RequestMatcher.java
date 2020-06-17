package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.matching.*;

import java.util.Arrays;
import java.util.Set;
/**
 * Project: brewit-api
 * <p>
 * Created on: 22.03.2020
 * <p>
 * Author : Kamil Szerląg
 */

public class RequestMatcher {

  private final PathMatcher pathMatcher;
  private final HeaderMatcher headerMatcher;
  private final HttpMethodMatcher methodMatcher;

  public RequestMatcher() {
    this.pathMatcher = new PathMatcher();
    this.headerMatcher = new HeaderMatcher();
    this.methodMatcher = new HttpMethodMatcher();

    // TODO: 17.06.2020 Should be configured in SecurityConfig
    pathMatcher.setExcludedPaths(Arrays.asList("/sign-up", "/login"));
    methodMatcher.setMethods(Set.of(HttpConstants.HTTP_METHOD.POST));
  }

  public boolean requiresAuthentication(WebContext context) {
    return context.getRequestHeader(HttpConstants.AUTHORIZATION_HEADER) != null || pathMatcher.matches(context);
  }

  public PathMatcher getPathMatcher() {
    return pathMatcher;
  }

  public HeaderMatcher getHeaderMatcher() {
    return headerMatcher;
  }

  public HttpMethodMatcher getMethodMatcher() {
    return methodMatcher;
  }
}
