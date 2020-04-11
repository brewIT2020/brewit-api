package pl.brewit.user;

import io.javalin.core.security.Role;

/**
 * Project: brewit-api
 *
 * Created on: 22.03.2020
 *
 * Author    : Kamil Szerląg
 */
public enum UserRole implements Role {
   UNKNOWN, USER, ADMIN
}
