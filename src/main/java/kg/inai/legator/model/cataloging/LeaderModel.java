package kg.inai.legator.model.cataloging;

public record LeaderModel(
	int recordLength,
    char recordStatus,
    char typeOfRecord,
    String implDefined1,
    char charCodingScheme,
    int indicatorCount,
    int subfieldCodeLength,
    int baseAddressOfData,
    String implDefined2,
    String entryMap
) {

}
