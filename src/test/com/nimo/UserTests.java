package com.nimo;

import com.nimo.entity.TbUser;
import org.junit.Test;

public class UserTests {

    @Test
    public void test1() throws InterruptedException {
        TbUser tbUser = new TbUser();
        for (int i=0; i<3; i++){
            tbUser.setId("00"+i);
            new Thread(new AddUserTask(tbUser, i)).run();
            //Thread.sleep(1000);
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
