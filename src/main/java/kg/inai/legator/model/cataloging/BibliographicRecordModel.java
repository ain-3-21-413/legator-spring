package kg.inai.legator.model.cataloging;

import java.util.List;

public record BibliographicRecordModel(
	LeaderModel leader,
	List<ControlFieldModel> controlFields,
	List<DataFieldModel> dataFields
) {

}


