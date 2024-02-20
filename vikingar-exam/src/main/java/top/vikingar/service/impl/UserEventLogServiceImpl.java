package top.vikingar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.vikingar.domain.UserEventLog;
import top.vikingar.mapper.UserEventLogMapper;
import top.vikingar.service.UserEventLogService;

/**
 * @author vikingar
 * @time 2024/2/20 20:07
 * @description
 */
@Service
public class UserEventLogServiceImpl extends ServiceImpl<UserEventLogMapper, UserEventLog> implements UserEventLogService {

}
