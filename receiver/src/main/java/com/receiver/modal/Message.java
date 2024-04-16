package com.receiver.modal;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Message {
    private String mid;
    private String message;
    private Date date;
}
