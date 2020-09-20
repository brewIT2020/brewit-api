package pl.brewit.common.config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.MessageInterpolator;
import java.util.Locale;

public class CustomMessageInterpolator extends ResourceBundleMessageInterpolator
    implements MessageInterpolator {

  private static final Logger LOG = LoggerFactory.getLogger(CustomMessageInterpolator.class);

  public CustomMessageInterpolator() {
    super(new PlatformResourceBundleLocator("Messages"));
    LOG.info(
        "[ CUSTOM ] MessageInterpolator configured" + CustomMessageInterpolator.class.getName());
  }

  @Override
  public String interpolate(String messageTemplate, Context context) {
    return super.interpolate(messageTemplate, context);
  }

  @Override
  public String interpolate(String messageTemplate, Context context, Locale locale) {
    return super.interpolate(messageTemplate, context, locale);
  }
}
