package jason.springframework.jasonblog.dao;

import jason.springframework.jasonblog.entity.ArticleComment;
import jason.springframework.jasonblog.entity.ArticleCommentExample;
import java.util.List;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}