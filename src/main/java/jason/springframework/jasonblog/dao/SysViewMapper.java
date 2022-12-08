package jason.springframework.jasonblog.dao;

import jason.springframework.jasonblog.entity.SysView;
import jason.springframework.jasonblog.entity.SysViewExample;
import java.util.List;

public interface SysViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysView record);

    int insertSelective(SysView record);

    List<SysView> selectByExample(SysViewExample example);

    SysView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysView record);

    int updateByPrimaryKey(SysView record);
}