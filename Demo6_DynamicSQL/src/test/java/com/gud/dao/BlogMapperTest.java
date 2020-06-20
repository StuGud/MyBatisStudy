package com.gud.dao;

import com.gud.pojo.Blog;
import com.gud.utils.IDUtil;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by david.w on 2020/6/20.
 */

public class BlogMapperTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog=new Blog();
        blog.setId(IDUtil.getId());
        blog.setTitle("HelloWorld");
        blog.setAuthor("gud");
        blog.setCreateTime(new Date());
        blog.setViews(1234);

        blogMapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("blog1");
        blogMapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("blog2");
        blogMapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("blog3");
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap();
        map.put("title","blog1");
        map.put("author","gud");
        blogMapper.queryBlogIF(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap();
        map.put("title","blog1");
        blogMapper.queryBlogChoose(map);
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap();
        map.put("id","f57b29a306274072a9f41c77005fc9bd");
        map.put("title","blogNew!!");
        blogMapper.updateBlog(map);
        sqlSession.close();
    }
}