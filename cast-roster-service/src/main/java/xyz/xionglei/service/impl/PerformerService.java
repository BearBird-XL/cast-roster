package xyz.xionglei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xionglei.dao.IPerformerRepository;
import xyz.xionglei.model.PerformerModel;
import xyz.xionglei.service.IPerformerService;

@Service
public class PerformerService implements IPerformerService {


    @Autowired
    private IPerformerRepository iperformerRepository;

    @Override
    public PerformerModel listPerformer() {
        PerformerModel model = new PerformerModel();
        model.setOtherName("***");
        return model;
    }
}
