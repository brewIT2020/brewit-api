package pl.brewit.user;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;
import io.javalin.http.Context;
import io.javalin.plugin.json.JavalinJson;

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

    private UserFacade userFacade;

    @Inject
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public EndpointGroup endpoints() {
        return () -> {
            post(this::signUp);
            get(this::getAllUsers);
            path(":id", () -> {
                get(this::getUser);
                put(this::updateUser);
            });
        };
    }

    //This method is public because we are mapping request under /sign-up
    public void signUp(Context context) {
        UserDto userDto = JavalinJson.fromJson(context.body(), UserDto.class);
        userFacade.register(userDto);
        context.status(201);
    }

    private void getAllUsers(Context context) {
        List<UserDto> users = userFacade.getAllUsers();
        context.json(users);
    }

    private void getUser(Context context) {
        String userId = context.pathParam("id");
        UserDto user = userFacade.getUser(userId);
        context.json(user);
    }

    private void updateUser(Context context) {
        String userId = context.pathParam("id");
        UserDto userDto = JavalinJson.fromJson(context.body(), UserDto.class);
        userFacade.updateUser(userId, userDto);
    }
}
