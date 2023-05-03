package kg.inai.legator.service;

import kg.inai.legator.model.ItemRecordTransactionModel;
import kg.inai.legator.model.circulation.OutModel;

public interface CirculationService {
    boolean checkOut(OutModel checkOutModel);

    boolean checkIn(String number);

    boolean hold(OutModel holdModel);

    boolean unhold(String number);

}


