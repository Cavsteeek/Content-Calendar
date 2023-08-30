package dev.cavsteek.contentcalendar.repository;

import dev.cavsteek.contentcalendar.model.Content;
import dev.cavsteek.contentcalendar.model.Status;
import dev.cavsteek.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){}

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content content = new Content(
                 1,
                 "My First Blog Post",
                "my first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(content);
    }


    public void save(Content content) {
        contentList.add(content);
    }
}
