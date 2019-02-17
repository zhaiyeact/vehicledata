package com.zhaiye.vehicle.data.common.constant;

public enum FixType {
    /**
     * 厂修
     */
    FACTORY_FIX(0,"厂修"),

    /**
     * 段修
     */
    SECTION_FIX(1,"段修"),

    /**
     * 无维修
     */
    NONE(2,"无维修");

    private Integer value;

    private String desc;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    FixType(Integer value,String desc) {
        this.value = value;
        this.desc = desc;
    }
}
