package ink.lucien.java.test;

import ink.lucien.java.test.impl.XspaceSessionRecommendRankDO;
import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lucien Shui on 2019/9/3.
 */
public class Main {

    private static String getStandardCase(Integer departmentId, String ds) {
        Date date = new Date();
        String beginDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(DateUtils.addDays(date, -5));
        String endDate = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);

        return "SELECT a.channel_id,\n" +
                "    a.department_id,\n" +
                "    a.tenant_id,\n" +
                "    a.service_time_len,\n" +
                "    a.eval_sat_name,\n" +
                "    a.create_time,\n" +
                "    a.intervene_time,\n" +
                "    a.end_time,\n" +
                "    b.servicer_id,\n" +
                "    b.serv_type,\n" +
                "    c.ext_attrs,\n" +
                "    c.call_pickup_cnt,\n" +
                "    c.online_ready_cnt,\n" +
                "    c.online_service_time_len,\n" +
                "    c.call_service_len,\n" +
                "    c.call_sep_sat_submit_cnt,\n" +
                "    c.call_sep_submit_cnt,\n" +
                "    c.call_unsat_submit_cnt,\n" +
                "    c.online_sat_cnt,\n" +
                "    c.online_normal_cnt,\n" +
                "    c.online_unsat_cnt,\n" +
                "    c.ocs_svy_submit_sep_satis_cnt,\n" +
                "    c.ocs_svy_submit_sep_cnt,\n" +
                "    c.ocs_svy_sep_bllz_cnt,\n" +
                "    c.call_svy_submit_sep_satis_cnt,\n" +
                "    c.call_svy_submit_sep_cnt,\n" +
                "    c.call_svy_sep_bllz_cnt,\n" +
                "    c.ocs_onine_time,\n" +
                "    c.call_login_time\n" +
                "FROM (\n" +
                "    SELECT  *\n" +
                "    FROM    crm_data.s_xspace_case_rec_di\n" +
                "    WHERE   create_time > '" + beginDate + "'\n" +
                "    AND     end_time < '" + endDate + "'\n" +
                "    AND     feedback_name = '满意'\n" +
                "    AND     ds > '" + ds + "'\n" +
                "    AND     department_id IN ('" + departmentId + "')\n" +
                "    LIMIT   8000\n" +
                ") AS a\n" +
                "LEFT JOIN (\n" +
                "    SELECT  *\n" +
                "    FROM    crm_cdm.dwd_tb_crm_cst_touch_di\n" +
                "    WHERE   ds > '" + ds + "'\n" +
                "    AND     department_id IN ('" + departmentId + "')\n" +
                ") AS b ON a.channel_id = b.serv_id\n" +
                "LEFT JOIN (\n" +
                "    SELECT *\n" +
                "    FROM    crm_cdm.ads_tb_crmcloud_servr_core_1d\n" +
                "    WHERE   ds > '" + ds + "'\n" +
                "    AND     department_id IN ('" + departmentId + "')\n" +
                ") AS c ON b.servicer_id = c.servicer_id;";
    }
    private static Long gao(String str) {
        if (str.equals("\\N")) {
            return -1L;
        }
        return Long.valueOf(str);
    }
    public static void main(String[] args) {
        // System.out.println(getStandardCase(168, "20190825"));
        List<XspaceSessionRecommendRankDO> xspaceSessionRecommendRankDOList = new ArrayList<>();
        XspaceSessionRecommendRankDO a = new XspaceSessionRecommendRankDO();
        XspaceSessionRecommendRankDO b = new XspaceSessionRecommendRankDO();
        xspaceSessionRecommendRankDOList.add(a);
        xspaceSessionRecommendRankDOList.add(b);

        a.setSvySubmitSepCnt(0L);
        b.setSvySubmitSepCnt(0L);
        a.setSvySubmitSepSatisCnt(0L);
        b.setSvySubmitSepSatisCnt(0L);

        xspaceSessionRecommendRankDOList.sort((x, y) -> {
            Long left = x.getSvySubmitSepSatisCnt() * y.getSvySubmitSepCnt();
            return left.compareTo(y.getSvySubmitSepSatisCnt() * x.getSvySubmitSepCnt());
        });
        xspaceSessionRecommendRankDOList.sort((x, y) -> {
            long left = x.getSvySubmitSepSatisCnt() * y.getSvySubmitSepCnt();
            long right = y.getSvySubmitSepSatisCnt() * x.getSvySubmitSepCnt();
            return Long.compare(left, right);
        });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello").append(" World!");
        System.out.println(stringBuilder.toString());
    }
}
