package xyz.xionglei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import xyz.xionglei.domain.PerformerEntity;

public interface IPerformerRepository extends JpaRepository<PerformerEntity, String> {

}
