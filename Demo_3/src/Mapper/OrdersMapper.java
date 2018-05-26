package Mapper;

import po.OrdersExt;
import po.User;

import java.util.List;

public interface OrdersMapper {

    //一对一之resultType
    public List<OrdersExt> findOrdersAndUser();

    //一对一之resultMap
    public List<OrdersExt> findOrdersAndUserResultMap();

    //一对多
    public List<OrdersExt> findOrdersAndDetailRstMap();

    //多对多
    public List<User> findUserAndItemsRstMap();

    //延迟加载
    public List<OrdersExt> findOrderAndUserLazyLoading();
}
