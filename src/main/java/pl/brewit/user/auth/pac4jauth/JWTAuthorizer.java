package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.authorization.authorizer.Authorizer;
import org.pac4j.core.authorization.authorizer.IsAuthenticatedAuthorizer;
import org.pac4j.core.authorization.authorizer.RequireAnyRoleAuthorizer;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import pl.brewit.user.AuthorizationRole;

import java.util.List;

public class JWTAuthorizer implements Authorizer<CommonProfile> {

  @Override
  public boolean isAuthorized(WebContext context, List<CommonProfile> profiles) {
    return RequireAnyRoleAuthorizer.requireAnyRole(AuthorizationRole.BASIC.toString())
        .isAnyAuthorized(context, profiles);
//    IsAuthenticatedAuthorizer.isAuthenticated();
  }
}
