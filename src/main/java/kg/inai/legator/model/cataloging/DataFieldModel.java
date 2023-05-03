package kg.inai.legator.model.cataloging;

import java.util.List;

public record DataFieldModel(
	String tag,
	List<SubfieldModel> subfields
) {

}
