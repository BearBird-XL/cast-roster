package xyz.xionglei.service;

import xyz.xionglei.model.PerformerModel;

public interface IPerformerService {

    /**
     * 查询所有的Performer
     *
     * @return 所有的Performer
     */
    public PerformerModel listPerformer();
}
