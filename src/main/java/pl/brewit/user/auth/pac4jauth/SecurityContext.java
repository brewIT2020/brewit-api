package pl.brewit.user.auth.pac4jauth;


import org.pac4j.core.profile.CommonProfile;

public interface SecurityContext {

  CommonProfile getUserProfile();

}
