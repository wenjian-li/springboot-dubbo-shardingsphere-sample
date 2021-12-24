package com.sample.lwj.remote.service;

import java.io.Serializable;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 基类RPC接口
 * @date 2021/12/24 14:10
 */
public interface IBaseServiceRemote<T> {
    /**
     * 保存
     *
     * @param dto
     * @return
     */
    Boolean save(T dto);

    /**
     * 更新
     *
     * @param dto
     * @return
     */
    Boolean updateById(T dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean deleteById(Serializable id);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    T selectById(Serializable id);
}
