package com.programs.thread;

/**
 * What is thread signalling.
 * There will be a common resource and more than one thread try
 * to access the resource.
 * 
 * Only one thread should access the resource and other threads 
 * should wait untill the other thread completes using the other resource.
 * 
 * To accomodate such a behaviour thread signalling is used.
 * 
 * Stuck: IllegalMontiorException => The thread is not the owner of the resource.
 * @author VineelaNagu
 *
 */
public class NGThreadSignallingComplex {
	
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
