package achiev_submit;

import dao.*;
import entity.*;
import searchcriteria.VerifySearchCriteria;
import util.LoadEvid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MentorVerifyController {
    /**
     * 导师查看自己名下学生的审核申请
     */
    public void selectBySelf(String me_id) {
        VerifySearchCriteria criteria = new VerifySearchCriteria();
        List<Verify> verifies = new ArrayList<>();

        // 查询未审核的
        criteria.setFirst_verify(0);
        criteria.setLast_verify(0); // 因为用的是criteria具体实现的时候会把每个字段拼起来，entity里标识审核是否通过字段的默认值都是0
        verifies = DAOFactory.getInstance().getVerifyDAO().salectByMentorCriteria(me_id, criteria);
        System.out.println(verifies);

        // 查询导师已审核通过管理员未审核的
        criteria.setFirst_verify(1);
        criteria.setLast_verify(0);
        verifies = DAOFactory.getInstance().getVerifyDAO().salectByMentorCriteria(me_id, criteria);
        System.out.println(verifies);

        // 查询审核已通过的
        criteria.setFirst_verify(1);
        criteria.setLast_verify(1);
        verifies = DAOFactory.getInstance().getVerifyDAO().salectByMentorCriteria(me_id, criteria);
        System.out.println(verifies);

        // 查询导师审核未通过的
        criteria.setFirst_verify(-1);
        criteria.setLast_verify(0);
        verifies = DAOFactory.getInstance().getVerifyDAO().salectByMentorCriteria(me_id, criteria);
        System.out.println(verifies);

        // 查询管理员审核未通过的
        criteria.setFirst_verify(1);
        criteria.setLast_verify(-1);
        verifies = DAOFactory.getInstance().getVerifyDAO().salectByMentorCriteria(me_id, criteria);
        System.out.println(verifies);
    }


    /**
     * 导师审核
     */
    public void verifyAchiev(String ad_id, String achiev_no) {
        List result = new ArrayList<>();
        // 显示成果信息
        if(achiev_no.contains("TH")) {
            result = DAOFactory.getInstance().getThesisDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object thesis : result)
                LoadEvid.downloadEvid(((Thesis)thesis).getTh_evid());
        }
        if(achiev_no.contains("AW")) {
            result = DAOFactory.getInstance().getAwardDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object award : result)
                LoadEvid.downloadEvid(((Award) award).getAw_evid());
        }
        if(achiev_no.contains("ST")) {
            result = DAOFactory.getInstance().getStandardDAO().selectByNo(achiev_no);

            System.out.println(result);

            for (Object standard : result)
                LoadEvid.downloadEvid(((Standard) standard).getSt_evid());
        }
        if(achiev_no.contains("RE")) {
            result = DAOFactory.getInstance().getReportDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object report : result)
                LoadEvid.downloadEvid(((Report) report).getRe_evid());
        }
        if(achiev_no.contains("PA")) {
            result = DAOFactory.getInstance().getReportDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object report : result)
                LoadEvid.downloadEvid(((Report)report).getRe_evid());
        }
        if(achiev_no.contains("DE")) {
            result = DAOFactory.getInstance().getDevelopmentDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object achiev : result)
                LoadEvid.downloadEvid(((Development) achiev).getDe_evid());
        }
        if(achiev_no.contains("TE")) {
            result = DAOFactory.getInstance().getTextbookDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object achiev : result)
                LoadEvid.downloadEvid(((Textbook) achiev).getTe_evid());
        }
        if(achiev_no.contains("OT")) {
            result = DAOFactory.getInstance().getOtherDAO().selectByNo(achiev_no);
            System.out.println(result);

            for (Object achiev : result)
                LoadEvid.downloadEvid(((Other) achiev).getOt_evid());
        }

        // 审核通过
        List<Verify> verifies =  DAOFactory.getInstance().getVerifyDAO().selectByAchiev(achiev_no);
        for (Verify verify: verifies) {
            verify.setAd_id(ad_id);
            verify.setLast_verify(1);

            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            verify.setLast_time(s.format(date));

            DAOFactory.getInstance().getVerifyDAO().updateStatus(verify);
        }

        // 审核不通过
        for (Verify verify: verifies) {
            verify.setAd_id(ad_id);
            verify.setLast_verify(-1);

            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            verify.setLast_time(s.format(date));

            DAOFactory.getInstance().getVerifyDAO().updateStatus(verify);
        }
    }


}