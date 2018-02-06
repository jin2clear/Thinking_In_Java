package mytest;

import java.util.concurrent.CountDownLatch;

public class OrderService {

    public static void main(String[] args) {
        boolean canOrder = new OrderService().canOrder(111);
        if (canOrder){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public boolean canOrder(final int uid){
        final CountDownLatch counter = new CountDownLatch(3);
        final Boolean[] running = {Boolean.TRUE};
        final Thread[] t = new Thread[3];
        t[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!new RemotePassportService().checkAuth(uid)) {
                    running[0] = false;
                    t[1].interrupt();
                    t[2].interrupt();
                    counter.countDown();
                    counter.countDown();
                }
                counter.countDown();
            }
        });
        t[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!new RemoteBankService().checkCredit(uid)) {
                    running[0] = false;
                    t[0].interrupt();
                    t[2].interrupt();
                    counter.countDown();
                    counter.countDown();
                }
                counter.countDown();
            }
        });
        t[2] = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!new RemoteLoanService().checkRisk(uid)) {
                    running[0] = false;
                    t[0].interrupt();
                    t[1].interrupt();
                    counter.countDown();
                    counter.countDown();
                }
                counter.countDown();
            }
        });
        for (int i = 0; i < t.length; i++) {
            t[i].start();
        }
        try {
            counter.await();
            if(!running[0]){
                return false;
            } else {
                return true;
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
            return false;
        }
    }
}

class RemoteBankService{
    boolean success = false;

    boolean checkCredit(int uid){
        try{
            System.out.println("银行信用验证中......");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("银行信用验证终止");
            return false;
        }

        if (success){
            System.out.println("恭喜，银行信用验证成功！");
            return true;
        } else {
            System.out.println("抱歉，银行信用验证失败！");
            return false;
        }
    }
}

class RemoteLoanService{
    boolean success = false;

    boolean checkRisk(int uid){
        try{
            System.out.println("不良贷款验证中......");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.println("不良贷款验证终止");
            return false;
        }

        if (success){
            System.out.println("恭喜，不良贷款验证成功！");
            return true;
        } else {
            System.out.println("抱歉，不良贷款验证失败！");
            return false;
        }
    }
}

class RemotePassportService{
    boolean success = false;

    boolean checkAuth(int uid){
        try{
            System.out.println("黑名单验证中......");
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println("黑名单验证终止");
            return false;
        }

        if (success){
            System.out.println("恭喜，黑名单验证成功！");
            return true;
        } else {
            System.out.println("抱歉，黑名单验证失败！");
            return false;
        }
    }
}