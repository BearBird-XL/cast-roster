package xyz.xionglei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xionglei.dao.IPerformerDao;
import xyz.xionglei.model.PerformerModel;
import xyz.xionglei.service.IPerformerService;

@Service
public class PerformerService implements IPerformerService {


    @Autowired
    private IPerformerDao iperformerDao;

    @Override
    public PerformerModel listPerformer() {
        PerformerModel model = new PerformerModel();
        model.setOtherName("***");
        return model;
    }
}
