package po;

import java.util.List;

public class UserQueryVO {

    //�û���Ϣ
    private User user;

    //��ƷID����
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
