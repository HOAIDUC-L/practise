package util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    // Mã hóa mật khẩu
    public static String hashPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Mật khẩu không thể rỗng");
        }
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Kiểm tra mật khẩu
    public static boolean checkPassword(String password, String hashed) {
        if (password == null || password.isEmpty() || hashed == null || hashed.isEmpty()) {
            throw new IllegalArgumentException("Mật khẩu hoặc mật khẩu đã mã hóa không thể rỗng");
        }
        return BCrypt.checkpw(password, hashed);
    }
}
