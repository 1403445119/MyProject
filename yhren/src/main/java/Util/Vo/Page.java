package Util.Vo;

import lombok.Data;

/**
 * 分页对象
 */
@Data
public class Page {
    private int pageNum;    //当前页数
    private int pageSize;   //每页数量

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
