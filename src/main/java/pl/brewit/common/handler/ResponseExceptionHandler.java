package pl.brewit.common.handler;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import org.pac4j.core.context.HttpConstants;

import javax.validation.ConstraintViolationException;
import java.net.http.HttpClient;

public class ResponseExceptionHandler {

  public void handleException(ConstraintViolationException ex, Context context)  {
    context.status(HttpConstants.BAD_REQUEST);
    context.result(ex.getMessage());
  }

}
