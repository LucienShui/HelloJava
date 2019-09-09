package ink.lucien.java.test.impl;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lucien Shui on 2019/8/21.
 */

@Data
public class XspaceSessionRecommendDO implements Serializable {

    // 热线
    public static final String HOTLINE_CHANNEL = "555008";

    // 在线
    public static final String IM_CHANNEL = "C01";

    // 扩展字段需在最后扩展
    private static final long serialVersionUID = -4697622441946632870L;

    /* crm_data.s_xspace_case_rec_di */

    // 会话id
    private String channelId;

    // 部门id
    private String departmentId;

    // buid
    private String tenantId;

    // 服务时长
    private String serviceTimeLen;

    // 参评满意度
    private String evalSatName;

    // 创建时间
    private String createTime;

    // 接起时间
    private String interveneTime;

    // 结束时间
    private String endTime;

    /* crm_cdm.dwd_tb_crm_cst_touch_di */

    // 小二 ID
    private String servicerId;

    // 会话类型
    private String servType;

    /* crm_cdm.ads_tb_crmcloud_servr_core_1d */

    // case明细大字段
    private String extAttrs;

    // 热线接起量--直连+转交
    private Long callPickupCnt;

    // 在线服务量
    private Long onlineReadyCnt;

    // 在线服务时长
    private Long onlineServiceTimeLen;

    // 热线服务时长
    private Long callServiceLen;

    // 热线即时评价满意数
    private Long callSepSatSubmitCnt;

    // 热线即时评价参评数
    private Long callSepSubmitCnt;

    // 热线即时评价不满意数
    private Long callUnsatSubmitCnt;

    // 在线即时评价满意数
    private Long onlineSatCnt;

    // 在线即时评价一般数
    private Long onlineNormalCnt;

    // 在线即时评价不满意数
    private Long onlineUnsatCnt;

    // 在线-评价当天满意touch数量
    private Long ocsSvySubmitSepSatisCnt;

    // 在线-评价当天整体touch数量
    private Long ocsSvySubmitSepCnt;

    // 在线-勾选了不了了之量
    private Long ocsSvySepBllzCnt;

    // 热线-评价当天满意touch数量
    private Long callSvySubmitSepSatisCnt;

    // 热线-评价当天整体touch数量
    private Long callSvySubmitSepCnt;

    // 热线-勾选了不了了之量
    private Long callSvySepBllzCnt;

    // 在线-小二在线时长
    private Long ocsOnineTime;

    // 热线-小二在线时长（登陆时长-就餐时长-签入时长）
    private Long callLoginTime;

    // 以下为扩展字段 通过额外的查询拿到

    // 0: 普通客服, 1: 专家
    private int userIdentity;

    // 等级 ID
    private long levelId;

    // 标签
    List<String> labels;

    // 评分
    private int score;
}
