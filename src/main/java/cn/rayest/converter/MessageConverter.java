package cn.rayest.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Rayest on 2016/11/9 0009.
 */
public class MessageConverter extends AbstractHttpMessageConverter<Message> {

    public MessageConverter() {
        // 自定义媒体类型 "application/rayest"
        super(new MediaType("application", "rayest", Charset.forName("UTF-8")));
    }

    // 表明只处理 Message 对象
    @Override
    protected boolean supports(Class<?> clazz) {
        return Message.class.isAssignableFrom(clazz);
    }

    // 处理请求的数据，处理由 - 隔开的数据，并转成 Message 对象
    @Override
    protected Message readInternal(Class<? extends Message> clazz, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArray = temp.split("-");
        return new Message(new Long(tempArray[0]), tempArray[1]);
    }

    // 处理如何输出数据到 response 中
    @Override
    protected void writeInternal(Message message, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + message.getId() + "-" + message.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
