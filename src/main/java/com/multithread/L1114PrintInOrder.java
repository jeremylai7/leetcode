package com.multithread;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-09
 * @desc: 按序打印
 *
 * 示例 1:

输入: [1,2,3]
输出: "firstsecondthird"
解释:
有三个线程会被异步启动。
输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
正确的输出是 "firstsecondthird"。
 */
public class L1114PrintInOrder {

	@Test
	public void test() throws InterruptedException {
		Foo foo = new Foo();
		foo.first(new TestTask());
		foo.second(new TestTask());
		foo.third(new TestTask());

	}




}

class TestTask implements Runnable{

	@Override
	public void run() {
	}
}

class Foo{

	private static AtomicInteger atomicInteger = new AtomicInteger();

	public Foo() {}

	public void first(Runnable printFirst) throws InterruptedException{
		System.out.println("first");
		printFirst.run();
		atomicInteger.incrementAndGet();
	}

	public void second(Runnable printSecond) throws InterruptedException{
		while (atomicInteger.get() != 1) {

		}
		System.out.println("second");
		printSecond.run();
		atomicInteger.incrementAndGet();
	}

	public void third(Runnable printThird) throws InterruptedException{
		while (atomicInteger.get() != 2) {

		}
		System.out.println("third");
		printThird.run();
		atomicInteger.incrementAndGet();
	}

}
