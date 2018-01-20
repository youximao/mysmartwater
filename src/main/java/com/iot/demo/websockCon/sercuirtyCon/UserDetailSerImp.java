package com.iot.demo.websockCon.sercuirtyCon;


import com.iot.demo.dao.UserLoginReg;
import com.iot.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
@Service
public class UserDetailSerImp implements UserDetailsService {
    @Autowired
    UserLoginReg userLoginReg;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user=userLoginReg.findByName(s);
        if(user!=null){
            return user;
        }

        return null;
    }
}
