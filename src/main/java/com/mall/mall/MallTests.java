/**
 * Copyright (C), 2020-2020
 * FileName: MallTests
 * Author:   Kingsman
 * Date:     2020/6/7 10:41
 * Description: 测试数据库
 */

package com.mall.mall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallTests {
    //注入数据源
    @Autowired
    private DataSource defaultDataSource;

    @Test
    public void datasourceTest() throws SQLException{
        Connection connection = defaultDataSource.getConnection();
        System.out.print("获取连接:");
        System.out.println(connection != null);
        connection.close();

    }
}

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试数据库〉
 *
 * @author Kingsman
 * @create 2020/6/7
 * @since 1.0.0
 */