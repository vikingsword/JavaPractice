package top.vikingar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.vikingar.domain.Message;
import top.vikingar.service.MessageService;

/**
 * @author vikingar
 * @time 2024/2/20 20:20
 * @description
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
