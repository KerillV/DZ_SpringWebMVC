package my.springwebmvc;/* Модель публикации включает поля id и content, представляющие уникальный идентификатор и содержание
публикации соответственно */

public class Post {
    private long id; // идентификатор
    private String content; // содержание публикации

    public Post() {
    }

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}