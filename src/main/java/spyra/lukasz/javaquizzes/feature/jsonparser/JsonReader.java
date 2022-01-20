package spyra.lukasz.javaquizzes.feature.jsonparser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class JsonReader {

    public List<QuizJson> jsonQuizReader(Path jsonPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        JsonNode jsonNode = mapper.readTree(jsonPath.toFile());
        return mapper.readValue(jsonNode.toString(), new TypeReference<>() {
        });
    }

}