package kg.inai.legator.service;

import kg.inai.legator.model.ItemRecordModel;
import kg.inai.legator.model.cataloging.BibliographicRecordModel;

public interface CatalogingService {

    void createBibliographicRecord(BibliographicRecordModel bibliographicRecordModel);

    void editBibliographicRecord(Long id, BibliographicRecordModel bibliographicRecordModel);

    void createItemRecord(ItemRecordModel itemRecordModel);

    void editItemRecord(String id, ItemRecordModel itemRecordModel);
}

