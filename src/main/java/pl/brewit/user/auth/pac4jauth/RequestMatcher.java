package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.matching.*;

public class RequestMatcher {

    private final PathMatcher pathMatcher;
    private final HeaderMatcher headerMatcher;
    private final HttpMethodMatcher methodMatcher;

    public RequestMatcher() {
        this.pathMatcher = new PathMatcher();
        this.headerMatcher = new HeaderMatcher();
        this.methodMatcher = new HttpMethodMatcher();
    }

    public boolean requiresAuthentication(WebContext context) {
        if (!pathMatcher.matches(context)) {
            return true;
        }
        if (pathMatcher.matches(context)) {
            return !headerMatcher.matches(context);
        }
        return false;
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
