package com.k2data.kbc.security.login.service;

import com.k2data.kbc.auth.dao.UserMapper;
import com.k2data.kbc.auth.model.User;
import com.k2data.kbc.security.login.model.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> authorities = new HashSet<>();
        // 从数据库中取出用户信息
        User user = userMapper.getByName(username);
        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        /*List<Integer> usrgrpIds = userUsrgrpMapper.getUsrgrpIdsByUserId(user.getId());
        List<PermissionResponse> permissions = permmgrSevice.getPermissions(user.getId(), usrgrpIds);
        for (PermissionResponse permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission.getOperations()));
        }*/
        // 返回UserDetails实现类
        return new SecurityUserDetails(user.getName(), user.getPassword(), authorities);
    }
}
