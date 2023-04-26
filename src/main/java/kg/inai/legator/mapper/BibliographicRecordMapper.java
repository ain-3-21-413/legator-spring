package kg.inai.legator.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import kg.inai.legator.entity.bibliographicrecord.BibliographicRecord;
import kg.inai.legator.entity.bibliographicrecord.ControlField;
import kg.inai.legator.entity.bibliographicrecord.DataField;
import kg.inai.legator.model.BibliographicRecordModel;
import kg.inai.legator.model.ControlFieldModel;
import kg.inai.legator.model.DataFieldModel;
import kg.inai.legator.model.LeaderModel;
import kg.inai.legator.model.SubfieldModel;
import kg.inai.legator.entity.bibliographicrecord.Leader;
import kg.inai.legator.entity.bibliographicrecord.Subfield;

@Component
public class BibliographicRecordMapper implements Mapper<BibliographicRecord, BibliographicRecordModel> {

	@Override
	public BibliographicRecordModel toModel(BibliographicRecord entity) {
		Leader leader = entity.getLeader();
		List<ControlField> controlFields = entity.getControlFields();
		List<DataField> dataFields = entity.getDataFields();

		LeaderModel leaderModel = new LeaderModel(
			leader.getRecordLength(), 
			leader.getRecordStatus(), 
			leader.getTypeOfRecord(), 
			leader.getImplDefined1(), 
			leader.getCharCodingScheme(), 
			leader.getIndicatorCount(), 
			leader.getSubfieldCodeLength(), 
			leader.getBaseAddressOfData(), 
			leader.getImplDefined2(), 
			leader.getEntryMap()
		);

		List<ControlFieldModel> controlFieldModels = new ArrayList<>();
		for (ControlField controlField : controlFields) {
			ControlFieldModel controlFieldModel = new ControlFieldModel(
				controlField.getTag(), 
				controlField.getData()
			);
			controlFieldModels.add(controlFieldModel);
		}

		List<DataFieldModel> dataFieldModels = new ArrayList<>();
		for (DataField dataField : dataFields) {
			List<Subfield> subfields = dataField.getSubfields();
			List<SubfieldModel> subfieldModels = new ArrayList<>();
			for (Subfield subfield : subfields) {
				SubfieldModel subfieldModel = new SubfieldModel(
					subfield.getCode(), 
					subfield.getData()
				);
				subfieldModels.add(subfieldModel);
			}
			DataFieldModel dataFieldModel = new DataFieldModel(
				dataField.getTag(), 
				subfieldModels
			);
			dataFieldModels.add(dataFieldModel);
		}

		BibliographicRecordModel bibliographicRecordModel = new BibliographicRecordModel(
			leaderModel, 
			controlFieldModels, 
			dataFieldModels
		);

		return bibliographicRecordModel;
	}

	@Override
	public BibliographicRecord toEntity(BibliographicRecordModel model) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
	}

}
