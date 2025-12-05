package com.spring.transaction.service;


import com.spring.transaction.entity.UserEntity;
import com.spring.transaction.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional(rollbackOn = Exception.class)
    public String transferMoneyBetweenAccount(Integer fromAccountId, Integer toAccountId, Double amount) throws Exception {
        try{

            UserEntity fromUser = userRepository.findById(fromAccountId).get();
            UserEntity toUser = userRepository.findById(toAccountId).get();
            Double totalAmountAfterAdd= toUser.getSalary()+amount;
            toUser.setSalary(totalAmountAfterAdd);
            userRepository.save(toUser);

            if(amount > fromUser.getSalary()){
                throw new Exception("Insufficient funds");
            }

            fromUser.setSalary(fromUser.getSalary()-amount);
            userRepository.save(fromUser);

            return "success";
        }catch (Exception e) {
            throw e;
        }
    }
}
