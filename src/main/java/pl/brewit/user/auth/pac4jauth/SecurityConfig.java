package pl.brewit.user.auth.pac4jauth;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.pac4j.core.authorization.generator.AuthorizationGenerator;
import org.pac4j.core.authorization.generator.DefaultRolesPermissionsAuthorizationGenerator;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import org.pac4j.jwt.profile.JwtGenerator;
import pl.brewit.common.utils.AppProperties;
import pl.brewit.user.AuthorizationRole;

import java.util.Date;

// TODO: 4/24/20 Refactoring to SecurityConfigFactory

@Singleton
public class SecurityConfig {

  private static final String[] DEFAULT_ROLES = {AuthorizationRole.BASIC.toString()};
  private static final String JWT_SECRET_KEY = "security.jwt.secret";

  private JwtGenerator<CommonProfile> jwtGenerator;
  private AuthorizationGenerator<CommonProfile> authorizationGenerator;

  private JwtAuthenticator jwtAuthenticator;

  private AppProperties properties;

  @Inject
  public SecurityConfig(AppProperties properties) {
    this.jwtGenerator = new JwtGenerator<>();
    this.authorizationGenerator =
        new DefaultRolesPermissionsAuthorizationGenerator<>(
            DEFAULT_ROLES, ArrayUtils.EMPTY_STRING_ARRAY);
    this.jwtAuthenticator = new JwtAuthenticator();
    this.properties = properties;
  }

  public void configure() {
    SecretSignatureConfiguration signatureConfiguration = new SecretSignatureConfiguration();
    signatureConfiguration.setSecret(properties.getValue(JWT_SECRET_KEY));
    jwtGenerator.setSignatureConfiguration(signatureConfiguration);
    jwtGenerator.setExpirationTime(DateUtils.addMonths(new Date(), 1));

    jwtAuthenticator.setSignatureConfiguration(signatureConfiguration);
  }

  public JwtGenerator<CommonProfile> getJwtGenerator() {
    return jwtGenerator;
  }

  public AuthorizationGenerator<CommonProfile> getAuthorizationGenerator() {
    return authorizationGenerator;
  }

  public JwtAuthenticator getJwtAuthenticator() {
    return jwtAuthenticator;
  }
}
