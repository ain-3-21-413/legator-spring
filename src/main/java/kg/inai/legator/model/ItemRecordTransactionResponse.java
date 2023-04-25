package kg.inai.legator.model;

public record ItemRecordTransactionResponse(
	int ResponseStatus,
	String itemRecordTransactionType,
	boolean isSuccess,
	String description
) {

}
