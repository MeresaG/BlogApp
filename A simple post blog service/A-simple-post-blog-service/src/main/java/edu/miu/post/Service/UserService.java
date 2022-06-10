package edu.miu.post.Service;

import edu.miu.post.Domain.User;

import java.util.List;

public interface UserService {
    public User save(User user);

    public List<User> getAll();

    public User get(Long id);

    public User update(User user);

    public void delete(Long id);
}
