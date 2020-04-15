package stateandbehavior;

public class StopWatch {
	
	private boolean started, stopped;
	private int startTime, lapTime, stopTime, time;
	
	boolean isStarted() {
		return started;
	}
	boolean isStopped() {
		return stopped;
	}
	
	int getTicks() {
		return time;
	}
	
	int getTime() {
		if (!started) return -1;
		else if (!stopped) return time-startTime;
		else return stopTime-startTime;
	}
	
	int getLapTime() {
		if(!started) return -1;
		else if (stopped) return 0;
		else return time-lapTime;
	}
	
	int getLastLapTime() {
		if (!started || lapTime == startTime) return -1;
		else if (stopped) return stopTime-lapTime;
		else return lapTime-startTime;
	}
	
	void tick(int ticks) {
		time += ticks;
	}
	
	void start() {
		started = true;
		startTime = time;
		lapTime = time;
	}
	
	void lap() {
		 lapTime = time;
	}
	
	void stop() {
		stopped = true;
		stopTime = time;
	}

	public static void main(String[] args) {
		
		StopWatch a = new StopWatch();
		a.start();
		a.tick(3);
		a.lap();
		System.out.println(a.getLapTime());
		System.out.println(a.getLastLapTime());
		System.out.println("Tick 2");
		a.tick(2);
		System.out.println(a.getTime());
		System.out.println(a.getLapTime());
		System.out.println(a.getLastLapTime());
		System.out.println("Stopping");
		a.stop();
		System.out.println(a.getTime());
		System.out.println(a.getLapTime());
		System.out.println(a.getLastLapTime());

	}

}
