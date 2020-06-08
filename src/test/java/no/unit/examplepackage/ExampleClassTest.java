package no.unit.examplepackage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExampleClassTest {

    @DisplayName("setField should set the field value")
    @Test
    void setFieldSetsTheFieldValue() {
        String insertedValue = "SomeValue";
        ExampleClass exampleObj = new ExampleClass();
        exampleObj.setField(insertedValue);
        String actualValue = exampleObj.getField();
        assertThat(actualValue, is(equalTo(insertedValue)));
    }

    @DisplayName("getField returns null when value has not been set")
    @Test
    void getFieldSReturnsNullWhenValueHasNotBeenSet() {
        ExampleClass exampleObj = new ExampleClass();
        String actualValue = exampleObj.getField();
        assertThat(actualValue, is(nullValue()));
    }

    @DisplayName("getField returns the set value when the value has been set")
    @Test
    void getFieldReturnsTheSetValueWhenTheValueHasBeenSet() {
        String insertedValue = "SomeValue";
        ExampleClass exampleObj = new ExampleClass();
        exampleObj.setField(insertedValue);
        String actualValue = exampleObj.getField();
        assertThat(actualValue, is(equalTo(insertedValue)));
    }
}