package com.ecommerce.project.dto;

import com.ecommerce.project.enus.UserRole;

public record UserDTO (String login, String password, UserRole role ){

}
