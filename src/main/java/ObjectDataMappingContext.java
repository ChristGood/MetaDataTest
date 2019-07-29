import java.util.HashMap;
import java.util.Map;

class ObjectDataMappingContext {

    private static Map<ObjectData, ObjectDataDto> objectDatas;

    static {
        objectDatas = new HashMap<>();
        objectDatas.put(ObjectData.OUIBUS, ObjectDataDto.OUIBUS);
        objectDatas.put(ObjectData.TGV, ObjectDataDto.TGV);
    }

    static ObjectData toDomain(ObjectDataDto objectDataDto) {
        return objectDatas
                .entrySet()
                .stream()
                .filter(entry -> objectDataDto.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    static ObjectDataDto toDto(ObjectData objectData) {
        return objectDatas.get(objectData);
    }
}
