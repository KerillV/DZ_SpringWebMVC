package my.springwebmvc;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepository {

    // posts — список публикаций, созданный на основе CopyOnWriteArrayList, делает его потокобезопасным
    private final List<Post> posts = new CopyOnWriteArrayList<>();
    private long nextId = 1; // отвечает за уникальные идентификаторы для вновь созданных постов

    // Метод all() возвращает коллекцию публикаций.
    public List<Post> all() {
        return posts;
    }

    // Метод getById() возвращает отсутствующую публикацию
    public Optional<Post> getById(long id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findAny();
    }

    /* Операция save() проверяет, если пост новый (идентификатор нулевой), и присваивает ему новый уникальный
     идентификатор, сохраняя в список. Иначе она обновляет существующий пост */
    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(nextId++);
            posts.add(post);
        } else {
            posts.removeIf(existingPost -> existingPost.getId() == post.getId());
            posts.add(post);
        }
        return post;
    }

    // removeById() — безопасный метод удаления поста по идентификатору
    public void removeById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }
}