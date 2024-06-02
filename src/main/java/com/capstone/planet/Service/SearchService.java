package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetSearchChatBean;
import com.capstone.planet.Bean.GetSearchPostBean;
import com.capstone.planet.Model.DTO.ResponseChatRoomGetDTO;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    GetSearchPostBean getSearchPostBean;
    GetSearchChatBean getSearchChatBean;

    @Autowired
    public SearchService(GetSearchPostBean getSearchPostBean, GetSearchChatBean getSearchChatBean) {
        this.getSearchPostBean = getSearchPostBean;
        this.getSearchChatBean = getSearchChatBean;
    }

    // 게시글 검색 조회
    public List<ResponsePostsGetDTO> getSearchPosts(String type, String search){
        return getSearchPostBean.exec(type, search);
    }

    // 쪽지함 검색 조회
    public List<ResponseChatRoomGetDTO> getSearchChatRooms(Long userId, String search){
        return getSearchChatBean.exec(userId, search);
    }
}
