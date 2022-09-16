package com.onsuorce.trivia.api.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.onsuorce.trivia.entity.Question;

import java.io.IOException;

public class QuestionSerializer extends StdSerializer<Question> {

    public QuestionSerializer() {
        this(null);
    }

    public QuestionSerializer(Class<Question> t) {
        super(t);
    }

    @Override
    public void serialize(Question question, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {

    }
}
