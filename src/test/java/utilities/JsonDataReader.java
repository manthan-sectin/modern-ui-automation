package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataReader {
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public static <T> List<T> readJsonArray(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), 
                TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
    }
    
    public static <T> T readJsonObject(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), clazz);
    }
}