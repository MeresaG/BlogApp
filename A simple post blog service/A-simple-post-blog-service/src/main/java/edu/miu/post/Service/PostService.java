package edu.miu.post.Service;

import edu.miu.post.Domain.Post;

import java.util.List;


public interface PostService {
    public Post save(Post post);

    public List<Post> getAll();

    public Post get(Long id);

    public Post update(Post post);

    public void delete(Long id);
}
