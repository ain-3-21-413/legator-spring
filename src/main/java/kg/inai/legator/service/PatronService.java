package kg.inai.legator.service;

import kg.inai.legator.entity.patron.Patron;
import kg.inai.legator.entity.patron.PatronGroup;
import kg.inai.legator.model.patrons.PatronGroupModel;
import kg.inai.legator.model.patrons.PatronModel;

public interface PatronService {
    PatronGroup createPatronGroup(PatronGroupModel patronGroupModel);
    Patron createPatron(PatronModel patronModel);
    Patron editPatron(String id, PatronModel patronModel);
}
