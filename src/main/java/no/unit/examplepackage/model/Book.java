package no.unit.examplepackage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import no.unit.examplepackage.CustomStyle;
import org.immutables.value.Value;


//Necesary for the Immutables generations
@Value.Immutable
//check the interface CustomStyle
@CustomStyle
@JsonSerialize(as = BookImpl.class)
@JsonDeserialize(as = BookImpl.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public abstract class Book implements BasicContext {

    public abstract String seriesTitle();

    public abstract String seriesNumber();

    public abstract String publisher();

    public abstract List<String> isbnList();

    @JsonIgnore
    @Value.Default
    public String jsonIgnored(){
        return "not in JSON";
    };
}
