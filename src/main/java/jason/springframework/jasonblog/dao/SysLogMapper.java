package jason.springframework.jasonblog.dao;

import jason.springframework.jasonblog.entity.SysLog;
import jason.springframework.jasonblog.entity.SysLogExample;
import java.util.List;

public interface SysLogMapper extends SysService{
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}