package com.silentsunshine.blueprintsystem.vo.params;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhouqichun
 **/
@Data
@AllArgsConstructor
public class LoginParams {
    private String account;
    private String password;
}
