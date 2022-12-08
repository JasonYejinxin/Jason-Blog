package jason.springframework.jasonblog.entity;

import java.util.Date;

public class ArticleComment {
    private Long id;

    private Long articleId;

    private Long commantId;

    private Date createBy;

    private Boolean isEffective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCommantId() {
        return commantId;
    }

    public void setCommantId(Long commantId) {
        this.commantId = commantId;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }
}