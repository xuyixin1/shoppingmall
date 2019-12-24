package com.vicmob.shoppingmall.web.distribution.service;

import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.web.distribution.dao.CustomerMapper;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.distribution.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    @Lazy
    CommissionRecordService commissionRecordService;

    public List<Customer> getCustomerListByOpenId(Set<String> openIds){
        return customerMapper.getCustomerListByOpenId(openIds);
    }

    public List<Customer> getCustomerList(Integer minaId,String nickName,Integer page,Integer size){
        PageHelper.startPage(page, size, "totalCommission desc");
        List<Customer> customerList =  customerMapper.getCustomerList(minaId, nickName);
        return customerList;
    }

    public Integer updateCommission(List<Customer> customers){
        return customerMapper.updateCommission(customers);
    }

    public Integer updateCommissionTotalCommission(String openId, BigDecimal commission){
        return customerMapper.updateCommissionTotalCommission(openId,commission);
    }

    public Customer getCustomerByCustomerId(Integer minaId,Integer customerId){
        Customer customer = customerMapper.getCustomerByCustomerId(minaId,customerId);
        if(customer == null){
            return customer;
        }
        BigDecimal unBookCommission = commissionRecordService.getUnBookCommission(minaId,customer.getOpenId());
        if(unBookCommission == null){
            unBookCommission = BigDecimal.ZERO;
        }
        customer.setUnBookCommission(unBookCommission);
        return customer;
    }

    public Customer getCustomerByOpenId(String openId,Integer minaId){
        return customerMapper.getCustomerByOpenId(openId,minaId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer updateApplyNumberAndCash(Integer minaId,String openId,BigDecimal cashApply){
        return customerMapper.updateApplyNumberAndCash(minaId,openId,cashApply);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer updateCommissionWithUnpassed(Integer minaId,String openId,BigDecimal cashApply){
        return customerMapper.updateCommissionWithUnpassed(minaId,openId,cashApply);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer updateCommissionWithPayed(Integer minaId,String openId,BigDecimal cashApply){
        return customerMapper.updateCommissionWithPayed(minaId,openId,cashApply);
    }

    public Integer clearCustomerApplyNumber(){
        return customerMapper.clearCustomerApplyNumber();
    }




}
