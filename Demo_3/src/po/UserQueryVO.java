package po;

import java.util.List;

public class UserQueryVO {

    //用户信息
    private User user;

    //商品ID集合
    private List<Integer> idlist;

    public List<Integer> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<Integer> idlist) {
        this.idlist = idlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
