package com.dk.mallchat.commom.websocket.domain.vo.resp;

import lombok.Data;

@Data
public class WSBaseResp<T> {
    /**
    *  @see com.dk.mallchat.commom.websocket.domain.enums.WSRespTypeEnum
    * */
    private Integer type;
    private T data;
}
