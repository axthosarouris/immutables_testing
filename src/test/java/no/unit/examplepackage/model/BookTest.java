package no.unit.examplepackage.model;

import static no.unit.nva.hamcrest.DoesNotHaveNullOrEmptyFields.doesNotHaveNullOrEmptyFields;
import static nva.commons.utils.JsonUtils.objectMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BookTest {

    @Test
    public void aBookImpHasAllFieldsOfParents() {
        Book book = createBook();

        assertThat(book, doesNotHaveNullOrEmptyFields());
    }

    private Book createBook() {
        return BookImpl.builder()
            .setLevel(Level.LEVEL_0)
            .setOpenAccess(false)
            .setPeerReviewed(false)
            .setSeriesTitle("SomeSeriesTitle")
            .setSeriesNumber("SomeSeriesNumber")
            .setPublisher("SomePublisher")
            .build();
    }

    @Test
    public void aBookCanBeSerialized() throws JsonProcessingException {
        Book book = createBook();
        String json = objectMapper.writeValueAsString(book);
        Book deserialized = objectMapper.readValue(json, Book.class);
        assertThat(deserialized, is(equalTo(book)));
    }

    @Test
    public void aBookWithoutTypeCannotBeDeserialized() throws JsonProcessingException {
        Book book = createBook();
        String json = objectMapper.writeValueAsString(book);
        ObjectNode tree = (ObjectNode) objectMapper.readTree(json);
        tree.remove("type");
        String invalidJson = objectMapper.writeValueAsString(tree);

        Executable action=()-> objectMapper.readValue(invalidJson, Book.class);
        assertThrows(InvalidTypeIdException.class, action);
    }
}