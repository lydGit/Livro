package lyd.github.livro.data.config;

/**
 * @author shawn
 * @date 17/12/13
 *
 * 数据库类名配置
 */

public class DataFieldConfig {

    /**
     * 一级分类
     */
    public static final String CO_ID = "co_id";
    public static final String CO_NAME = "co_name";
    public static final String CO_SORT = "co_sort";

    /**
     * 二级分类
     */
    public static final String CT_ID = "ct_id";
    public static final String CT_NAME = "ct_name";
    public static final String CT_SORT = "ct_sort";
    public static final String CT_CATEGORY_ID = "ct_category_id";   //所属一级分类ID


}
