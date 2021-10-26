package ru.otus.ageev.hw08springdatamongodb.events;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;
import ru.otus.ageev.hw08springdatamongodb.repositories.BookRepository;

@Component
@RequiredArgsConstructor
public class CascadeMongoBookEventsLisner extends AbstractMongoEventListener<Object> {
    private final BookRepository repository;

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> afterDeleteEvent) {
        super.onAfterDelete(afterDeleteEvent);

        var source = afterDeleteEvent.getSource();
        var id = source.get("_id").toString();
        if (("authors".equalsIgnoreCase(afterDeleteEvent.getCollectionName()))) {
            repository.removeAuthorElementsById(id);
        } else if (("comments".equalsIgnoreCase(afterDeleteEvent.getCollectionName()))) {
            repository.removeCommentElementsById(id);
        }
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        super.onBeforeConvert(event);
        if (("authors".equalsIgnoreCase(event.getCollectionName()))) {
            Author source = (Author) event.getSource();
            repository.setAuthorElementsById(source);
        }
    }
}
