package pl.brewit.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;
import io.javalin.http.Handler;

import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * Project: brewit-api
 *
 * <p>Created on: 24.03.2020
 *
 * <p>Author : Kamil Szerląg
 */
@Singleton
public class UserController {

  private Javalin javalin;

  private UserFacade userFacade;

  @Inject
  public UserController(Javalin javalin, UserFacade userFacade) {
    this.javalin = javalin;
    this.userFacade = userFacade;
  }

  public EndpointGroup endpoints() {
    return () -> {
      post(register);
      get(getAllUsers);
      path(
              ":id",
              () -> {
                get(getUser);
                patch(getAllUsers);
                path("email",
                        () -> {
                          patch(updateEmail);
                        });
//                        patch(this::updatePassword);
              });
    };
  }

  private Handler register =
          ctx -> {
            UserDto userDto = ctx.bodyAsClass(UserDto.class);
            userFacade.register(userDto);
            ctx.status(201);
          };

  private Handler getUser =
          ctx -> {
            String userId = ctx.pathParam("id");
            UserDto user = userFacade.getUser(userId);
            ctx.json(user);
          };

  private Handler getAllUsers =
          ctx -> {
            List<UserDto> users = userFacade.getAllUsers();
            ctx.json(users);
          };

  private Handler updateEmail = ctx -> {
    UserDto userDto = ctx.bodyAsClass(UserDto.class);
    userFacade.updateEmail(userDto);
    ctx.status(200);
  };

//  private Handler updatePassword(Context ctx) {}
}