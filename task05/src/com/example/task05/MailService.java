package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<ISendable<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>();

    @Override
    public void accept(ISendable<T> sendable) {
        mailBox.computeIfAbsent(sendable.getTo(), k -> new ArrayList<>()).add(sendable.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
