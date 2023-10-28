package com.gws.minetoursoft.service.auth;

import com.gws.minetoursoft.dto.SignupDTO;
import com.gws.minetoursoft.dto.UserDTO;
public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
