package com.sender.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {

    public static final String MSGQUEUE="msg";
    public static final String EXCHANGE="ExchangeName";
    public static final String ROUTINGKEY="myRouteKey";

    @Bean
    public Queue queue(){
        return new Queue(MSGQUEUE);
    }


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bind(Queue queue,TopicExchange texchange) {
        return BindingBuilder.bind(queue).to(texchange).with(ROUTINGKEY);
    }

    @Bean
    public MessageConverter convertMessage(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory cfactory){
        RabbitTemplate rabbitTemp = new RabbitTemplate(cfactory);
        rabbitTemp.setMessageConverter(convertMessage());
        return rabbitTemp;
    }

}
