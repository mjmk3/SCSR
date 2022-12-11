package io.scsr.scsr.Utility;

import io.scsr.scsr.Repo.GroupRepository;
import io.scsr.scsr.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Seattle JUG", "Denver JUG", "Dublin JUG",
                "London JUG").forEach(name ->
                repository.save(new Group(name))
        );

        Group g1 = repository.findByName("Seattle JUG");
        Event e = Event.builder().title("Micro Frontends for Java Developers")
                .description("JHipster now has micro frontend support!")
                .date(Instant.parse("2022-09-13T17:00:00.000Z"))
                .build();
        g1.setEvents(Collections.singleton(e));
        repository.save(g1);

        repository.findAll().forEach(System.out::println);
    }
}
