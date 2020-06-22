package com.gud.dao;

import com.gud.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * Created by david.w on 2020/6/20.
 */

public interface BlogMapper {

    @Insert("insert into blog(id,title,author,create_time,views) values (#{id},#{title},#{author},#{createTime},#{views})")
    int addBlog(Blog blog);

    /**
     * 查询博客
     */
    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogChoose(Map map);

    /**
     * 更新博客
     */
    Integer updateBlog(Map map);

    /**
     * foreach的使用
     */
    List<Blog> queryBlogForEach(Map map);
}
