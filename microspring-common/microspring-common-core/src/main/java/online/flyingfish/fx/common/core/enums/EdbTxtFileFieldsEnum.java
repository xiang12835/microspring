package online.flyingfish.fx.common.core.enums;


/**
 * @Description EDB接收文件对应字段，用于获取txt文件字段
 * @date 2021年03月31日
 * @Version V1.0
 * @注意事项 无
 */
public enum EdbTxtFileFieldsEnum {

    //智能推荐图片文件字段名
    PUH_IMG_TSK_SPN_YOU_FIELD("PUH_IMG_TSK_SPN_YOU", new String[]{"recod_no", "img_url"}),
    PUH_IMG_TSK_TPF_YOU_FIELD("PUH_IMG_TSK_TPF_YOU", new String[]{"recod_no", "img_url"}),
    //弹窗任务内容文件字段
    PUH_CNT_TSK_SPN_YOU_FIELD("PUH_CNT_TSK_SPN_YOU", new String[]{"business_no", "path", "reach_date"}),
    //资源位内容文件字段
    PUH_CNT_TSK_TPF_YOU_FIELD("PUH_CNT_TSK_TPF_YOU", new String[]{"recod_no", "resource_id", "advertis_site", "reach_date", "skip_path"}),
    //站内信任务文件字段，create_time对应站内信文件的审批通过时间字段，update_time对应站内信文件的触达时间字段
    PUH_CNT_TSK_LTR_YOU_FIELD("PUH_CNT_TSK_LTR_YOU", new String[]{"business_no", "create_time", "title", "text", "update_time", "del_flag"}),
    //APP PUSH客户关系文件字段
    PUH_REL_TSK_PSH_YOU_FIELD("PUH_REL_TSK_PSH_YOU", new String[]{"cus_id", "business_no"}),
    //APP PUSH任务清单文件字段
    PUH_CNT_TSK_PSH_YOU_FIELD("PUH_CNT_TSK_PSH_YOU", new String[]{"business_no", "brief", "title", "reach_date"}),
    //云缴费文件
    CUP_PAY_TYPES_13_FIELD("CUP_PAY_TYPES_13", new String[] {"pay_code", "pay_type", "area_code"}),
    YOU_ORDER_DETAILS_FIELD("YOU_ORDER_DETAILS", new String[] {"order_id", "pay_item_no", "pay_uid", "pay_date", "pay_time", "pay_amount", "pay_status"});

    private String fileName;
    private String[] fields;


    EdbTxtFileFieldsEnum(String fileName, String[] fields) {
        this.fileName = fileName;
        this.fields = fields;
    }

    public String getFileName(){
        return fileName;
    }
    public String[] getFields(){
        return fields;
    }


    public static String[] byfileName(String fileName) {
        for(EdbTxtFileFieldsEnum field : EdbTxtFileFieldsEnum.values()){
            if(field.getFileName().equals(fileName)){
                return field.getFields();
            }
        }
        throw new RuntimeException("txt文件对应属性字段不存在");
    }




}
