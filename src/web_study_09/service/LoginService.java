package web_study_09.service;

import web_study_09.dao.MemberDao;
import web_study_09.dao.impl.MemberDaoImpl;
import web_study_09.dto.Member;

public class LoginService {
    private MemberDao dao = MemberDaoImpl.getInstance();
    
    public Member getMember(Member member) {
        return dao.selectMemberByUserId(member);
    }
}
