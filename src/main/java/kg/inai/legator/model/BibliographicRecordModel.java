package kg.inai.legator.model;

import java.util.List;

public record BibliographicRecordModel(
	LeaderModel leader,
	List<ControlFieldModel> controlFields,
	List<DataFieldModel> dataFields
) {

}


