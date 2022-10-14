package cn.czyx007.VO;

/**
 * @author : 张宇轩
 * @createTime : 2022/10/12 - 10:13
 */
public class Result {
    private String province;
    private Integer count;
    private String names;

    public Result() {
    }

    public Result(String province, Integer count, String names) {
        this.province = province;
        this.count = count;
        this.names = names;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Result{" +
                "province='" + province + '\'' +
                ", count=" + count +
                ", names='" + names + '\'' +
                '}';
    }
}
