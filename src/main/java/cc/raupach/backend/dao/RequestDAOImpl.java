package cc.raupach.backend.dao;

import org.springframework.stereotype.Component;

import cc.raupach.backend.entity.Request;
import cc.raupach.backend.util.GenericJpaDAOImpl;

@Component
public class RequestDAOImpl extends GenericJpaDAOImpl<Request, Integer> implements RequestDAO
{

}
