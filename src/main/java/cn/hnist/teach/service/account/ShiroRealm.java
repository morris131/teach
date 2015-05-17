package cn.hnist.teach.service.account;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import cn.hnist.teach.entity.Role;
import cn.hnist.teach.entity.User;
import cn.hnist.teach.service.inter.IUserService;

@Service
public class ShiroRealm extends AuthorizingRealm { 
	
	@Resource
	private IUserService userService;
	
   /**
    * 角色验证
    */
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){  
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
    	 String username = (String)principals.getPrimaryPrincipal();
         
         System.out.println("授权:"+username);
         
         User user = userService.findByUsername(username);
         
         List<Role> roles = user.getRoles();
         
         Set<String> roleNames = new HashSet<String>(); 
         
         for (Role role : roles) {
 			roleNames.add(role.getName());
 		}

         SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
         authorizationInfo.setRoles(roleNames);
         
         return authorizationInfo;

    }  
   
       
    /** 
     * 验证当前用户登录 
     */ 
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  

        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        
        User user = userService.findByUsername(token.getUsername());
        
        if(null != user){
        	AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        	this.setSession("currentUser", user);
        	return info;
        }else{
        	return null;
        }
    }  
       
      
    /**
     * 
     * 方法描述:	将一些数据放到ShiroSession中,以便于其它地方使用 
     * 创 建 人:	Morris
     * 创建时间:	2015年3月7日 下午6:23:04
     * 	
     * @param key session中存放的对象名
     * @param value 要存放的对象
     */
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    }  
}
