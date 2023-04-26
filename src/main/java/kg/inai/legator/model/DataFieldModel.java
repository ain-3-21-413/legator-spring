package kg.inai.legator.model;

import java.util.List;

public record DataFieldModel(
	String tag,
	List<SubfieldModel> subfields
) {

}
