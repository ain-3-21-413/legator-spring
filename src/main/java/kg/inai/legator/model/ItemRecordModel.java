package kg.inai.legator.model;

public record ItemRecordModel(
        String number,
        long bibliographicRecordId,
        String itemRecordStatus,
        String accessLevel,
        String patronId

) {
}
