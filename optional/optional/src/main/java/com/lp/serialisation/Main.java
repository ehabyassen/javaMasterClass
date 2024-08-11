package com.lp.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.IOException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        Sock sock = new Sock();
        sock.setType("Sport");
        sock.setSize(Optional.of(5));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        String result = objectMapper.writeValueAsString(sock);

        System.out.println(result);

        Sock deserialized = objectMapper.readValue(result, Sock.class);
        System.out.println(deserialized);
    }
}
