package com.programs.thread;

public class NGThreadSignallingSimple {
	
	public static void main(String args[]) {
		
		Runnable rscRunnable = new Runnable() {
			
			volatile Boolean isBusy = new Boolean(false);
			volatile Boolean allowSync = true;
			Integer resource = new Integer(0);
			
			public void run() {
				System.out.println("Running thread: " +Thread.currentThread().getName());
				waitForRsrc();
				resource();
				releaseRsrc();
			}

			public void waitForRsrc() {
				if(!isBusy) {
					synchronized(isBusy) {
						System.out.println("inside sync: " +Thread.currentThread().getName());
						while(!allowSync) {
							//infinite wait
							//System.out.println("waiting allowSYnc: " +allowSync);
						}
						allowSync = false;
						System.out.println("sync allowed for thread: " +Thread.currentThread().getName());
					}
				} else {
					synchronized(isBusy) {
						while(isBusy) {
							try {
								isBusy.wait();
							} catch(InterruptedException e) {
								
							}
						}
					}
				}
			}

			public void releaseRsrc() {
				isBusy = false;
				allowSync = true;
				System.out.println("allowing sync: " +allowSync);
				synchronized (isBusy) {
					System.out.println("releasing :D :D ");
					isBusy.notifyAll();
				}
			}

			public void resource() {
				System.out.println("Started Work: " +resource);
				try {
					Thread.sleep(1000L);
				} catch(InterruptedException e) {

				}
				System.out.println("Ended Work: " +resource);
				resource++;
			}

		};
		new Thread(rscRunnable, "Thread 1").start();
		new Thread(rscRunnable, "Thread 2").start();
	}
	
	
}
