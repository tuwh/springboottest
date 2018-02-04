package com.uncub.common.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultData<E> implements Cloneable, Serializable {
    Pagination pagination;

    private List<E> list = new ArrayList();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
