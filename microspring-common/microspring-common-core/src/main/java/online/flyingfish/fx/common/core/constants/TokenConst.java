package online.flyingfish.fx.common.core.constants;


/**
 * 登陆相关常量类
 *
 * @date 2020/10/26
 * @since 1.0.0
 */
public class TokenConst {

    /***********************************response header************************************/
    //header中存token字段名
    public static final String TOKEN_INFO = "X-ER-UAT";

    /***********************************     Token     ************************************/
    /**
     * Token密钥
     */
    public static final String SECRET = "secret";
    /**
     * Token加密方式
     */
    public static final String ALG = "HS256";
    /**
     * 在线用户前缀
     */
    public static final String REDIS_ONLINE_USER_PREX = "onlineUser:";
    /**
     * 登出用户前缀
     */
    public static final String REDIS_OFFLINE_USER_PREX = "logoutToken:";
}
