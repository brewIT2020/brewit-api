package pl.brewit.user.auth.pac4jauth;

import org.pac4j.core.profile.CommonProfile;

public class SimpleSecurityContext implements SecurityContext{

  private final CommonProfile userProfile;

  public SimpleSecurityContext(final CommonProfile userProfile) {
    this.userProfile = userProfile;
  }

  @Override
  public CommonProfile getUserProfile() {
    return userProfile;
  }
}
