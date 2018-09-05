package com.neusoft.Service;

import com.neusoft.bean.User;
import com.neusoft.mapper.ArticleMapper;
import com.neusoft.mapper.CommentInfoMapper;
import com.neusoft.mapper.UserMapper;
import com.neusoft.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSession sqlSession;
    private UserMapper userMapper;
    private ArticleMapper articleMapper;
    private CommentInfoMapper commentInfoMapper;
    public UserService(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
        commentInfoMapper = sqlSession.getMapper(CommentInfoMapper.class);
    }

    public int addUser(User user){
        User user1 = userMapper.isUserExist(user);
        if (user1 == null){
            return userMapper.addUser(user);
        }else{
            user.setId(user1.getId());
        }
        return 0;
    }
}
