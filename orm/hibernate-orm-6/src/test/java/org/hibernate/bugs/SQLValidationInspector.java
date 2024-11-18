package org.hibernate.bugs;

import org.hibernate.resource.jdbc.spi.StatementInspector;

public class SQLValidationInspector implements StatementInspector {
    private static String NEED_CONTAINS = null;
    private static boolean hasContainsSql = false;

    @Override
    public String inspect(String sql) {
        hasContainsSql = NEED_CONTAINS != null && sql.contains(NEED_CONTAINS);
        return sql;
    }

    public static boolean hasContainsSql() {
        return hasContainsSql;
    }

    public static void reset() {
        hasContainsSql = false;
        NEED_CONTAINS = null;
    }

    public static void setNeedContains(String needContains) {
        reset();
        NEED_CONTAINS = needContains;
    }

}