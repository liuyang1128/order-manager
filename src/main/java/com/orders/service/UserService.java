package com.orders.service;

import com.orders.common.PageModel;
import com.orders.common.ServerResponse;
import com.orders.pojo.bo.IdAndNameBo;
import com.orders.pojo.dto.UserAndStoreDto;
import com.orders.pojo.dto.UserDto;
import com.orders.pojo.dto.UserUpdateDto;
import com.orders.pojo.po.User;
import com.orders.pojo.vo.EmployeeVo;
import com.orders.pojo.vo.UserVo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *Author:zhangxin_an
 *Description:
 *Data:Created in 21:26 2018/4/10
 */
public interface UserService {

    /*
     *Author:zhangxin_an
     *Description:查找用户
     *Data:Created in  .21:30 2018/4/10
     */

    User findUserByUserNme(String username);

    ServerResponse loginUser(String userName, String password, String ip);

    /*
     * @Author zhangxin_an
     * @Date 2018/4/15 8:27
     * @Params [userDto]
     * @Return ServerResponse
     * @Description:用户注册
     */
    void userRegister(UserAndStoreDto userAndStoreDto);

    ServerResponse checkUserName(String userName);
    
    ServerResponse checkPassword(String userName);

    ServerResponse getUserListByStoreId(String token);

    /*
     * @Author zhangxin_an
     * @Date 2018/4/25 8:47
     * @Params [userDto]
     * @Return ServerResponse
     * @Description:
     */
    ServerResponse<IdAndNameBo> addEmployee(UserDto userDto);

    /*
     * @Author zhangxin_an
     * @Date 2018/4/19 17:38
     * @Params []
     * @Return java.util.List<EmployeeVo>
     * @Description:获取员工
     */
    PageModel<EmployeeVo> getEmployeeList(PageModel pageModel,Integer deleteStatus);


    UserVo getUserInfo(Long id);
	
	void sendMs(String number);
    
    UserVo verifyPhoneCode(String phone, String code);
	
	void updateMyInfo(UserUpdateDto userDto);
    
    void deleteEmployee(Long id);
	
	void changeEmplyeeStatus(Long userId, Integer status);
    
    User getUserInfoByUserName(String userName);
}
