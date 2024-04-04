package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUserDTOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUserRanksGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetUserAllBean {

    GetUserDAOBean getUserDAOBean;
    CreateUserDTOBean createUserDTOBean;

    @Autowired
    public GetUserAllBean(GetUserDAOBean getUserDAOBean, CreateUserDTOBean createUserDTOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.createUserDTOBean = createUserDTOBean;
    }

    // 전체 유저 랭킹 정보 가져오기
    public List<Map<Integer, ResponseUserRanksGetDTO>> exec(Long userId){

        // 유저 객체 가져오기
        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;

        // 시즌에 소속된 유저 점수 순으로 전부 가져오기
        List<UserDAO> userDAOS = getUserDAOBean.exec();

        return createUserDTOBean.exec(userId, userDAOS);
    }
}
