package kg.inai.legator.model;

import java.util.List;

public record BibliographicRecordModel(
	Leader leader,
	List<ControlField> controlFields,
	List<DataField> dataFields
) {

}

record Leader(
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

record ControlField(
	String tag,
	String data
) {

}

record DataField(
	String tag,
	List<Subfield> subfields
) {

}

record Subfield(
	char code,
	String data
) {

}
