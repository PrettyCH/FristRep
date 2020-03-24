package com.briup.demo.bean.ex;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户的拓展类，用springdata-api实现用户信息的存储和删除
 * @author Shinelon
 *
 */
@Entity
@Table(name="cms_customer")
public class CustomerEx {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

	    private String username;

	    private String password;

	    private static final long serialVersionUID = 1L;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username == null ? null : username.trim();
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password == null ? null : password.trim();
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(getClass().getSimpleName());
	        sb.append(" [");
	        sb.append("Hash = ").append(hashCode());
	        sb.append(", id=").append(id);
	        sb.append(", username=").append(username);
	        sb.append(", password=").append(password);
	        sb.append(", serialVersionUID=").append(serialVersionUID);
	        sb.append("]");
	        return sb.toString();
	    }
}
