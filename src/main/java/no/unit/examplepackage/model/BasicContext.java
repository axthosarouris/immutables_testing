package no.unit.examplepackage.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import no.unit.examplepackage.CustomStyle;


@CustomStyle
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "Book", value = BookImpl.class),
})
public interface BasicContext {

    Level level();

    boolean openAccess();

    boolean peerReviewed();
}
