package cn.tycoding.admin.service.impl;

import cn.tycoding.admin.dto.PageBean;
import cn.tycoding.admin.entity.ArticleTags;
import cn.tycoding.admin.entity.Tags;
import cn.tycoding.admin.enums.ResultEnums;
import cn.tycoding.admin.exception.ResultException;
import cn.tycoding.admin.mapper.ArticleTagsMapper;
import cn.tycoding.admin.service.ArticleTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther TyCoding
 * @date 2018/10/22
 */
@Service
@SuppressWarnings("all")
@Transactional
public class ArticleTagsServiceImpl implements ArticleTagsService {

    @Autowired
    private ArticleTagsMapper articleTagsMapper;

    @Override
    public Long findAllCount() {
        return null;
    }

    @Override
    public List<ArticleTags> findAll() {
        return null;
    }

    @Override
    public PageBean findByPage(ArticleTags articleTags, int pageCode, int pageSize) {
        return null;
    }

    @Override
    public ArticleTags findById(long id) {
        return null;
    }

    @Override
    public void save(ArticleTags articleTags) {
        try {
            if (!exists(articleTags)) {
                articleTagsMapper.save(articleTags);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResultException(ResultEnums.INNER_ERROR);
        }
    }

    private boolean exists(ArticleTags articleTags) {
        return articleTagsMapper.exists(articleTags.getArticleId(), articleTags.getTagsId());
    }

    @Override
    public void update(ArticleTags articleTags) {

    }

    @Override
    public void delete(Long... ids) {

    }

    @Override
    public List<Tags> findByArticleId(long articleId) {
        return articleTagsMapper.findByArticleId(articleId);
    }

    @Override
    public void deleteByArticleId(long id) {
        try {
            if (exists(new ArticleTags(id, 0))) {
                articleTagsMapper.deleteByArticleId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResultException(ResultEnums.INNER_ERROR);
        }
    }

    @Override
    public void deleteByTagsId(long id) {
        try {
            if (exists(new ArticleTags(0, id))) {
                articleTagsMapper.deleteByTagsId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResultException(ResultEnums.INNER_ERROR);
        }
    }
}
