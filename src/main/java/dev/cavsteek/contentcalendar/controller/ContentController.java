package dev.cavsteek.contentcalendar.controller;

import dev.cavsteek.contentcalendar.model.Content;
import dev.cavsteek.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

     public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
         return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    public void create(@RequestBody Content content){
         repository.save(content);
    }

}
