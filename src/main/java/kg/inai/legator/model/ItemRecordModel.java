package kg.inai.legator.model;

public record ItemRecordModel(
	String number,
    int bibliographicRecordId,
    int itemRecordStatusId,
    int accessLevel,
    String patronId
) {

}
