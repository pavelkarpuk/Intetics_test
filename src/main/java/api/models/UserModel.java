package api.models;

import lombok.Data;
import utils.RandomUtil;

@Data
public class UserModel {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public static UserModel generate() {
        UserModel model = new UserModel();
        model.setId(RandomUtil.randomInteger());
        model.setUsername(RandomUtil.randomString());
        model.setFirstName(RandomUtil.randomString());
        model.setLastName(RandomUtil.randomString());
        model.setEmail(RandomUtil.randomString());
        model.setPassword(RandomUtil.randomString());
        model.setPhone(RandomUtil.randomString());
        model.setUserStatus(RandomUtil.randomInteger());
        return model;
    }
}
