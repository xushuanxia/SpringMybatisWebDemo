package com.hc.domain;

/**
 * Created by Administrator on 2016/12/15.
 */

/**
 * 表示项目最新版本的需求
 */
public class Dept2 extends Dept{
    private String kouhao;
    private Integer yusuan;

    public String getKouhao() {
        return kouhao;
    }

    public void setKouhao(String kouhao) {
        this.kouhao = kouhao;
    }

    public Integer getYusuan() {
        return yusuan;
    }

    public void setYusuan(Integer yusuan) {
        this.yusuan = yusuan;
    }
}
