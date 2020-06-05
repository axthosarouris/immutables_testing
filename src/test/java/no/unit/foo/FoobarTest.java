package no.unit.foo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FoobarTest {

    @DisplayName("setField should set the field value")
    @Test
    void setFieldSetsTheFieldValue() {
        String insertedValue = "SomeValue";
        Foobar foo = new Foobar();
        foo.setField(insertedValue);
        String actualValue = foo.getField();
        assertThat(actualValue, is(equalTo(insertedValue)));
    }

    @DisplayName("getField returns null when value has not been set")
    @Test
    void getFieldSReturnsNullWhenValueHasNotBeenSet() {
        Foobar foo = new Foobar();
        String actualValue = foo.getField();
        assertThat(actualValue, is(nullValue()));
    }

    @DisplayName("getField returns the set value when the value has been set")
    @Test
    void getFieldReturnsTheSetValueWhenTheValueHasBeenSet() {
        String insertedValue = "SomeValue";
        Foobar foo = new Foobar();
        foo.setField(insertedValue);
        String actualValue = foo.getField();
        assertThat(actualValue, is(equalTo(insertedValue)));
    }
}