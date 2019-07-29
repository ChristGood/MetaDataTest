public class Main {

    private static ObjectDataMapper objectDataMapper = new ObjectDataMapper();

    public static void main(String[] args) {

        MetaDataDto metaDataDto = new MetaDataDto();
        MetaDataCodeDto metaDataCodeDto = new MetaDataCodeDto();
        metaDataCodeDto.setCode("test");
        metaDataDto.put(ObjectDataDto.OUIBUS, metaDataCodeDto);

        MetaData metaData = toMetaData(metaDataDto);
        System.out.println(((MetaDataCode) metaData.get(ObjectData.OUIBUS)).getCode());

    }

    private static MetaData toMetaData(MetaDataDto metaDataDto) {
        final MetaData metaData = new MetaData();
        metaDataDto.forEach((key, value) -> metaData.put(objectDataMapper.toObjectData(key), toMetaDataCode(value)));
        return metaData;
    }

    private static IMetaData toMetaDataCode(IMetaDataDto value) {
        MetaDataCode metaDataCode = new MetaDataCode();
        metaDataCode.setCode(((MetaDataCodeDto) value).getCode());
        return metaDataCode;
    }
}
