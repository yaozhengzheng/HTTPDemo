package com.example.httpdemo;

import java.io.Serializable;

/**
 * Created on 2017/12/18.
 * author ${yao}.
 */

public class GankResponse<T> implements Serializable {
    private static final long serialVersionUID = -686453405647539973L;

    public boolean error;
    public T results;
}
