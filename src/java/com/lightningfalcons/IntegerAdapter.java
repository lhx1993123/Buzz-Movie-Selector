
package com.lightningfalcons;

import java.io.IOException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;
import com.google.gson.TypeAdapter;

/**
 * The IngerAdapter for handling the type exception search function
 * in the RottenTomatoes class
 * @author Yufan
 */
public class IntegerAdapter extends TypeAdapter<Integer> {

    /**
     * read
     * @param reader JsonReader
     * @return 0 or null
     */
    @Override
    public Integer read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String val = reader.nextString();
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            System.out.println("Caught number format exception");
            return 0;
        }
    }

    /**
     * Write
     * @param write JsonWriter
     * @param Integer val an int
     */
    @Override
    public void write(JsonWriter writer, Integer val) throws IOException {
        if (val == null) {
            writer.nullValue();
            return;
        }
        writer.value(val);
    }
}
