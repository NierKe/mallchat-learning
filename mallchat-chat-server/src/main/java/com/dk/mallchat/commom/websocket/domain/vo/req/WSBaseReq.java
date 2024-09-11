package com.dk.mallchat.commom.websocket.domain.vo.req;

import lombok.Data;

@Data
public class WSBaseReq {
    /**
     * @see com.dk.mallchat.commom.websocket.domain.enums.WSReqTypeEnum
     * */
    private Integer type;
    private String data;
}
