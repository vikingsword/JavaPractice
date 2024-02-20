package top.vikingar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vikingar.domain.Message;
import top.vikingar.mapper.MessageMapper;
import top.vikingar.service.MessageService;

/**
 * @author vikingar
 * @time 2024/2/20 20:20
 * @description
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Integer unreadCount(Integer userId) {
        return messageMapper.unreadCount(userId);
    }

    

}
