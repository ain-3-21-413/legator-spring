package kg.inai.legator.service.impl;

import kg.inai.legator.entity.bibliographicrecord.*;
import kg.inai.legator.model.ItemRecordModel;
import kg.inai.legator.model.cataloging.BibliographicRecordModel;
import kg.inai.legator.model.cataloging.ControlFieldModel;
import kg.inai.legator.model.cataloging.DataFieldModel;
import kg.inai.legator.model.cataloging.SubfieldModel;
import kg.inai.legator.repository.bibliographicrecord.BibliographicRecordRepository;
import kg.inai.legator.service.CatalogingService;
import lombok.RequiredArgsConstructor;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class CatalogingServiceImpl implements CatalogingService {

    private final BibliographicRecordRepository bibliographicRecordRepository;

    @Override
    public void createBibliographicRecord(BibliographicRecordModel bibliographicRecordModel) {
        bibliographicRecordRepository.save(
                BibliographicRecord.builder()
                        .leader(
                                Leader.builder()
                                        .baseAddressOfData(
                                                bibliographicRecordModel.leader().baseAddressOfData()
                                        )
                                        .implDefined1(
                                                bibliographicRecordModel.leader().implDefined1()
                                        )
                                        .implDefined2(
                                                bibliographicRecordModel.leader().implDefined2()
                                        )
                                        .charCodingScheme(
                                                bibliographicRecordModel.leader().charCodingScheme()
                                        )
                                        .entryMap(
                                                bibliographicRecordModel.leader().entryMap()
                                        )
                                        .recordLength(
                                                bibliographicRecordModel.leader().recordLength()
                                        )
                                        .recordStatus(
                                                bibliographicRecordModel.leader().recordStatus()
                                        )
                                        .typeOfRecord(
                                                bibliographicRecordModel.leader().typeOfRecord()
                                        )
                                        .indicatorCount(
                                                bibliographicRecordModel.leader().indicatorCount()
                                        )
                                        .subfieldCodeLength(
                                                bibliographicRecordModel.leader().subfieldCodeLength()
                                        )
                                        .build()
                        )
                        .controlFields(
                                bibliographicRecordModel.controlFields().stream()
                                        .map(controlFieldModel -> ControlField.builder()
                                                .tag(controlFieldModel.tag())
                                                .data(controlFieldModel.data())
                                                .build()
                                        )
                                        .toList()
                        )
                        .dataFields(
                                bibliographicRecordModel.dataFields().stream()
                                        .map(dataFieldModel -> DataField.builder()
                                                .tag(dataFieldModel.tag())
                                                .subfields(
                                                        dataFieldModel.subfields().stream()
                                                                .map(subfieldModel -> Subfield.builder()
                                                                        .code(subfieldModel.code())
                                                                        .data(subfieldModel.data())
                                                                        .build()
                                                                )
                                                                .toList()
                                                )
                                                .build()
                                        )
                                        .toList()
                        )
                        .build()
        );
    }

    @Override
    public void editBibliographicRecord(Long id, BibliographicRecordModel bibliographicRecordModel) {
        BibliographicRecord bibliographicRecord = bibliographicRecordRepository.findById(id).orElseThrow();
        bibliographicRecord.setLeader(
                Leader.builder()
                        .subfieldCodeLength(bibliographicRecordModel.leader().subfieldCodeLength())
                        .implDefined2(bibliographicRecordModel.leader().implDefined2())
                        .indicatorCount((bibliographicRecordModel.leader().subfieldCodeLength()))
                        .typeOfRecord((bibliographicRecordModel.leader().typeOfRecord()))
                        .recordStatus(bibliographicRecordModel.leader().recordStatus())
                        .entryMap(bibliographicRecordModel.leader().entryMap())
                        .build()
        );
    }

    @Override
    public void createItemRecord(ItemRecordModel itemRecordModel) {

    }

    @Override
    public void editItemRecord(String id, ItemRecordModel itemRecordModel) {

    }
}
