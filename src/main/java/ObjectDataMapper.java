public class ObjectDataMapper {

    public ObjectData toObjectData(ObjectDataDto objectDataDto) {
        return ObjectDataMappingContext.toDomain(objectDataDto);
    }
}
