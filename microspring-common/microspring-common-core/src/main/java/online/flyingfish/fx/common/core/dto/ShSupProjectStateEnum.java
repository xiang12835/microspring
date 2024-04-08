package online.flyingfish.fx.common.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @date 2022/7/13 11:54
 */

@Getter
@AllArgsConstructor
public enum ShSupProjectStateEnum {

    QUOTA_CONTRACT_SUCCESS("0", "额度合同生成"),
    BIZ_RULE_VERIFY_SUCCESS("1", "业务规则校验成功"),
    SAVED("2", "已保存"),
    FUllDATA_CHECK_SUCCESS("3", "全量校验成功"),
    MANAGER_REVIEW_SUCCESS("4", "部门经理审核成功"),
    MANAGER_REVIEW_FAIL("5", "部门经理审核失败"),
    PREREGIST_SUBMIT_SUCCESS("6", "预登记提交成功"),
    GUARANT_FEE_SUCCESS("7", "担保费提交成功"),
    LOAN_SUBMIT_SUCCESS("8", "放款成功"),
    PROJECT_CANCEL("9", "项目已解除"),
    PREREGIST_WITHDRAW("10", "预登记已撤回");

    //响应码
    private String code;

    //响应信息
    private String message;

}
