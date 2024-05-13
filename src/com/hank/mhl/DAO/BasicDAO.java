package com.hank.mhl.DAO;

import com.hank.mhl.utils.UtilsBydruid;
import com.hank.mhl.utils.UtilsBydruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BasicDAO<T> {//泛型指定了DAO操作的对象类型
    private QueryRunner qr=new QueryRunner();
    public int update(String sql, Object... params)throws Exception {
        Connection conn = null;
        try {
            conn = UtilsBydruid.getConnection();
            return qr.update(conn, sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            UtilsBydruid.close(conn, null,null);
        }
    }

    public List<T> queryMulti(String sql,Class<T> clazz, Object... params) throws Exception {
        Connection conn = null;
        List<T> list = null;
        try {
            conn = UtilsBydruid.getConnection();
            list = qr.query(conn, sql, new BeanListHandler<>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            UtilsBydruid.close(conn, null,null);
        }
        return list;
    }
    public T querySingle(String sql,Class<T> clazz, Object... params) throws Exception {
        Connection conn = null;
        T t = null;
        try {
            conn = UtilsBydruid.getConnection();
            t = qr.query(conn, sql, new BeanHandler<>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            UtilsBydruid.close(conn, null,null);
        }
        return t;
    }
    public Object queryScalar(String sql, Object... params) throws Exception {
        Connection conn = null;
        Object obj = null;
        try {
            conn = UtilsBydruid.getConnection();
            obj = qr.query(conn, sql, new ScalarHandler(), params);
            //return qr.query(conn, sql, new ScalarHandler<Integer>(), params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            UtilsBydruid.close(conn, null,null);
        }
        return obj;
    }


}
