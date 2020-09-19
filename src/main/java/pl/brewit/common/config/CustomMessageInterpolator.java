package pl.brewit.common.config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.MessageInterpolator;
import java.util.Collections;
import java.util.Locale;

public class CustomMessageInterpolator implements MessageInterpolator {

  private static final Logger LOG =
      LoggerFactory.getLogger(CustomMessageInterpolator.class);
  private MessageInterpolator messageInterpolator;

  public CustomMessageInterpolator() {
    messageInterpolator =
        new ResourceBundleMessageInterpolator(
            new AggregateResourceBundleLocator(Collections.singletonList("Messages")));
  }

  @Override
  public String interpolate(String messageTemplate, Context context) {
    return null;
  }

  @Override
  public String interpolate(String messageTemplate, Context context, Locale locale) {
    return null;
  }
}
