package com.shaolin.springcloud.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author leisl
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

      @TableId("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("user_id")
    private Integer userId;

    @TableField("org_id")
    private Long orgId;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PASSWORD = "password";

    public static final String USER_ID = "user_id";

    public static final String ORG_ID = "org_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
