package com.bpag.apigateway.services;

import com.bpag.apigateway.persistances.entities.Session;
import com.bpag.apigateway.persistances.repositories.ISessionRepository;
import com.bpag.apigateway.services.interfaces.ISessionService;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import com.bpag.apigateway.web.dtos.responses.SessionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SessionServiceImpl implements ISessionService {

    @Autowired
    private ISessionRepository repository;

    private final Random random = new Random();

    @Override
    public BaseResponse generatorSessionCode() {
        Set<String> existingCodes = getAllCodesInString();
        SessionResponse data = fromToSessionResponse(searchDuplicateCode(existingCodes));
        return BaseResponse.builder()
                .data(data)
                .message("Session Identification")
                .success(Boolean.TRUE)
                .sessionId(data.code())
                .httpStatus(HttpStatus.CONTINUE)
                .statusCode(100).build();
    }

    private Set<String> getAllCodesInString(){
        return repository
                .findAll()
                .stream()
                .map(this::from).collect(Collectors.toSet());
    }

    private Session searchDuplicateCode(Set<String> existingCodes){
        String rnd = generateCode();
        if (existingCodes.equals(rnd)){
            return searchDuplicateCode(existingCodes);
        }
        return repository.save(from(rnd));
    }

    private String from(Session code){
        return code.getCode();
    }

    private String generateCode(){
        List<String> codeInt = Arrays.asList("", "", "", "");
        codeInt = codeInt.stream()
                .map(i -> generateInt().toString())
                .collect(Collectors.toList());
        List<String> codeChar = Arrays.asList("", "", "", "");
        codeChar = codeChar.stream()
                .map(c -> generateChar().toString())
                .collect(Collectors.toList());
        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(codeInt);
        mergedList.addAll(codeChar);
        return String.join("", sort(mergedList));
    }

    private List<String> sort(List<String> code){
        Random r = new Random();
        for (int i = 0; i < code.size(); i++) {
            int j = r.nextInt(i + 1);
            String temp = code.get(i);
            code.set(i, code.get(j));
            code.set(j, temp);
        }
        return code;
    }

    private Integer generateInt(){
        return this.random.nextInt(10);
    }

    private Character generateChar(){
        return (char) (this.random.nextInt(26) + 'a');
    }

    private Session from(String code){
        Session sessionCode = new Session();
        sessionCode.setCode(code);
        return sessionCode;
    }

    private SessionResponse fromToSessionResponse(Session session){
        return new SessionResponse(
                session.getId(),
                session.getCode()
        );
    }

}