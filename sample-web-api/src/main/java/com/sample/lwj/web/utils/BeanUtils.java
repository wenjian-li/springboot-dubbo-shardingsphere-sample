package com.sample.lwj.web.utils;


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 对象转换工具
 * @date 2021/8/2 16:30
 */
public class BeanUtils {

    public static final Mapper DOZER_BEAN_MAPPER = new DozerBeanMapper();


    /**
     * 转换实体为另一个指定的实体
     * 任意一个参数为NULL时 会抛出NPE
     *
     * @param source 源实体 不能为NULL
     * @param clazz  目标实体 不能为NULL
     * @param <T>    泛型
     * @return 转换后的结果
     */
    @NonNull
    public static <T> T toBean(@NonNull Object source, @NonNull Class<T> clazz) {
        return Optional.ofNullable(source).map(bean -> DOZER_BEAN_MAPPER.map(source, clazz)).orElse(null);
    }

    /**
     * 转换List实体为另一个指定的实体
     * source如果为NULL 会使用空集合
     * 在目标实体为NULL时 会抛出NPE
     *
     * @param source 源集合 可以为NULL
     * @param clazz  目标实体 不能为NULL
     * @param <T>    泛型
     * @return 转换后的结果
     */
    @Nullable
    public static <T> List<T> toList(@Nullable List<?> source, @NonNull Class<T> clazz) {
        return Optional.ofNullable(source)
                .orElse(Collections.emptyList())
                .stream()
                .map(bean -> DOZER_BEAN_MAPPER.map(bean, clazz))
                .collect(Collectors.toList());
    }
}
