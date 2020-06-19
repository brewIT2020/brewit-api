package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.authorization.authorizer.Authorizer;
import org.pac4j.core.authorization.authorizer.RequireAnyRoleAuthorizer;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.CommonProfile;
import pl.brewit.user.AuthorizationRole;

import java.util.List;
/**
 * Project: brewit-api
 * <p>
 * Created on: 22.03.2020
 * <p>
 * Author : Kamil Szerląg
 */

public class JWTAuthorizer implements Authorizer<CommonProfile> {

  @Override
  public boolean isAuthorized(WebContext context, List<CommonProfile> profiles) {
    return RequireAnyRoleAuthorizer.requireAnyRole(AuthorizationRole.USER.toString())
        .isAnyAuthorized(context, profiles);
//    IsAuthenticatedAuthorizer.isAuthenticated();
  }
}
