package com.nimo.service;

import com.nimo.dao.TbUserMapper;
import com.nimo.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private TbUserMapper tbUserMapper;

    public List<TbUser> list(){

        return tbUserMapper.selectUserList();

    }

    // @Transactional
    public void save() throws InterruptedException {
        TbUser tbUser = new TbUser();
        for (int i=0; i<3; i++){
            tbUser.setId("00"+i);
            new Thread(new AddUserTask(tbUser, i)).start();
            //Thread.sleep(100);
        }
    }


    class AddUserTask implements Runnable{
        TbUser tbUser;
        int i;
        AddUserTask(TbUser tbUser, int i){
            this.tbUser = tbUser;
            this.i = i;
            System.out.println("thread-" + i + "-构造方法   "+ tbUser.toString());
        }

        @Override
        public void run() {
            System.out.println("thread-" + i +"-run方法   "+ tbUser.toString());
        }
    }

}
