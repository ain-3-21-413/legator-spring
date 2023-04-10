package kg.inai.legator.service;

import kg.inai.legator.model.auth.LoginRequest;
import kg.inai.legator.model.auth.LoginResponse;

public interface AuthService {

	LoginResponse login(LoginRequest loginRequest);
}
