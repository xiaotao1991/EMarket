package com.xiaotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 13725 on 2018/4/7.
 */
public class EasyUIDataGridResult implements Serializable {

    private long total;

    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
