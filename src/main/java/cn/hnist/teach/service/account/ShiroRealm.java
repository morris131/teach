package cn.hnist.teach.service.account;

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

import cn.hnist.teach.entity.TeachUser;
import cn.hnist.teach.service.inter.ITeachUserService;

@Service
public class ShiroRealm extends AuthorizingRealm { 
	
	@Resource
	private ITeachUserService<TeachUser,String> teachUserService;
	
   /**
    * 角色验证
    */
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){  
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
        String userName = (String)super.getAvailablePrincipal(principals); 
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        
        TeachUser user = teachUserService.findOne(userName);
        
        if(null!=user){  
            info.addRole(user.getUserRole());  
            return info;  
        }else{
        	return null;  
        }
    }  
   
       
    /** 
     * 验证当前用户登录 
     */ 
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  

        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        
        TeachUser user = teachUserService.findOne(token.getUsername());
        
        if(null != user){
        	AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPassword(), getName());
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
