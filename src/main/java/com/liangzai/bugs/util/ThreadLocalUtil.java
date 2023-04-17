package com.liangzai.bugs.util;

import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author liangzaixiaoxia
 * @Date 2023/4/17
 * @Description ThreadLocal 工具类，封装为 map 格式
 */
public class ThreadLocalUtil {
    /**
     * thread local data 格式定义为 Map<String,object>,方便使用
     */
    private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(() -> new HashMap<>(8));

    /**
     * clear all threadLocal data
     */
    public static void clear() {
        threadLocal.remove();
    }

    /**
     * get all thread local data
     *
     * @return all thread local data(Map<String, Object>)
     */
    public static Map<String, Object> get() {
        return threadLocal.get();
    }

    /**
     * 使用注解忽略了 unchecked cast warning，并不代表完全杜绝了此类问题，调用时需仔细确认返回值类型
     *
     * @param key key
     * @param <T> 返回类型
     * @return value
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) threadLocal.get().get(key);
    }

    /**
     * 使用注解忽略了 unchecked cast warning，并不代表完全杜绝了此类问题，调用时需仔细确认返回值类型
     *
     * @param key          key
     * @param <T>          返回类型
     * @param defaultValue threadLocal 中无对应数据返回的默认值
     * @return value
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(String key, T defaultValue) {
        return (T) Optional.ofNullable(get(key)).orElse(defaultValue);
    }

    /**
     * 往 threadLocal 中添加数据，单条
     *
     * @param key   -
     * @param value -
     */
    public static void set(String key, Object value) {
        get().put(key, value);
    }

    /**
     * 往 threadLocal 中添加数据，可多条
     *
     * @param param -
     */
    public static void set(Map<String, Object> param) {
        get().putAll(param);
    }

    // ===========================下列与threadLocal无关======================================
    public static void setTraceId() {
        MDC.put("SOFA-TraceId", UUID.randomUUID().toString().replace("-", ""));
    }

    public static String getTraceId() {
        return MDC.get("SOFA-TraceId");
    }

    public static void setSpanId() {
        MDC.put("SOFA-SpanId", UUID.randomUUID().toString().replace("-", ""));
    }
}
