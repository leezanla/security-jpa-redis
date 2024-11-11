/**
 * @author leezan
 * @Data 2024/11/4 9:59
 */
package cc.lz.securityjparedis.exception;

public class JwtExpireException extends RuntimeException {
    public JwtExpireException() {
        super();
    }

    public JwtExpireException(String message) {
        super(message);
    }
}
