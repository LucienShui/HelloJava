package ink.lucien.java.test.impl;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucien Shui on 2019/8/21.
 */

@Data
public class XspaceSessionRecommendRankDO implements Serializable {

    public XspaceSessionRecommendRankDO() {}

    public XspaceSessionRecommendRankDO(XspaceSessionRecommendDO xspaceSessionRecommendDO) {
        this.channelId = xspaceSessionRecommendDO.getChannelId();
        this.departmentId = xspaceSessionRecommendDO.getDepartmentId();
        this.tenantId = xspaceSessionRecommendDO.getTenantId();
        this.serviceTimeLen = xspaceSessionRecommendDO.getServiceTimeLen();
        this.evalSatName = xspaceSessionRecommendDO.getEvalSatName();
        this.createTime = xspaceSessionRecommendDO.getCreateTime();
        this.interveneTime = xspaceSessionRecommendDO.getInterveneTime();
        this.endTime = xspaceSessionRecommendDO.getEndTime();

        this.servicerId = xspaceSessionRecommendDO.getServicerId();
        this.servType = xspaceSessionRecommendDO.getServType();

        this.extAttrs = xspaceSessionRecommendDO.getExtAttrs();

        // 扩展字段
        this.userIdentity = xspaceSessionRecommendDO.getUserIdentity();
        this.levelId = xspaceSessionRecommendDO.getLevelId();

        // Recommend 字段
        this.labels = new ArrayList<>();
        this.score = 0;
        this.scoreList = new ArrayList<>();

        if (xspaceSessionRecommendDO.getServType().equals(HOTLINE_CHANNEL)) {
            hotlineInit(xspaceSessionRecommendDO);
        } else {
            imInit(xspaceSessionRecommendDO);
        }
    }

    private void hotlineInit(XspaceSessionRecommendDO xspaceSessionRecommendDO) {
        this.serviceCaseCount = xspaceSessionRecommendDO.getCallPickupCnt();
        this.onlineServiceTimeLen = xspaceSessionRecommendDO.getCallServiceLen();
        this.satSubmitCnt = xspaceSessionRecommendDO.getCallSepSatSubmitCnt();
        this.allSubmitCnt = xspaceSessionRecommendDO.getCallSepSubmitCnt();
        this.svySubmitSepSatisCnt = xspaceSessionRecommendDO.getCallSvySubmitSepSatisCnt();
        this.svySubmitSepCnt = xspaceSessionRecommendDO.getCallSvySubmitSepCnt();
        this.svySepBllzCnt = xspaceSessionRecommendDO.getCallSvySepBllzCnt();
        this.loginTimeLen = xspaceSessionRecommendDO.getCallLoginTime();
    }

    private void imInit(XspaceSessionRecommendDO xspaceSessionRecommendDO) {
        this.serviceCaseCount = xspaceSessionRecommendDO.getOnlineReadyCnt();
        this.onlineServiceTimeLen = xspaceSessionRecommendDO.getOnlineServiceTimeLen();
        this.satSubmitCnt = xspaceSessionRecommendDO.getOnlineSatCnt();
        this.allSubmitCnt = xspaceSessionRecommendDO.getOnlineSatCnt() +
                xspaceSessionRecommendDO.getOnlineNormalCnt() + xspaceSessionRecommendDO.getOnlineUnsatCnt();
        this.svySubmitSepSatisCnt = xspaceSessionRecommendDO.getOcsSvySubmitSepSatisCnt();
        this.svySubmitSepCnt = xspaceSessionRecommendDO.getOcsSvySubmitSepCnt();
        this.svySepBllzCnt = xspaceSessionRecommendDO.getOcsSvySepBllzCnt();
        this.loginTimeLen = xspaceSessionRecommendDO.getOcsOnineTime();
    }

    // 热线
    public static final String HOTLINE_CHANNEL = "555008";

    // 在线
    public static final String IM_CHANNEL = "C01";

    // 扩展字段需在最后扩展
    private static final long serialVersionUID = -7997314484627418775L;

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

    /**
     * 服务量
     * 热线：callPickupCnt
     * 在线：onlineReadyCnt
     */
    private Long serviceCaseCount;

    /**
     * 服务时长
     * 热线：callServiceLen
     * 在线：onlineServiceTimeLen
     */
    private Long onlineServiceTimeLen;

    /**
     * 即时评价满意数
     * 1. 热线：callSepSatSubmitCnt
     * 2. 在线：onlineSatCnt
     */
    private Long satSubmitCnt;

    /**
     * 即时评价参评数
     * 1. 热线：callSepSubmitCnt
     * 2. 在线：onlineSatCnt + onlineNormalCnt + onlineUnsatCnt
     */
    private Long allSubmitCnt;

    /**
     * 评价当天满意 touch 数量
     * 热线：callSvySubmitSepSatisCnt
     * 在线：ocsSvySubmitSepSatisCnt
     */
    private Long svySubmitSepSatisCnt;

    /**
     * 评价当天整体 touch 数量
     * 热线：callSvySubmitSepCnt
     * 在线：ocsSvySubmitSepCnt
     */
    private Long svySubmitSepCnt;

    /**
     * 勾选了不了了之量
     * 热线：callSvySepBllzCnt
     * 在线：ocsSvySepBllzCnt
     */
    private Long svySepBllzCnt;

    /**
     * 小二在线时长
     * 热线：callLoginTime
     * 在线：ocsOnineTime
     */
    private Long loginTimeLen;

    // 以下为扩展字段 通过额外的查询拿到

    // 0: 普通客服, 1: 专家
    private int userIdentity;

    // 等级 ID
    private long levelId;

    // 标签
    List<String> labels;

    // 评分
    private int score;

    // 评分的依据
    List<String> scoreList;
}
