package edu.miu.post.Service;

import edu.miu.post.DTO.LoginRequest;
import edu.miu.post.DTO.LoginResponse;
import edu.miu.post.DTO.RefreshTokenRequest;
import edu.miu.post.Domain.User;

import java.util.List;

public interface UserService {
    public User save(User user);

    public List<User> getAll();

    public User get(Long id);

    public User update(User user);

    public void delete(Long id);
    public LoginResponse login(LoginRequest loginRequest);
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
