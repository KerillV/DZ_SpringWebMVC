package my.springwebmvc;

import java.util.List;

/* Класс сервиса принимает репозиторий (MyServlet.my.springwebmvc.PostRepository) в конструкторе, обеспечивая связь между
уровнем хранения данных и уровнем бизнес-логики. */
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {

        this.repository = repository;
    }

    // Метод all() возвращает список всех постов, полученных из репозитория
    public List<Post> all() {
        return repository.all();
    }

    /* Метод getById() ищет публикацию по её уникальному идентификатору. Если публикация отсутствует,
    выбрасывается исключение MyServlet.my.springwebmvc.NotFoundException. */
    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    // Метод save() сохраняет новую публикацию, пользуясь возможностями репозитория */
    public Post save(Post post) {
        return repository.save(post);
    }

    // Метод removeById() удаляет публикацию по её идентификатору, выполняя операцию через репозиторий
    public void removeById(long id) {
        repository.removeById(id);
    }
}
