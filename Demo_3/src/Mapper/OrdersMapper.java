package Mapper;

import po.OrdersExt;
import po.User;

import java.util.List;

public interface OrdersMapper {

    //һ��һ֮resultType
    public List<OrdersExt> findOrdersAndUser();

    //һ��һ֮resultMap
    public List<OrdersExt> findOrdersAndUserResultMap();

    //һ�Զ�
    public List<OrdersExt> findOrdersAndDetailRstMap();

    //��Զ�
    public List<User> findUserAndItemsRstMap();

    //�ӳټ���
    public List<OrdersExt> findOrderAndUserLazyLoading();
}
